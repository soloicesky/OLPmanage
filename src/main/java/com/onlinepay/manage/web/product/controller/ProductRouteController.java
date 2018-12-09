package com.onlinepay.manage.web.product.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.onlinepay.manage.common.page.JqueryPageInfo;
import com.onlinepay.manage.dao.platform.entity.Platform;
import com.onlinepay.manage.service.IPlatformProductService;
import com.onlinepay.manage.service.IPlatformService;
import com.onlinepay.manage.service.IProductRouteFixService;
import com.onlinepay.manage.service.IProductService;
import com.onlinepay.manage.service.entity.PlatformApi;
import com.onlinepay.manage.service.entity.PlatformProductApi;
import com.onlinepay.manage.service.entity.ProductApi;
import com.onlinepay.manage.service.entity.ProductRouteFixApi;
import com.onlinepay.manage.web.product.response.EditResponse;
import com.onlinepay.manage.web.product.response.ListDateResponse;
import com.onlinepay.manage.web.product.response.ReturnDataResponse;

/**
 * TODO:路由管理 Created by tom on 17/8/28.
 */
@Controller
@RequestMapping("product/route")
public class ProductRouteController {

	@Autowired
	private IProductRouteFixService productRouteFixService;
	@Autowired
	private IPlatformService platformService;
	@Autowired
	private IProductService productService;
	@Autowired
	private IPlatformProductService platformProductService;

	@RequestMapping("listdata")
	@ResponseBody
	public JqueryPageInfo<ProductRouteFixApi> listdata(JqueryPageInfo<ProductRouteFixApi> jqueryPageInfo,
			ProductRouteFixApi productRouteFixApi) {
		if (productRouteFixApi.getChannelNo().equals(""))
			productRouteFixApi.setChannelNo(null);
		if (productRouteFixApi.getChannelName().equals(""))
			productRouteFixApi.setChannelName(null);
		if (productRouteFixApi.getSubProductCode().equals("00"))
			productRouteFixApi.setSubProductCode(null);
		if (productRouteFixApi.getPlatformCode().equals("0"))
			productRouteFixApi.setPlatformCode(null);
		JqueryPageInfo<ProductRouteFixApi> productRouteFixApiJqueryPageInfo = productRouteFixService
				.selectByPage(jqueryPageInfo, productRouteFixApi);
		return productRouteFixApiJqueryPageInfo;
	}

	@RequestMapping("listpage")
	@ResponseBody
	public ModelAndView listdata() {
		ModelAndView mode = new ModelAndView("product/product-routefix-list");
		List<PlatformApi> platformApis = platformService.selectByEntity(new PlatformApi());
		mode.addObject("PlatformList", platformApis);
		List<ProductApi> list = productService.selectAll(new ProductApi());
		mode.addObject("ProductList", list);
		return mode;
	}

