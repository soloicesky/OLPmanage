package com.onlinepay.manage.web.channel.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.onlinepay.manage.common.log.BaseLog;
import com.onlinepay.manage.common.page.JqueryPageInfo;
import com.onlinepay.manage.service.IChannelProductService;
import com.onlinepay.manage.service.IChannelRouteInfoService;
import com.onlinepay.manage.service.IChannelService;
import com.onlinepay.manage.service.IPlatformProductService;
import com.onlinepay.manage.service.IProductService;
import com.onlinepay.manage.service.entity.AdminUser;
import com.onlinepay.manage.service.entity.ChannelApi;
import com.onlinepay.manage.service.entity.ChannelProductApi;
import com.onlinepay.manage.service.entity.ChannelRouteInfoApi;
import com.onlinepay.manage.service.entity.PlatformProductApi;
import com.onlinepay.manage.service.entity.ProductApi;
import com.onlinepay.manage.web.channel.res.ChannelProductRes;
import com.onlinepay.manage.web.system.enums.LoginEnums;

/**
 * TODO:
 * Created by tom on 17/8/18.
 */
@Controller
@RequestMapping("channel/product")
public class ChannelProductController extends BaseLog<ChannelProductController>{

    @Autowired
    private IChannelProductService channelProductService;
    @Autowired
    private IChannelService channelService;
    @Autowired
    private IChannelRouteInfoService channelRouteInfoService;
    @Autowired
    private IProductService productService;
    @Autowired
    private IPlatformProductService platformProductService;

