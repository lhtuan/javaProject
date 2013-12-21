package controller;

import global.BeanFactory;
import global.LoggHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.service.jta.platform.internal.ResinJtaPlatform;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pojo.Account;
import pojo.Order;
import pojo.Product;
import pojo.Promotion;
import pojo.Shoppingcart;
import pojo.Shoppingcartdetail;
import service.implement.AccountServiceImpl;
import service.implement.ProductServiceImpl;
import service.implement.PromotionServiceImpl;
import service.implement.ShoppingCartDetailServiceImpl;
import service.implement.ShoppingCartServiceImpl;

@Controller
public class OrdersController {
	private int numberPromotionofPage = 10;
	AccountServiceImpl accountServive = (AccountServiceImpl) BeanFactory
			.getBean("accountService");
	ProductServiceImpl productService = (ProductServiceImpl) BeanFactory
			.getBean("productService");
	ShoppingCartDetailServiceImpl shoppingcartDetailService = (ShoppingCartDetailServiceImpl) BeanFactory
			.getBean("shoppingCartDetailService");
	ShoppingCartServiceImpl shoppingcartService = (ShoppingCartServiceImpl)BeanFactory
			.getBean("shoppingCartService");
	
	@RequestMapping(value = { "/admin/vieworders" }, method = RequestMethod.GET)
	public String Orders(ModelMap model, HttpServletRequest request,
			@RequestParam(value = "page", required = false) String page) {
		 getOrders(model, page); 
	
		return "vieworders";
	}
	
	
	@RequestMapping(value = { "/admin/completeeditorder" }, method = RequestMethod.GET)
	public String SaveEditOrder(ModelMap model	,HttpServletRequest request,
			@RequestParam(value = "shippfullname", required = false) String shippfullname,
			@RequestParam(value = "shippaddress", required = false) String shippaddress,
			@RequestParam(value = "shippemail", required = false) String shippemail,
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "shipphone", required = false) String shipphone,
			@RequestParam(value = "page", required = false) String page) throws ParseException {
		
		Shoppingcart shoppingcart = shoppingcartService.get(Integer.parseInt(id));
		shoppingcart.setShipaddress(shippaddress);
		shoppingcart.setShipemail(shippemail);
		shoppingcart.setShipfullname(shippfullname);
		shoppingcart.setShipphone(shipphone);
		
		
		
		String resultShoppingcart = shoppingcartService.update(shoppingcart);
		if(resultShoppingcart != null){
			model.addAttribute("editordererror", resultShoppingcart);
			return "editorders";
		}
		
		getOrders(model, page);
		return "vieworders";
	}
	
	@RequestMapping(value = { "/admin/deletedorders" }, method = RequestMethod.GET)
	public String DeleteOrder(ModelMap model	,HttpServletRequest request,
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "page", required = false) String page) {
		
		Shoppingcart cart = shoppingcartService.get(Integer.parseInt(id));
		cart.setDeleted(true);
		String result =  shoppingcartService.update(cart);
		if(result != null){
			model.addAttribute("deletedordererror", result);
			
		}
		getOrders(model, page);
		return "vieworders";
	}
	
	@RequestMapping(value = { "/admin/editorders" }, method = RequestMethod.GET)
	public String EditOrder(ModelMap model,HttpServletRequest request,
			@RequestParam(value = "id", required = false) String id	) {
		
		Shoppingcart shoppingcart = shoppingcartService.get(Integer.parseInt(id));
		model.addAttribute("order", shoppingcart);
		
		return "editorders";
	}
	@RequestMapping(value = { "/admin/detailorder" }, method = RequestMethod.GET)
	public String DetailOrder(ModelMap model,HttpServletRequest request,
			@RequestParam(value = "id", required = false) String id	) {
		
		Shoppingcart shoppingcart = shoppingcartService.get(Integer.parseInt(id));
		model.addAttribute("order", shoppingcart);
		
		return "orderdetail";
	}
	public void getOrders(ModelMap model, String page) {
		String ipage = "";
		if (page == null)
			page = "1";
		ipage = page;

		int intpage = Integer.parseInt(page);
		
		List<Shoppingcart> shoppingcarts = shoppingcartService.getShoppingCarts(intpage);
		int shoppingcartCount = shoppingcartService.CountShoppingCart();

		int totalPage = (shoppingcartCount / numberPromotionofPage)
				+ ((shoppingcartCount % numberPromotionofPage) > 0 ? 1
						: 0);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("orders", shoppingcarts);
		model.addAttribute("ipage", ipage);
	}
}
