package com.onlinepay.manage.web.platform.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.onlinepay.manage.service.IPlatformService;
import com.onlinepay.manage.service.IProductService;
import com.onlinepay.manage.service.entity.AdminUser;
import com.onlinepay.manage.service.entity.PlatformApi;
import com.onlinepay.manage.service.entity.ProductApi;
import com.onlinepay.manage.web.product.response.AddResponse;
import com.onlinepay.manage.web.system.enums.LoginEnums;

/**
 * TODO:
 * Created by tom on 17/8/29.
 */
@Controller
@RequestMapping("platform/product")
public class PlatformProductController {
    /**
     * 通道管理
     * 1、通道列表 显示所有通道
     * 2、添加通道
     * 3、修改通道
     * 4、关闭通道
     */
    @Autowired
    private IPlatformService platformService;
    @Autowired
    private IProductService productService;

    @RequestMapping("listpage")
    @ResponseBody
    public ModelAndView listdata(){
        ModelAndView mode = new ModelAndView("platform/platform-product-list");
        List<PlatformApi> platformApis = platformService.selectByEntity(new PlatformApi());
        mode.addObject("PlatformList",platformApis);
        List<ProductApi> list = productService.selectAll(new ProductApi());
        mode.addObject("ProductList",list);
        return mode;
    }
    @RequestMapping("update")
    public ModelAndView updatePage(HttpSession session,String channelNo){
        AdminUser user = (AdminUser)session.getAttribute(LoginEnums.LOGIN_KEY.getKey());
        ModelAndView modelAndView = new ModelAndView("platform/platform-edit");
        if("012".indexOf(user.getRoleType()) < 0){
            modelAndView.addObject("ChannelNo",user.getAdminNo());
        }else{
            modelAndView.addObject("ChannelNo",channelNo);
        }
        List<ProductApi> list = productService.selectAll(new ProductApi());
        modelAndView.addObject("ProductList",list);
        return modelAndView;
    }
    @RequestMapping("add")
    @ResponseBody
    public AddResponse add(ProductApi productApi){
        AddResponse addResponse = new AddResponse();
        addResponse.setCode("02");
        addResponse.setMsg("系统异常！");
        productApi.setCreateDate(new Date());
        productApi.setUpdateDate(new Date());
        productApi.setVersion((long)1);
        int i = productService.addProduct(productApi);
        if(i == 1){
            addResponse.setCode("00");
            addResponse.setMsg("OK");
        }
        return addResponse;
    }
    @RequestMapping("alldata")
    @ResponseBody
    public List<PlatformApi> allData(HttpSession session){
    	PlatformApi pojo = new PlatformApi();
        List<PlatformApi> channelApis = platformService.selectByEntity(pojo);
        return channelApis;
    }

}
