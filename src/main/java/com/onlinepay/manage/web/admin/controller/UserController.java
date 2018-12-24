package com.onlinepay.manage.web.admin.controller;

import com.onlinepay.manage.common.log.BaseLog;
import com.onlinepay.manage.common.page.JqueryPageInfo;
import com.onlinepay.manage.dao.organ.entity.Organ;
import com.onlinepay.manage.service.IOrganService;
import com.onlinepay.manage.service.ISysMenuService;
import com.onlinepay.manage.service.ISysUserMenuService;
import com.onlinepay.manage.service.ISysUserService;
import com.onlinepay.manage.service.entity.AdminUser;
import com.onlinepay.manage.service.entity.ShowSysMenu;
import com.onlinepay.manage.web.admin.entity.AdminUserAddResponse;
import com.onlinepay.manage.web.admin.entity.PowerMenuResponse;
import com.onlinepay.manage.web.system.enums.LoginEnums;
import com.onlinepay.manage.web.util.ProjectUtil;
import com.onlinepay.manage.web.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * TODO:
 * Created by tom on 17/7/10.
 */
@Controller
@RequestMapping("admin/user")
public class UserController extends BaseLog<UserController>{

    @Autowired
    private ISysMenuService sysMenuService;
    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private ISysUserMenuService sysUserMenuService;
    @Autowired
    private IOrganService organService;

    @RequestMapping("list")
    public ModelAndView listPage(HttpSession session){
        return new ModelAndView("admin/user-list");
    }

    @RequestMapping("addpage")
    public ModelAndView addPage(String id,HttpServletRequest request, boolean isOrgan){
        if(isOrgan)
            request.setAttribute("isOrgan",isOrgan);

        request.setAttribute("IdUser",getUserById(id, isOrgan));
        return new ModelAndView("admin/user-edit");
    }

    /**
     * 分配权限
     * @param id
     * @param session
     * @param request
     * @return
     */
    @RequestMapping("power")
    public ModelAndView power(String id,HttpSession session,HttpServletRequest request, boolean isOrgan){
        AdminUser user;
        //登录角色,创建非商户直接取session的user
        if(isOrgan) {
            user = new AdminUser();
            user.setRoleType("7");
            user.setId(7);
        } else
            user = (AdminUser)session.getAttribute(LoginEnums.LOGIN_KEY.getKey());

        //菜单
        Map<String, List<ShowSysMenu>> map = sysMenuService.selectMenu(user);
        List<Integer> integerList = sysUserMenuService.selectAll(id);

        map.put("oneLevelMenu",setIsDel(map.get("oneLevelMenu"),integerList));
        map.put("twoLevelMenu",setIsDel(map.get("twoLevelMenu"),integerList));

        if(isOrgan)
            request.setAttribute("isOrgan",isOrgan);

        request.setAttribute("Menu",map);
        request.setAttribute("IdUser",getUserById(id, isOrgan));


        return new ModelAndView("admin/user-power");
    }

    private List<ShowSysMenu> setIsDel(List<ShowSysMenu> showSysMenus,List<Integer> integerList){
        List<ShowSysMenu> tempList = new ArrayList<>();
        for (ShowSysMenu ssm: showSysMenus){
            if (integerList == null || integerList.size() == 0){
                ssm.setIsDel("F");
            }else{
                for(Integer integer : integerList){
                    if(ssm.getId() == integer){
                        ssm.setIsDel("T");
                        break;
                    }else{
                        ssm.setIsDel("F");
                    }
                }
            }
            tempList.add(ssm);
        }
        return tempList;
    }

    @RequestMapping("power/edit")
    @ResponseBody
    public PowerMenuResponse editPower(String[] menuIdList,String id){
        PowerMenuResponse response = new PowerMenuResponse();
        if(id == null){
            response.setCode("01");
            response.setMsg("获取用户ID失败，请重试！");
            return response;
        }
        if(menuIdList == null || menuIdList.length == 0){
            response.setCode("03");
            response.setMsg("获取权限ID失败！");
            return response;
        }
        sysUserMenuService.updatePower(menuIdList,id);
        response.setCode("00");
        response.setMsg("OK");
        return response;
    }

    private AdminUser getUserById(String id, boolean isOrgan){
        //编辑ID
        if(id != null && !id.equals("")){
            AdminUser selectUser = new AdminUser();
            selectUser.setId(Integer.parseInt(id));
            selectUser.setIsDel("T");
            if(isOrgan)
                selectUser.setRoleType("7");
            else
                selectUser.setRoleType("14");

            AdminUser adminUser = sysUserService.selectUserByUser(selectUser);
            return adminUser;
        }
        return null;
    }

    @RequestMapping("listdata")
    @ResponseBody
    public JqueryPageInfo<AdminUser> list(JqueryPageInfo<AdminUser> pageInfo, AdminUser selectUser){
        if(selectUser.getNickName() != null && selectUser.getNickName().equals(""))
            selectUser.setNickName(null);
        selectUser.setIsDel("T");
//        Map<String, Object> stringObjectMap = sysUserService.selectAll(selectUser);
//        List<AdminUser> adminUsers = (List<AdminUser>)stringObjectMap.get("Data");
//        pageInfo.setData(adminUsers);
//        pageInfo.setRecordsTotal(Long.valueOf(stringObjectMap.get("Count").toString()));
//        pageInfo.setRecordsFiltered(Long.valueOf(stringObjectMap.get("Count").toString()));
        JqueryPageInfo<AdminUser> adminUserJqueryPageInfo = sysUserService.selectAllByPage(pageInfo, selectUser);
        return adminUserJqueryPageInfo;
    }

