package controller;

import global.BeanFactory;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pojo.Account;
import pojo.Shoppingcart;
import pojo.Shoppingcartdetail;
import service.implement.AccountServiceImpl;

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
			Set<Shoppingcartdetail> cartDetails = cart.getShoppingcartdetails();
			model.addAttribute("cartDetails", cartDetails);
			return "checkout";
		}
		return "home";
	}
}
