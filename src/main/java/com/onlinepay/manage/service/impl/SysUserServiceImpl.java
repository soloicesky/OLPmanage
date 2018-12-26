package com.onlinepay.manage.service.impl;

import com.onlinepay.manage.common.log.BaseLog;
import com.onlinepay.manage.common.page.JqueryPageInfo;
import com.onlinepay.manage.dao.organ.entity.Organ;
import com.onlinepay.manage.dao.user.IAdminUserDao;
import com.onlinepay.manage.dao.user.entity.SysUser;
import com.onlinepay.manage.service.IOrganService;
import com.onlinepay.manage.service.ISysUserService;
import com.onlinepay.manage.service.entity.AdminUser;
import com.onlinepay.manage.web.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO:
 * Created by tom on 17/7/5.
 */
@Service
public class SysUserServiceImpl extends BaseLog<SysUserServiceImpl> implements ISysUserService {

    @Autowired
    private IAdminUserDao adminUserDao;
    @Autowired
    private IOrganService organService;

    @Override
    public AdminUser selectLoginInfo(AdminUser user) {
        log().info("登录服务，登录账号[{}]-登录密码[{}]",user.getLoginName(),user.getLoginPwd());
        SysUser sysUser = new SysUser();
        sysUser.setLoginName(user.getLoginName());
        sysUser.setLoginPwd(user.getLoginPwd());
        sysUser.setIsDel("T");
        sysUser.setIsActivity("T");
        sysUser = adminUserDao.selectSysUser(sysUser);
        //查询无此用户直接返回
        if (sysUser == null) return null;
        //获取到用户信息后Copy properties
        log().info("登录结果，查询到的对象[{}]",sysUser);
        BeanUtils.copyProperties(sysUser,user);
        return user;
    }

    @Override
    public AdminUser selectUserByUser(AdminUser user) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(user,sysUser);
        sysUser = adminUserDao.selectSysUser(sysUser);
        if(sysUser == null) return null;
        user = new AdminUser();
        BeanUtils.copyProperties(sysUser,user);
        return user;
    }

    @Override
    public Map<String,Object> selectAll(AdminUser user) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(user,sysUser);
        List<SysUser> sysUsers = adminUserDao.selectAll(sysUser);
        List<AdminUser> list = new ArrayList<>();
        for(SysUser u : sysUsers){
            AdminUser au = new AdminUser();
            BeanUtils.copyProperties(u,au);
            list.add(au);
        }
        int count = adminUserDao.selectCount(sysUser);
        Map<String,Object> resMap = new HashMap<>();
        resMap.put("Data",list);
        resMap.put("Count",count);
        return resMap;
    }

    @Override
    public int insertAdminUser(AdminUser user) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(user,sysUser);
        int row = adminUserDao.insertAdminUser(sysUser);

        // 如果新增机构用户,则新增一个机构账户与之对应
        if(row == 1 && !StringUtil.isBlank(user.getRoleType()) && "7".equals(user.getRoleType())) {

            SysUser queryUser = new SysUser();
            queryUser.setNickName(user.getNickName());
            queryUser = adminUserDao.selectSysUser(queryUser);

            if(null != queryUser) {
                Organ organ = new Organ();
                organ.setName(user.getName());
                organ.setLogin_id(queryUser.getId());
                organ.setCreate_by(Integer.parseInt(user.getCreateUser()));
                organ.setOrgan_no(user.getOrgan_no());
                organService.add(organ);
            }

        }


        return row;
    }

    @Override
    public int updateUser(AdminUser user) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(user,sysUser);
        int row = adminUserDao.updateAdminUser(sysUser);
        return row;
    }

    @Override
    public JqueryPageInfo<AdminUser> selectAllByPage(JqueryPageInfo<AdminUser> pageInfo, AdminUser adminUser) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(adminUser,sysUser);
        List<SysUser> sysUsers = adminUserDao.selectPageByAdminUser(sysUser, pageInfo.getStart(), pageInfo.getLength());
        List<AdminUser> returnList = copyBean(sysUsers);
        pageInfo.setData(returnList);
        int count = adminUserDao.selectCount(sysUser);
        pageInfo.setRecordsFiltered((long)count);
        pageInfo.setRecordsTotal((long)count);
        return pageInfo;
    }

    private List<AdminUser> copyBean(List<SysUser> sysUsers){
        List<AdminUser> returnList = new ArrayList<>();
        for (SysUser sysUser : sysUsers){
            AdminUser adminUser = new AdminUser();
            BeanUtils.copyProperties(sysUser,adminUser);
            returnList.add(adminUser);
        }
        return returnList;
    }
}
