package com.onlinepay.manage.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinepay.manage.dao.usermenu.ISysUserMenuDao;
import com.onlinepay.manage.dao.usermenu.entity.SysUserMenu;
import com.onlinepay.manage.service.ISysUserMenuService;

/**
 * TODO:
 * Created by tom on 17/7/10.
 */
@Service
public class SysUserMenuServiceImpl implements ISysUserMenuService {

    @Autowired
    private ISysUserMenuDao sysUserMenuDao;

    @Override
    public boolean updatePower(String[] menuId, String id) {
        Integer userId = Integer.parseInt(id);
        //数据库已有的
        List<SysUserMenu> sourceHaveMenu = sysUserMenuDao.selectAll(userId);
        List<Integer> sourceHaveId = new ArrayList<>();
        for(SysUserMenu ssm:sourceHaveMenu){
            sourceHaveId.add(ssm.getMenuId());
        }
        //页面勾选的权限
        List<Integer> sourcePageId = new ArrayList<>();
        for(String str : menuId){
            Integer mId = Integer.parseInt(str);
            sourcePageId.add(mId);
        }
        //重叠权限。修改重叠权限为启用，数据库修改IsDel为T。
        List<Integer> retaList = new ArrayList<>();
        retaList.addAll(sourceHaveId);
        retaList.retainAll(sourcePageId);
        for(Integer mid : retaList){
            sysUserMenuDao.update("T",userId,mid);
        }
        //移除权限。修改要移除权限，数据库修改IsDel为F
        List<Integer> removeList = new ArrayList<>();
        removeList.addAll(sourceHaveId);
        removeList.removeAll(retaList);
        for(Integer mid : removeList){
            sysUserMenuDao.update("F",userId,mid);
        }
        //添加数据库没有的权限。数据库新增
        List<Integer> insertList = new ArrayList<>();
        insertList.addAll(sourcePageId);
        insertList.removeAll(retaList);
        for(Integer mid : insertList){
            sysUserMenuDao.insert(mid,userId);
        }
        return true;
    }

    @Override
    public List<Integer> selectAll(String userId) {
        //数据库已有的
        List<SysUserMenu> sourceHaveMenu = sysUserMenuDao.selectAll(Integer.parseInt(userId));
        List<Integer> integerList = new ArrayList<>();
        for(SysUserMenu sum : sourceHaveMenu){
            if(sum.getIsDel().equals("T")){
                integerList.add(sum.getMenuId());
            }
        }
        return integerList;
    }


}
