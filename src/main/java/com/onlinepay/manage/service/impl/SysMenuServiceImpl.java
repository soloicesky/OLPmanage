package com.onlinepay.manage.service.impl;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinepay.manage.common.log.BaseLog;
import com.onlinepay.manage.dao.menu.ISysMenuDao;
import com.onlinepay.manage.dao.menu.entity.SysMenu;
import com.onlinepay.manage.service.ISysMenuService;
import com.onlinepay.manage.service.entity.AdminUser;
import com.onlinepay.manage.service.entity.ShowSysMenu;

/**
 * TODO:
 * Created by tom on 17/7/7.
 */
@Service
public class SysMenuServiceImpl extends BaseLog<SysMenuServiceImpl> implements ISysMenuService {

    @Autowired
    private ISysMenuDao sysMenuDao;

    @Override
    public Map<String,List<ShowSysMenu>> selectMenu(AdminUser user) {
        List<SysMenu> sysMenus = sysMenuDao.selectSysMenu(user.getRoleType(), user.getId());
        if(sysMenus ==null) return null;
        List<ShowSysMenu> showSysMenus = new ArrayList<>();
        for (SysMenu sm : sysMenus) {
            ShowSysMenu ssm = new ShowSysMenu();
            BeanUtils.copyProperties(sm,ssm);
            showSysMenus.add(ssm);
        }
        return sortMenu(sysMenus);
    }

    @Override
    public int addMenu(ShowSysMenu ssm, AdminUser user) {
        SysMenu sm = new SysMenu();
        BeanUtils.copyProperties(ssm,sm);

        if(sm.getParentId() == null) sm.setParentId(0);
        try{
            int nextSort = sysMenuDao.selectNextSort(sm.getParentId());
            sm.setSort(nextSort);
            int row = sysMenuDao.insertSysMenu(sm);
            return row;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 拆分出1级和2级菜单并排序
     * @param sysMenus
     * @return
     */
    private Map<String,List<ShowSysMenu>> sortMenu(List<SysMenu> sysMenus){
        Map<String,List<ShowSysMenu>> map = new HashMap<>();
        List<ShowSysMenu>  oneLevelMenu = new ArrayList<>();
        List<ShowSysMenu>  twoLevelMenu = new ArrayList<>();
        for (SysMenu sm:sysMenus) {
            ShowSysMenu ssm = new ShowSysMenu();
            BeanUtils.copyProperties(sm,ssm);
            if (sm.getLevel().equals("O")){
                oneLevelMenu.add(ssm);
            }
            if (sm.getLevel().equals("T")){
                twoLevelMenu.add(ssm);
            }
        }
        Collections.sort(oneLevelMenu,new SortMenuList());
        Collections.sort(twoLevelMenu,new SortMenuList());
        map.put("oneLevelMenu",oneLevelMenu);
        map.put("twoLevelMenu",twoLevelMenu);
        return map;
    }
    class SortMenuList implements Comparator<ShowSysMenu>{

        @Override
        public int compare(ShowSysMenu o1, ShowSysMenu o2) {
            if(o1.getSort() > o2.getSort())
                return 1;
            return -1;
        }
    }
}
