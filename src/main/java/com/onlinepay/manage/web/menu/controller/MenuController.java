package com.onlinepay.manage.web.menu.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.onlinepay.manage.service.ISysMenuService;
import com.onlinepay.manage.service.entity.AdminUser;
import com.onlinepay.manage.service.entity.ShowSysMenu;
import com.onlinepay.manage.web.menu.entity.TreeMode;
import com.onlinepay.manage.web.menu.res.MenuAddResponse;
import com.onlinepay.manage.web.menu.res.MenuResponse;
import com.onlinepay.manage.web.system.enums.LoginEnums;

/**
 * TODO:
 * Created by tom on 17/7/7.
 */
@Controller
@RequestMapping("menu")
public class MenuController {

    @Autowired
    private ISysMenuService sysMenuService;

    @RequestMapping("addpage")
    public ModelAndView page(){
        return new ModelAndView("menu/menu");
    }
    @RequestMapping("editpage")
    public ModelAndView addMenuPage(String pId, String id, HttpServletRequest request){
        request.setAttribute("id",id);
        request.setAttribute("pId",pId);
        return new ModelAndView("menu/menu-edit");
    }

    @RequestMapping("list")
    @ResponseBody
    public MenuResponse menuList(HttpSession session){
        AdminUser adminUser = (AdminUser)session.getAttribute(LoginEnums.LOGIN_KEY.getKey());
        MenuResponse response = new MenuResponse();
        Map<String, List<ShowSysMenu>> map = sysMenuService.selectMenu(adminUser);
        if(map == null){
            response.setCode("01");
            response.setMsg("获取菜单列表失败，请稍后重试！");
            return response;
        }
        List<TreeMode> list = new ArrayList<>();
        list.addAll(mapper(map.get("oneLevelMenu")));
        list.addAll(mapper(map.get("twoLevelMenu")));
        list.addAll(setAddButton(map.get("oneLevelMenu")));
        response.setCode("00");
        response.setMsg("OK");
        response.setData(list);
        return response;
    }
    private List<TreeMode> mapper(List<ShowSysMenu> list){
        List<TreeMode> treeModeList = new ArrayList<>();
        for (ShowSysMenu ssm: list) {
            TreeMode treeMode = new TreeMode();
            treeMode.setId(String.valueOf(ssm.getId()));
            treeMode.setpId(String.valueOf(ssm.getParentId()));
            treeMode.setName(ssm.getName());
            if(ssm.getParentId() == 0) {
                treeMode.setIsParent("true");
            }else {
                treeMode.setIsParent("false");
            }
            treeModeList.add(treeMode);
        }
        return  treeModeList;
    }
    private List<TreeMode> setAddButton(List<ShowSysMenu> list){
        List<TreeMode> treeModeList = new ArrayList<>();
        for (ShowSysMenu ssm: list) {
            TreeMode tm = new TreeMode();
            tm.setpId(String.valueOf(ssm.getId()));
            tm.setId("1102");
            tm.setName("点击添加同级菜单");
            tm.setIsParent("false");
            treeModeList.add(tm);
        }
        //添加已经菜单按钮
        TreeMode tm = new TreeMode();
        tm.setIsParent("false");
        tm.setName("点击添加一级菜单");
        tm.setId("1101");
        tm.setpId("0");
        treeModeList.add(tm);
        return treeModeList;
    }
    /**
     * 添加菜单
     * @param ssm
     * @param session
     * @return
     */
    @RequestMapping("add")
    @ResponseBody
    public MenuAddResponse add(ShowSysMenu ssm, HttpSession session){
        MenuAddResponse response = new MenuAddResponse();
        AdminUser user = (AdminUser)session.getAttribute(LoginEnums.LOGIN_KEY.getKey());
        sysMenuService.addMenu(ssm,user);
        response.setCode("00");
        response.setMsg("OK");
        return response;
    }
}