	@RequestMapping("changePlatform")
	@ResponseBody
	public Map changePlatform(HttpServletRequest request) {

		String product = request.getParameter("product");
		System.out.println("            " + product);
		List<PlatformApi> platformApis = null;
		if (!"00".equals(product)) {
			platformApis = platformService.selectByProduct(product);
		} else {
			platformApis = platformService.selectByEntity(new PlatformApi());

		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("PlatformList", platformApis);
		return map;
	}

	@RequestMapping("editpage")
	public ModelAndView editPage(ProductRouteFixApi productRouteFix) {
		ModelAndView mode = new ModelAndView("product/product-routefix-edit");
		PlatformProductApi productApi = new PlatformProductApi();
		ProductRouteFixApi productRouteFixApis = productRouteFixService.selectByEntity(productRouteFix).get(0);
		mode.addObject("ProductRouteFix", productRouteFixApis);
		productApi.setEnabled(true);
		productApi.setSubProductCode(productRouteFixApis.getSubProductCode());
		List<PlatformProductApi> platformProductApis = platformProductService.selectByEntity(productApi);
		mode.addObject("PlatformProduct", platformProductApis);
		return mode;
	}

	@RequestMapping("edit")
	@ResponseBody
	public EditResponse edit(ProductRouteFixApi productRouteFix) {
		EditResponse response = new EditResponse();
		response.setCode("02");
		productRouteFix.setVersion(productRouteFix.getVersion() + 1);
		productRouteFix.setUpdateDate(new Date());
		int i = productRouteFixService.updateProductRoute(productRouteFix);
		if (i == 1) {
			response.setCode("00");
			response.setMsg("OK");
		}
		return response;
	}

	@RequestMapping("addpage")
	public ModelAndView addPage() {
		ModelAndView mode = new ModelAndView("product/product-routefix-add");
		List<ProductApi> list = productService.selectAll(new ProductApi());
		mode.addObject("ProductList", list);
		return mode;
	}

	@RequestMapping("add")
	@ResponseBody
	public ReturnDataResponse add(ProductRouteFixApi productRouteFixApi) {
		ReturnDataResponse response = new ReturnDataResponse();
		response.setCode("02");
		response.setMsg("系统异常！");
		response.setData(productRouteFixApi.getProductId());
		List<ProductRouteFixApi> list = productRouteFixService.selectByEntity(productRouteFixApi);
		if (list.size() != 0) {
			response.setCode("02");
			response.setMsg("请勿重复提交");
			return response;
		}

		productRouteFixApi.setCreateDate(new Date());
		productRouteFixApi.setUpdateDate(new Date());
		productRouteFixApi.setVersion((long) 1);
		int i = productRouteFixService.addProductRoute(productRouteFixApi);
		if (i == 1) {
			response.setCode("00");
			response.setMsg("OK");
		}
		return response;
	}

	@RequestMapping("selectchannel")
	@ResponseBody
	public ListDateResponse selectChannel(String subProductCode) {
		ListDateResponse response = new ListDateResponse();
		response.setCode("02");
		response.setMsg("系统异常！");
		PlatformProductApi productApi = new PlatformProductApi();
		productApi.setEnabled(true);
		productApi.setSubProductCode(subProductCode);
		List<PlatformProductApi> platformProductApis = platformProductService.selectByEntity(productApi);

		String string = JSON.toJSONString(platformProductApis);
		response.setCode("00");
		response.setMsg("OK");
		response.setData(string);
		response.setSubProductCode(subProductCode);
		return response;
	}

	@RequestMapping("checkroutefix")
	@ResponseBody
	public ReturnDataResponse<ProductRouteFixApi> checkRouteFix(ProductRouteFixApi productRouteFixApi) {
		ReturnDataResponse<ProductRouteFixApi> response = new ReturnDataResponse();
		response.setCode("02");
		response.setMsg("系统异常！");
		List<ProductRouteFixApi> platformProductApis = productRouteFixService.selectByEntity(productRouteFixApi);
		response.setCode("00");
		response.setMsg("OK");
		response.setListdata(platformProductApis);
		return response;
	}

	@RequestMapping("roadlistpage")
	public ModelAndView listpage() {
		ModelAndView modelAndView = new ModelAndView("product/road-list");
		return modelAndView;
	}

	@RequestMapping("editRoadPage")
	public ModelAndView editRoadPage(HttpServletRequest request) {
		String subProductCode = request.getParameter("id");
		ModelAndView mode = new ModelAndView("product/road-list-son");
		PlatformProductApi productApi = new PlatformProductApi();
		productApi.setSubProductCode(subProductCode);
		List<PlatformProductApi> platformProductApis = platformProductService.selectByEntity(productApi);
		mode.addObject("data", platformProductApis);
		mode.addObject("subProductCode", subProductCode);
		LoggerFactory.getLogger(ProductRouteController.class).info(platformProductApis.toString());
		return mode;
	}

	@RequestMapping("addRoadPage")
	public ModelAndView addRoadPage(HttpServletRequest request) {
		String subProductCode = request.getParameter("id");
		ModelAndView mode = new ModelAndView("product/road-add");
		// PlatformProductApi productApi = new PlatformProductApi();
		// productApi.setEnabled(true);
		// productApi.setSubProductCode(subProductCode);
		// List<PlatformProductApi> platformProductApis =
		// platformProductService.selectByEntity(productApi);
		// mode.addObject("data",platformProductApis);
		List<Platform> platform = platformService.findPlatform(subProductCode);
		LoggerFactory.getLogger(ProductRouteController.class).info("-----查询结果-------" + platform.toString());
		mode.addObject("subProductCode", subProductCode);
		mode.addObject("data", platform);
		mode.addObject("Url", "addRoad");
		// LoggerFactory.getLogger(ProductRouteController.class).info(platformProductApis.toString());
		return mode;
	}

	@RequestMapping("editRoad")
	public ModelAndView editRoad(HttpServletRequest request) {
		String subProductCode = request.getParameter("id");
		String platformCode = request.getParameter("platformName");
		ModelAndView mode = new ModelAndView("product/road-edit");
		PlatformProductApi productApi = new PlatformProductApi();
		productApi.setSubProductCode(subProductCode);
		 productApi.setPlatformCode(platformCode);
		productApi.setPlatformId(Long.valueOf(platformCode));
		List<PlatformProductApi> platform = platformProductService.selectByEntity(productApi);
		LoggerFactory.getLogger(ProductRouteController.class).info("-----查询结果-------" + platform.toString());
		mode.addObject("subProductCode", subProductCode);
		if (platform.size() == 1) {
			PlatformProductApi platformProductApi = platform.get(0);
			double maxAmt = platformProductApi.getMaxAmt();
			double minAmt = platformProductApi.getMinAmt();
//			double t1MaxAmt = platformProductApi.getT1MaxAmt();
//			double t1MinAmt = platformProductApi.getT1MinAmt();
			double fixT0Fee = platformProductApi.getFixT0Fee();
			platformProductApi.setFixT0Fee(new BigDecimal(fixT0Fee).doubleValue());
			platformProductApi.setMaxAmt(new BigDecimal(maxAmt).doubleValue());
			platformProductApi.setMinAmt(new BigDecimal(minAmt).doubleValue());
//			platformProductApi.setT1MaxAmt(new BigDecimal(t1MaxAmt).doubleValue());
//			platformProductApi.setT1MinAmt(new BigDecimal(t1MinAmt).doubleValue());

			mode.addObject("data", platformProductApi);
		}
		mode.addObject("Url", "updateRoad");
		// LoggerFactory.getLogger(ProductRouteController.class).info(platformProductApis.toString());
		return mode;
	}

	@RequestMapping("addRoad")
	@ResponseBody
	public ReturnDataResponse addRoad(PlatformProductApi productApi) {

		// 添加上游通道：记录到platform 表
		if (productApi.getPlatformId() == -1) {
			PlatformApi platformApi = new PlatformApi();
			platformApi.setName(productApi.getNewPlatform());
			platformApi.setUpdateDate(new Date());
			platformApi.setCreateDate(new Date());
			platformApi.setCode(productApi.getPlatformCode());
			platformApi.setConfig("");
			platformApi.setEnabled(true);
			platformApi.setVersion(1l);
			int i = platformService.addPlatform(platformApi);

			List<PlatformApi> platformApis = platformService.selectByEntity(platformApi);
			PlatformApi platformApi1 = platformApis.get(0);
			productApi.setPlatformId(platformApi1.getId());
			productApi.setPlatformCode(platformApi1.getCode());
		} else {
			PlatformApi platformApi = new PlatformApi();
			platformApi.setId(productApi.getPlatformId());
			Platform platform = platformService.selectByID(platformApi);
			productApi.setPlatformCode(platform.getCode());
		}
		productApi.setCreateDate(new Date());
		productApi.setUpdateDate(new Date());
		productApi.setVersion(1l);
		productApi.setEnabled(true);
//		productApi.setIsT0PubAcc(true);
//		productApi.setIsT1PubAcc(true);
		productApi.setT1BegTime("");
		productApi.setProductId(1l);
		double maxAmt = productApi.getMaxAmt();
		double minAmt = productApi.getMinAmt();
//		double t1MaxAmt = productApi.getT1MaxAmt();
//		double t1MinAmt = productApi.getT1MinAmt();
		double fixT0Fee = productApi.getFixT0Fee();
		productApi.setFixT0Fee(fixT0Fee*100);
		productApi.setPriority(productApi.getPriority());
		productApi.setMaxAmt(maxAmt*100);
		productApi.setMinAmt(minAmt*100);
//		productApi.setT1MaxAmt(t1MaxAmt*100);
//		productApi.setT1MinAmt(t1MinAmt*100);
		LoggerFactory.getLogger(ProductRouteController.class).info("添加通道" + productApi.toString());
		int i = platformProductService.addPlatformProduct(productApi);
		ReturnDataResponse<ProductRouteFixApi> response = new ReturnDataResponse();
		response.setCode("00");
		response.setMsg("OK");
		return response;
	}

	@RequestMapping("updateRoad")
	@ResponseBody
	public ReturnDataResponse updateRoad(PlatformProductApi productApi) {

		productApi.setPlatformCode(productApi.getPlatformCode());
		productApi.setSubProductCode(productApi.getSubProductCode());
		productApi.setCreateDate(new Date());
		productApi.setUpdateDate(new Date());
		productApi.setVersion(1l);
		productApi.setPriority(productApi.getPriority());
//		productApi.setIsT0PubAcc(true);
//		productApi.setIsT1PubAcc(true);
		productApi.setT1BegTime("");
		productApi.setProductId(1l);
		double maxAmt = productApi.getMaxAmt();
		double minAmt = productApi.getMinAmt();
//		double t1MaxAmt = productApi.getT1MaxAmt();
//		double t1MinAmt = productApi.getT1MinAmt();
		double fixT0Fee = productApi.getFixT0Fee();
		productApi.setFixT0Fee(fixT0Fee*100);
		productApi.setMaxAmt(maxAmt*100);
		productApi.setMinAmt(minAmt*100);
//		productApi.setT1MaxAmt(t1MaxAmt*100);
//		productApi.setT1MinAmt(t1MinAmt*100);
		// if("0".equals(productApi.getStatus())){
		// productApi.setEnabled(false);
		// }
		LoggerFactory.getLogger(ProductRouteController.class).info("修改通道" + productApi.toString());
		int i = platformProductService.updatePlatformProduct(productApi);
		ReturnDataResponse<ProductRouteFixApi> response = new ReturnDataResponse();
		response.setCode("00");
		response.setMsg("OK");
		return response;
	}

	@RequestMapping("selectPlatform")
	@ResponseBody
	public ListDateResponse selectPlatform(String subProductCode) {
		LoggerFactory.getLogger(ProductRouteController.class).info("------------" + subProductCode.toString());
		ListDateResponse response = new ListDateResponse();
		response.setCode("02");
		response.setMsg("系统异常！");
		PlatformProductApi productApi = new PlatformProductApi();
		productApi.setEnabled(true);
		productApi.setSubProductCode(subProductCode);
		List<Platform> platform = platformService.findPlatform(subProductCode);
		LoggerFactory.getLogger(ProductRouteController.class).info("-----查询结果-------" + platform.toString());
		String string = JSON.toJSONString(platform);
		response.setCode("00");
		response.setMsg("OK");
		response.setData(string);
		response.setSubProductCode(subProductCode);
		return response;
	}
}
