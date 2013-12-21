package controller;

import global.BeanFactory;

import java.util.Date;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.Account;
import pojo.Shoppingcart;
import pojo.Shoppingcartdetail;
import service.implement.AccountServiceImpl;
import service.implement.ShoppingCartDetailServiceImpl;
import service.implement.ShoppingCartServiceImpl;

@Controller
public class CheckOutController {
	@RequestMapping(value = { "/checkout" }, method = RequestMethod.GET)
	public String defalut(ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		AccountServiceImpl accountService = (AccountServiceImpl) BeanFactory
				.getBean("accountService");
		String username = (String) session.getAttribute("username");
		if (username != null && !username.equalsIgnoreCase("")) {
			Account account = accountService.get(username);
			model.addAttribute("account", account);

			Shoppingcart cart = (Shoppingcart) session.getAttribute("cart");
			if (cart != null) {
				Set<Shoppingcartdetail> cartDetails = cart
						.getShoppingcartdetails();
				model.addAttribute("cartDetails", cartDetails);
				return "checkout";
			}
		}
		return "home";
	}
	/***
	 * Ajax thanh toan
	 * @param request
	 * @return null: thanh cong , String: ten loi
	 */
	@RequestMapping(value={"/checkout/dochecout"},method=RequestMethod.POST)
	public @ResponseBody String doCheckout(HttpServletRequest request,
			@RequestParam("shipfullname")String shipfullname,
			@RequestParam("shipaddress")String shipaddress,
			@RequestParam("shipemail")String shipemail,
			@RequestParam("shipphone")String shipphone)
	{
		HttpSession session = request.getSession();
		Shoppingcart cart = (Shoppingcart)session.getAttribute("cart");
		if(cart==null)
			return "Giá»� hÃ ng rá»—ng";
		try
		{
			if(cart.getAccount()== null)
			{
				AccountServiceImpl accountService =(AccountServiceImpl)BeanFactory.getBean("accountService");
				String username = (String)session.getAttribute("username");
				Account account = accountService.get(username);
				cart.setAccount(account);
				cart.setShipaddress(shipaddress);
				cart.setShipemail(shipemail);
				cart.setShipfullname(shipfullname);
				cart.setShipphone(shipphone);
			}
			cart.setOrderDate(new Date());
			ShoppingCartServiceImpl cartService = (ShoppingCartServiceImpl)BeanFactory.getBean("shoppingCartService");
			cartService.add(cart);
			ShoppingCartDetailServiceImpl cartDetailService = (ShoppingCartDetailServiceImpl)BeanFactory.getBean("shoppingCartDetailService");
			for (Shoppingcartdetail detail : cart.getShoppingcartdetails()) {
				detail.setDeleted(false);
				detail.setShoppingcart(cart);
				cartDetailService.add(detail);
			}
			session.removeAttribute("cart");
		}
		catch(Exception ex)
		{
			return "Lá»—i: "+ex.getMessage();
		}
		return null;
	}
	@RequestMapping(value={"/checkout/success"})
	public String checkOutSuccess()
	{
		return "checkoutsuccess";
	}
}
