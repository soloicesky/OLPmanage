package com.onlinepay.manage.web.organ.controller;

import com.onlinepay.manage.common.log.BaseLog;
import com.onlinepay.manage.common.page.JqueryPageInfo;
import com.onlinepay.manage.dao.organ.entity.Organ;
import com.onlinepay.manage.service.IOrganService;
import com.onlinepay.manage.service.entity.AdminUser;
import com.onlinepay.manage.web.system.enums.LoginEnums;
import com.onlinepay.manage.web.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * 机构商户控制层
 */
@Controller
@RequestMapping("organ")
public class OrganController extends BaseLog<OrganController> {


    @Autowired
    private IOrganService organService;

    /**
     * 机构商户列表
     * @return
     */
    @RequestMapping("list")
    public ModelAndView listPage(){

        log().info("===商户列表查询===");
        return new ModelAndView("organ/organ-list");
    }

    /**
     * 机构商户明细页面
     * @param id
     * @return
     */
    @RequestMapping("detailPage")
    public ModelAndView addPage(String id){

        ModelAndView mod = new ModelAndView("organ/organ-detail");
        mod.addObject("Url","addDetail");
        return mod;
    }

    @RequestMapping("balance")
    public ModelAndView balancePage(){

        log().info("===商户列表查询===");
        return new ModelAndView("organ/organ-balance");
    }

    /**
     *  分页查询机构余额
     * @param pageInfo
     * @return
     */
    @RequestMapping("listBalanceData")
    @ResponseBody
    public JqueryPageInfo<Organ> listBalanceData(JqueryPageInfo<Organ> pageInfo, HttpSession session){

        // 当前用户
        AdminUser user = (AdminUser)session.getAttribute(LoginEnums.LOGIN_KEY.getKey());
        if(null != user) {
            Organ organ = new Organ();
            organ.setDel_flag(0);
            if("0".equals(user.getRoleType()))
                organ.setLogin_id(0);
            else
                organ.setLogin_id(user.getId());

            JqueryPageInfo<Organ> jqueryPageInfo = organService.selectPage(pageInfo, organ);
            return jqueryPageInfo;
        } else {
            pageInfo.setData(new ArrayList<>());
            pageInfo.setRecordsFiltered(0L);
            pageInfo.setRecordsTotal(0L);
            return pageInfo;
        }

    }

    /**
     *  显示机构商户明细
     * @param id
     * @return
     */
    @RequestMapping("showDetail")
    @ResponseBody
    public AdminUser showDetail(String id){

        AdminUser user = new AdminUser();

        if(!StringUtil.isBlank(id)) {
            user.setId(Integer.parseInt(id));
            user.setNickName("iscast");
        }

        return user;
    }




}