    /**
     *  只查询商户
     * @param pageInfo
     * @param selectUser
     * @return
     */
    @RequestMapping("listOrganData")
    @ResponseBody
    public JqueryPageInfo<AdminUser> listOrganData(JqueryPageInfo<AdminUser> pageInfo, AdminUser selectUser){
        if(selectUser.getNickName() != null && selectUser.getNickName().equals(""))
            selectUser.setNickName(null);
        selectUser.setIsDel("T");
        selectUser.setRoleType("7");
        JqueryPageInfo<AdminUser> adminUserJqueryPageInfo = sysUserService.selectAllByPage(pageInfo, selectUser);
        return adminUserJqueryPageInfo;
    }

    @RequestMapping("add")
    @ResponseBody
    public AdminUserAddResponse add(AdminUser adminUser, HttpSession session){
        AdminUser insUser = new AdminUser();
        insUser.setNickName(adminUser.getNickName());
        insUser.setLoginName(adminUser.getLoginName());
        insUser.setAdminNo("0");
        AdminUserAddResponse response = new AdminUserAddResponse();
        try{
            insUser.setLoginPwd(ProjectUtil.gePwd(adminUser.getLoginPwd()));
        }catch (Exception e){
            log().info("MD5加密用户密码异常，信息：" + e.getMessage());
            response.setCode("04");
            response.setMsg("系统错误");
        }
        insUser.setPhone(adminUser.getPhone());

        if(StringUtil.isBlank(adminUser.getRoleType()))
            insUser.setRoleType("1");
        else
            insUser.setRoleType(adminUser.getRoleType());

        insUser.setCreateTime(new Date());
        int row = sysUserService.insertAdminUser(insUser);
        if(row != 1){
            log().info("插入用户信息失败。");
            response.setCode("02");
            response.setMsg("添加用户信息失败，请稍后重试。");
        }else{
            // 如果新增机构用户,则新增一个机构账户与之对应
            if(!StringUtil.isBlank(adminUser.getRoleType()) && "7".equals(adminUser.getRoleType())) {

                AdminUser auser = new AdminUser();
                auser.setNickName(adminUser.getNickName());
                auser = sysUserService.selectUserByUser(auser);

                if(null != auser) {
                    // 当前用户
                    AdminUser user = (AdminUser)session.getAttribute(LoginEnums.LOGIN_KEY.getKey());
                    Organ organ = new Organ();
                    organ.setOffice_id(adminUser.getOffice_id());
                    organ.setLogin_id(auser.getId());
                    organ.setCreate_by(user.getId());
                    organ.setUpdate_by(user.getId());
                    organ.setRemarks(adminUser.getRemarks());
                    organService.add(organ);
                }

            }
            response.setCode("00");
            response.setMsg("OK");
        }
        return response;
    }

    @RequestMapping("update")
    @ResponseBody
    public AdminUserAddResponse update(AdminUser adminUser){
        AdminUserAddResponse response = new AdminUserAddResponse();
        if(adminUser.getLoginPwd()!=null){
            try {
                adminUser.setLoginPwd(ProjectUtil.gePwd(adminUser.getLoginPwd()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        sysUserService.updateUser(adminUser);
        response.setCode("00");
        response.setMsg("OK");
        return response;
    }

    @RequestMapping("check")
    @ResponseBody
    public String check(HttpServletRequest request,HttpSession session){
        AdminUser adminUserSession = (AdminUser)session.getAttribute(LoginEnums.LOGIN_KEY.getKey());
        Map<String,String[]> map = request.getParameterMap();
        Integer id = Integer.parseInt(request.getParameter("id"));
        String msg = null;
        for(Map.Entry<String,String[]> entry: map.entrySet()){
            if(msg != null){
                return msg;
            }
            AdminUser adminUser = new AdminUser();
            if(entry.getKey().equals("nickName")){
                adminUser.setNickName(entry.getValue()[0]);
                adminUser.setIsDel("T");
                AdminUser user = sysUserService.selectUserByUser(adminUser);
                if(id != -1){//修改操作
                    if(user != null && user.getId() != id){
                        msg = "名称已存在";
                    }else {
                        msg = "true";
                    }
                }else{//添加操作
                    if(user != null){
                        msg = "名称已存在";
                    }else {
                        msg = "true";
                    }
                }

            }
            if(entry.getKey().equals("loginName")){
                adminUser.setLoginName(entry.getValue()[0]);
                adminUser.setIsDel("T");
                AdminUser user = sysUserService.selectUserByUser(adminUser);
                if(id != -1){//修改操作
                    if(user != null && user.getId() != id){
                        msg =  "邮箱已存在";
                    }else {
                        msg =  "true";
                    }
                }else{//添加操作
                    if(user != null){
                        msg =  "邮箱已存在";
                    }else {
                        msg =  "true";
                    }
                }

            }
            if(entry.getKey().equals("loginPwd")){
                try {
                    String pwd = ProjectUtil.gePwd(entry.getValue()[0]);
                    if(!pwd.equals(adminUserSession.getLoginPwd())){
                        msg = "登陆密码错误";
                    }else{
                        msg = "true";
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return msg;
    }

}
