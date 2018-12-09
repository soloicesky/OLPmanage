package com.onlinepay.manage.web.product.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.onlinepay.manage.common.page.JqueryPageInfo;
import com.onlinepay.manage.service.IProductService;
import com.onlinepay.manage.service.entity.AdminUser;
import com.onlinepay.manage.service.entity.ProductApi;
import com.onlinepay.manage.web.product.response.AddResponse;
import com.onlinepay.manage.web.product.response.ListDateResponse;
import com.onlinepay.manage.web.system.enums.LoginEnums;

/**
 * TODO:
 * Created by tom on 17/8/15.
 */
@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    private IProductService productService;


    @RequestMapping("listpage")
    public ModelAndView listpage(){
        ModelAndView modelAndView = new ModelAndView("product/product-list");
        return modelAndView;
    }

    @RequestMapping("addpage")
    public ModelAndView addpage(String id){
        ModelAndView modelAndView = new ModelAndView("product/product-add");
        if(id != null && !id.equals("")){
            ProductApi productApi = new ProductApi();
            productApi.setId(Long.getLong(id));
            List<ProductApi> list = productService.selectAll(productApi);
            modelAndView.addObject("Product",list.get(0));
        }
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

    @RequestMapping("listdata")
    @ResponseBody
    public JqueryPageInfo<ProductApi> allDataToAjax(JqueryPageInfo<ProductApi> jqueryPageInfo, String createDate, String updateDate, String productName){
        ListDateResponse response = new ListDateResponse();
        response.setCode("02");
        response.setMsg("系统异常！");
        ProductApi productApi = new ProductApi();
        try {
            if(createDate != null && !createDate.equals(""))
                productApi.setCreateDate(new SimpleDateFormat("yyyy-MM-dd").parse(createDate));
            if(updateDate != null && !updateDate.equals(""))
                productApi.setUpdateDate(new SimpleDateFormat("yyyy-MM-dd").parse(updateDate));
            if(productName != null && !productName.equals(""))
                productApi.setProductName(productName);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JqueryPageInfo<ProductApi> productApiJqueryPageInfo = productService.selectByPage(jqueryPageInfo, productApi);
        return productApiJqueryPageInfo;
    }
    /**
     * 产品开通
     * @return
     */
    @RequestMapping("open")
    public ModelAndView openPage(HttpSession session,String channelNo){
        AdminUser user = (AdminUser)session.getAttribute(LoginEnums.LOGIN_KEY.getKey());
        ModelAndView modelAndView = new ModelAndView("product/product-open");
        if("012".indexOf(user.getRoleType()) < 0){
            modelAndView.addObject("ChannelNo",user.getAdminNo());
        }else{
            modelAndView.addObject("ChannelNo",channelNo);
        }
        List<ProductApi> list = productService.selectAll(new ProductApi());
        modelAndView.addObject("ProductList",list);
        return modelAndView;
    }
    @RequestMapping("update")
    public ModelAndView updatePage(HttpSession session,String channelNo){
        AdminUser user = (AdminUser)session.getAttribute(LoginEnums.LOGIN_KEY.getKey());
        ModelAndView modelAndView = new ModelAndView("product/product-update");
        if("012".indexOf(user.getRoleType()) < 0){
            modelAndView.addObject("ChannelNo",user.getAdminNo());
        }else{
            modelAndView.addObject("ChannelNo",channelNo);
        }
        List<ProductApi> list = productService.selectAll(new ProductApi());
        modelAndView.addObject("ProductList",list);
        return modelAndView;
    }

}
