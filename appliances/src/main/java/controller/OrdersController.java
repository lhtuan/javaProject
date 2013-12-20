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
	@RequestMapping(value = { "/admin/completeaddorder" }, method = RequestMethod.GET)
	public String SaveAddOrders(ModelMap model, HttpServletRequest request,
			@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "username", required = false) String username,
			@RequestParam(value = "idproduct", required = false) String idproduct,
			@RequestParam(value = "thoigian", required = false) String thoigian,
			@RequestParam(value = "soluong", required = false) String soluong) throws ParseException {
		 
		
		Account account = accountServive.get(username);
		if(account == null){
			model.addAttribute("addordererror", "Tai Khoan Khong Ton Tai");
			return "addorders";
		}
		Product product = productService.get(Integer.parseInt(idproduct));
		if(product == null){
			model.addAttribute("addordererror", "San Pham Khong Ton Tai");
			return "addorders";
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dateorders = sdf.parse(thoigian);
		
		Shoppingcart shoppingcart = new Shoppingcart(account, dateorders);
		String resultshoppingcart = shoppingcartService.add(shoppingcart);
		if(resultshoppingcart != null){
			model.addAttribute("addordererror", resultshoppingcart);
			return "addorders";
		}
		Shoppingcartdetail shoppingcartdetail = new Shoppingcartdetail(product, shoppingcart, Integer.parseInt(soluong),false);
		
		String result = shoppingcartDetailService.add(shoppingcartdetail);
		if(result != null){
			model.addAttribute("addordererror", result);
			return "addorders";
		}
		getOrders(model, page);
		return "vieworders";
	}
	
	
	@RequestMapping(value = { "/admin/completeeditorder" }, method = RequestMethod.GET)
	public String SaveEditOrder(ModelMap model	,HttpServletRequest request,
			@RequestParam(value = "username", required = false) String username,
			@RequestParam(value = "thoigian", required = false) String thoigian,
			@RequestParam(value = "soluong", required = false) String soluong,
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "idproduct", required = false) String idproduct,
			@RequestParam(value = "page", required = false) String page) throws ParseException {
		
		Account account = accountServive.get(username);
		
		Product product = productService.get(Integer.parseInt(idproduct));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dateorders = sdf.parse(thoigian);
		
		Shoppingcartdetail shoppingcartdetail = shoppingcartDetailService.get(Integer.parseInt(id));
		shoppingcartdetail.setNumber(Integer.parseInt(soluong));
		Shoppingcart shoppingcart = shoppingcartdetail.getShoppingcart();
		shoppingcart.setOrderDate(dateorders);
		
		String resultShoppingcart = shoppingcartService.update(shoppingcart);
		if(resultShoppingcart != null){
			model.addAttribute("editordererror", resultShoppingcart);
			return "editorders";
		}
		String result = shoppingcartDetailService.update(shoppingcartdetail);
		if(result != null){
			model.addAttribute("editordererror", result);
			return "editorders";
		}
		
		getOrders(model, page);
		return "vieworders";
	}
	
	@RequestMapping(value = { "/admin/deletedorders" }, method = RequestMethod.GET)
	public String DeleteOrder(ModelMap model	,HttpServletRequest request,
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "page", required = false) String page) {
		Shoppingcartdetail shoppingcartdetail = shoppingcartDetailService.get(Integer.parseInt(id));
		shoppingcartdetail.setDeleted(true);
		String result = shoppingcartDetailService.update(shoppingcartdetail);
		if(result != null){
			model.addAttribute("deletedordererror", result);
			
		}
		getOrders(model, page);
		return "vieworders";
	}
	
	@RequestMapping(value = { "/admin/addorders" }, method = RequestMethod.GET)
	public String AddOrders(ModelMap model		) {
		
		return "addorders";
	}
	@RequestMapping(value = { "/admin/editorders" }, method = RequestMethod.GET)
	public String EditOrder(ModelMap model,HttpServletRequest request,
			@RequestParam(value = "id", required = false) String id	) {
		
		Shoppingcartdetail shoppingcartdetail = shoppingcartDetailService.get(Integer.parseInt(id));
		Order order = new Order();
		order.setSanpham(shoppingcartdetail.getProduct().getProductName());
		order.setSoluong(shoppingcartdetail.getNumber());
		order.setThoigian(shoppingcartdetail.getShoppingcart().getOrderDate());
		order.setUsername(shoppingcartdetail.getShoppingcart().getAccount()
				.getUsername());
		order.setIdProduct(shoppingcartdetail.getProduct().getId());
		order.setId(shoppingcartdetail.getId());
		
		model.addAttribute("order", order);
		return "editorders";
	}
	public void getOrders(ModelMap model, String page) {
		String ipage = "";
		if (page == null)
			page = "1";
		ipage = page;

		int intpage = Integer.parseInt(page);
		
		List<Shoppingcartdetail> shoppingcartDetails = shoppingcartDetailService
				.shoppingcartdetails(intpage);
		int shoppingcartdetailCount = shoppingcartDetailService
				.Countshoppingcartdetail();

		List<Order> orders = new ArrayList<Order>();
		for (Shoppingcartdetail spcarddetail : shoppingcartDetails) {
			Order temp = new Order();
			temp.setSanpham(spcarddetail.getProduct().getProductName());
			temp.setSoluong(spcarddetail.getNumber());
			temp.setThoigian(spcarddetail.getShoppingcart().getOrderDate());
			temp.setUsername(spcarddetail.getShoppingcart().getAccount()
					.getUsername());
			temp.setId(spcarddetail.getId());
			orders.add(temp);
		}

		int totalPage = (shoppingcartdetailCount / numberPromotionofPage)
				+ ((shoppingcartdetailCount % numberPromotionofPage) > 0 ? 1
						: 0);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("orders", orders);
		model.addAttribute("ipage", ipage);
	}
}