    @RequestMapping("add")
    @ResponseBody
    public ChannelProductRes addChannelProdouct(ChannelProductApi channelProductApi){
    	ChannelProductRes res = new ChannelProductRes();
    	
         if(channelProductApi.getT0Rate()!=null){
        	BigDecimal t0Rate = new BigDecimal(channelProductApi.getT0Rate());
         	channelProductApi.setT0Rate(t0Rate.doubleValue()+"");
         }
         if(channelProductApi.getT1Rate()!=null){
        	BigDecimal t1Rate = new BigDecimal(channelProductApi.getT1Rate());
         	channelProductApi.setT1Rate(t1Rate.doubleValue()+"");
         }else{
        	 channelProductApi.setT1Rate("0.00");
         }
        res.setCode("02");
        res.setMsg("系统异常！");
        ChannelProductApi channelProductApi1 = new ChannelProductApi();
        channelProductApi1.setChannelNo(channelProductApi.getChannelNo());
        channelProductApi1.setProductId(channelProductApi.getProductId());
        List<ChannelProductApi> channelProductApis = channelProductService.selectAll(channelProductApi);
       if(channelProductApis.size()!=0){
            channelProductApi.setCreateDate(new Date());
            channelProductApi.setUpdateDate(new Date());
            channelProductApi.setVersion((long)1);
            ChannelApi ca = new ChannelApi();
            ca.setChannelNo(channelProductApi.getChannelNo());
            List<ChannelApi> channelApis = channelService.selectByEntity(ca);
            channelProductApi.setChannelId(channelApis.get(0).getId());
            System.out.println(channelApis.get(0).getId()+"====channelId");
            int i = channelProductService.updateChannelProduct(channelProductApi);
//            int i1= addChannelRouteInfo(channelProductApi);
            if(i == 1){
                res.setCode("00");
                res.setMsg("操作成功");
            }
        }else{
	        channelProductApi.setCreateDate(new Date());
	        channelProductApi.setUpdateDate(new Date());
	        channelProductApi.setVersion((long)1);
	        ChannelApi ca = new ChannelApi();
	        List<ChannelApi> channelApis = channelService.selectByEntity(ca);
	        channelProductApi.setChannelId(channelApis.get(0).getId());
	        int i = channelProductService.addChannelProduct(channelProductApi);
	        int i1= addChannelRouteInfo(channelProductApi);
	        if(i == 1 && i1 == 1){
	            res.setCode("00");
	            res.setMsg("操作成功");
	        }
        }
        return res;
    }
    @RequestMapping("update")
    @ResponseBody
    public ChannelProductRes updateChannelProdouct(ChannelProductApi channelProductApi){
        ChannelProductRes res = new ChannelProductRes();
        res.setCode("02");
        res.setMsg("系统异常！");
        channelProductApi.setCreateDate(new Date());
        channelProductApi.setUpdateDate(new Date());
        channelProductApi.setVersion((long)1);
       
        if(channelProductApi.getT0Rate()!=null){
        	Double t0Rate = Double.valueOf(channelProductApi.getT0Rate());
        	channelProductApi.setT0Rate(t0Rate.toString());
        }
        if(channelProductApi.getT1Rate()!=null){
        	Double t1Rate = Double.valueOf(channelProductApi.getT1Rate());
        	channelProductApi.setT1Rate(t1Rate.toString());
        }
        ChannelApi ca = new ChannelApi();
        ca.setChannelNo(channelProductApi.getChannelNo());
        List<ChannelApi> channelApis = channelService.selectByEntity(ca);
        channelProductApi.setChannelId(channelApis.get(0).getId());
        int i = channelProductService.updateChannelProduct(channelProductApi);
//        int i1= addChannelRouteInfo(channelProductApi);
//        if(i == 1 && i1 == 1){
            if(i == 1){
            res.setCode("00");
            res.setMsg("OK");
        }
        return res;
    }
    /**
     * 查询渠道商已开通的产品
     * @param channelNo
     * @return
     */
    @RequestMapping("selectopen")
    @ResponseBody
    public List<ChannelProductApi> hasOpenProduct(String channelNo){
        ChannelProductApi channelProductApi = new ChannelProductApi();
        channelProductApi.setChannelNo(channelNo);
        List<ChannelProductApi> channelProductApis = channelProductService.selectAll(channelProductApi);
        for(int i=0;i<channelProductApis.size();i++){
        	///*BigDecimal fixT0Fee = new BigDecimal(channelProductApis.get(i).getFixT0Fee());
        	//channelProductApis.get(i).setFixT0Fee((long) (channelProductApis.get(i).getFixT0Fee()*0.01));
        	BigDecimal t0Rate = new BigDecimal(channelProductApis.get(i).getT0Rate());
        	channelProductApis.get(i).setT0Rate(t0Rate.multiply(new BigDecimal(100)).stripTrailingZeros().toPlainString());
        	BigDecimal t1Rate = new BigDecimal(channelProductApis.get(i).getT1Rate());
        	channelProductApis.get(i).setT1Rate(t1Rate.multiply(new BigDecimal(100)).stripTrailingZeros().toPlainString());
        }
        return channelProductApis;
    }
    /**
     * 跳转查询所有渠道商已开通的产品的页面
     * @param channelNo
     * @return
     */
    @RequestMapping("list")
    public ModelAndView listPage(String id,HttpSession session,HttpServletRequest request){
   
    	AdminUser addAgentUser1 = (AdminUser) session.getAttribute("adminUser");
//     	System.out.println(addAgentUser1.getAdminNo()+"###"+addAgentUser1.getDownCustomerId());
    	request.setAttribute("user",addAgentUser1 );
        if(id != null && id != ""){
        	ChannelApi channelApi = new ChannelApi();
            channelApi.setId(Long.getLong(id));
            List<ChannelApi> channelApis = channelService.selectByEntity(channelApi);
            request.setAttribute("Channel",channelApis.get(0));
        }
        return new ModelAndView("product/channel-list-open-product");
    }
    /**
     * 查询所有渠道商已开通的产品
     * @param channelNo
     * @return
     */
    @RequestMapping("selectOpenList")
    @ResponseBody
    public JqueryPageInfo<ChannelApi> hasAllChannelOpenProduct(JqueryPageInfo<ChannelApi> jqueryPageInfo,
            String beginTime,String endTime,String nickName,String channelNo, String level,String downCustomerId,HttpSession session){
        	ChannelApi merchantApi = new ChannelApi();
            try {
                if (beginTime != null && !beginTime.equals("")){
                    merchantApi.setCreateDate(new SimpleDateFormat("yyyy-MM-dd").parse(beginTime));
                }
                if (endTime != null && !endTime.equals("")){
                    merchantApi.setUpdateDate(new SimpleDateFormat("yyyy-MM-dd").parse(endTime));
                }
                if (nickName != null && !nickName.equals("")){
                    merchantApi.setName(nickName);
                }
                if (channelNo != null && !channelNo.equals("")){
                	merchantApi.setChannelNo(channelNo);
                }
                if (level != null && !level.equals("0")&& !level.equals("")){
                    merchantApi.setLevel(Integer.valueOf(level));
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

            //登录角色
            AdminUser user = (AdminUser)session.getAttribute(LoginEnums.LOGIN_KEY.getKey());
            if("012".indexOf(user.getRoleType()) < 0){
                merchantApi.setAddAgentUserId(user.getAdminNo());
            }
            JqueryPageInfo<ChannelApi> merchantApiJqueryPageInfo = channelService.selectByPage(jqueryPageInfo, merchantApi);
            return merchantApiJqueryPageInfo;
    }
    /**
     * 产品开通
     * @return
     */
    @RequestMapping("open")
    public ModelAndView openPage(HttpSession session,String channelNo){
        AdminUser user = (AdminUser)session.getAttribute(LoginEnums.LOGIN_KEY.getKey());
        ModelAndView modelAndView = new ModelAndView("product/edit-product");
        //所配置用户的上级的成本费率
        ChannelApi channelApi = new ChannelApi();
        channelApi.setChannelNo(channelNo);
        List<ChannelApi> channelApis = channelService.selectByEntity(channelApi);
        if(channelApis.get(channelApis.size()-1).getLevel()!=4){
        ChannelProductApi channelProductApi= new ChannelProductApi();
        modelAndView.addObject("ChannelNo",channelNo);
        modelAndView.addObject("LoginRoleType",user.getRoleType());
        modelAndView.addObject("thisChannelLevel",channelApis.get(channelApis.size()-1).getLevel());
        List<ChannelProductApi> ChannelProductlist = null;
        List<ProductApi> productlist = null;
        List list= new ArrayList();
        channelProductApi.setChannelNo(channelNo);
        ChannelProductlist = channelProductService.selectChannelProduct(channelProductApi);
        for(int m = 0; m<ChannelProductlist.size();m++){
		    ChannelProductlist.get(m).setFixT0Fee(ChannelProductlist.get(m).getFixT0Fee());
	       	BigDecimal t0Rate = new BigDecimal(ChannelProductlist.get(m).getT0Rate());
	       	ChannelProductlist.get(m).setT0Rate(t0Rate.doubleValue()+"");
	       	if(ChannelProductlist.get(m).getT1Rate()!=null){
	        BigDecimal t1Rate = new BigDecimal(ChannelProductlist.get(m).getT1Rate());
	        ChannelProductlist.get(m).setT1Rate(t1Rate.doubleValue()+"");
       	 }
        }
        //当前用户上级已开通的产品
        modelAndView.addObject("ProductList",ChannelProductlist);
        if(user.getAdminNo().equals("0")){
        	 productlist = productService.selectAll(new ProductApi());
        	 
        	 for(int i=0;i<productlist.size();i++){
        		 int count  = 0;
        		 for(int j=0;j<ChannelProductlist.size();j++){
        			 if(productlist.get(i).getProductCode().equals(ChannelProductlist.get(j).getProductCode())){
        				 list.add(ChannelProductlist.get(j));
        				 count+=1;
        			 }
               	 }
	        		 if(count==0){
	        			 list.add(productlist.get(i));
        		 }
        	 }
        	 modelAndView.addObject("ProductList",list);
        }else{
        	modelAndView.addObject("ProductList",ChannelProductlist);
        }
        
        }else{
        	modelAndView.addObject("ChannelNo",channelNo);
            modelAndView.addObject("LoginRoleType",user.getRoleType());
        	modelAndView.addObject("thisChannelLevel",channelApis.get(channelApis.size()-1).getLevel());
        	List<ProductApi> productlistForCha4 = productService.selectAll(new ProductApi());
        	modelAndView.addObject("ProductList",productlistForCha4);
        }
        System.out.println("返回了");
        return modelAndView;
    }
    
  //产品路由
    @RequestMapping("platformInfo")
    @ResponseBody
    public List<PlatformProductApi> platformInfo(HttpSession session){
    	 PlatformProductApi productApi = new PlatformProductApi();
         productApi.setEnabled(true);
    	List<PlatformProductApi> platformProductApis = platformProductService.selectByEntity(productApi);
    	 for(int i=0;i<platformProductApis.size();i++){
         	BigDecimal t0Rate = new BigDecimal(platformProductApis.get(i).getT0Rate());
         	platformProductApis.get(i).setT0Rate(t0Rate.multiply(new BigDecimal(100)).stripTrailingZeros().toPlainString());
         	BigDecimal t1Rate = new BigDecimal(platformProductApis.get(i).getT1Rate());
         	platformProductApis.get(i).setT1Rate(t1Rate.multiply(new BigDecimal(100)).stripTrailingZeros().toPlainString());
         }
        return platformProductApis;
    }
    
    
    
    
    /**
     * 添加固定路由信息
     * @param channelProductApi
     * @return
     */
    private int addChannelRouteInfo(ChannelProductApi channelProductApi){
        int row;
        ChannelRouteInfoApi cria = new ChannelRouteInfoApi();
        BeanUtils.copyProperties(channelProductApi,cria);
        cria.setIsFix(true);
        row = channelRouteInfoService.add(cria);
        return row;
    }
    
}
