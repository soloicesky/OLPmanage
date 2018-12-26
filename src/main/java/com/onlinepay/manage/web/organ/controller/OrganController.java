package com.onlinepay.manage.web.organ.controller;

import com.onlinepay.manage.common.log.BaseLog;
import com.onlinepay.manage.common.page.JqueryPageInfo;
import com.onlinepay.manage.dao.organ.entity.Organ;
import com.onlinepay.manage.dao.organ.entity.OrganAccount;
import com.onlinepay.manage.service.IOrganService;
import com.onlinepay.manage.service.entity.AdminUser;
import com.onlinepay.manage.web.organ.entity.OrganResponse;
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
    @RequestMapping("listPage")
    public ModelAndView listPage(){

        log().info("===商户列表查询===");
        return new ModelAndView("organ/organ-list");
    }

    /**
     * 机构商户明细页面
     * @param login_id
     * @param isReadOnly
     * @return
     */
    @RequestMapping("editPage")
    public ModelAndView editPage(String login_id, boolean isReadOnly){

        Organ organ = organService.getOrgan(Integer.parseInt(login_id));
        ModelAndView mod = new ModelAndView("organ/organ-edit");
        mod.addObject("organ", organ);
        mod.addObject("Url","editOrgan");
        mod.addObject("isReadOnly", isReadOnly);
        return mod;
    }

    @RequestMapping("accountPage")
    public ModelAndView accountPage(){

        log().info("===商户列表查询===");
        return new ModelAndView("organ/organ-account");
    }

    @RequestMapping("editOrgan")
    @ResponseBody
    public OrganResponse editOrgan(Organ organ, HttpSession session){

        return null;
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

    /**
     *  分页查询机构余额
     * @param pageInfo
     * @return
     */
    @RequestMapping("listAccountData")
    @ResponseBody
    public JqueryPageInfo<OrganAccount> listAccountData(JqueryPageInfo<OrganAccount> pageInfo, HttpSession session){

        // 当前用户
        AdminUser user = (AdminUser)session.getAttribute(LoginEnums.LOGIN_KEY.getKey());
        if(null != user) {
            OrganAccount organAccount = new OrganAccount();
            organAccount.setDel_flag(0);

            if("0".equals(user.getRoleType()))
                organAccount.setUpdate_by(0);
            else
                organAccount.setUpdate_by(user.getId());

            JqueryPageInfo<OrganAccount> jqueryPageInfo = organService.selectAccountPage(pageInfo, organAccount);
            return jqueryPageInfo;
        } else {
            pageInfo.setData(new ArrayList<>());
            pageInfo.setRecordsFiltered(0L);
            pageInfo.setRecordsTotal(0L);
            return pageInfo;
        }

    }

}
