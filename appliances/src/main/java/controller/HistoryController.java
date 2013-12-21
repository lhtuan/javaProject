package controller;

import global.BeanFactory;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pojo.Account;
import pojo.Shoppingcart;
import service.implement.AccountServiceImpl;
import service.implement.ShoppingCartServiceImpl;

@Controller
public class HistoryController {
	@RequestMapping(value={"/history"},method = RequestMethod.GET)
	public String defalut(ModelMap model,HttpServletRequest request,
			@RequestParam(value = "page", required = false) String page
			)
	{
		String ipage = "";
		if (page == null)
			page = "1";
		ipage = page;
		int numberPromotionofPage = 3;
		int intpage = Integer.parseInt(page);
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		if(username == null)
			return "home";
		ShoppingCartServiceImpl shoppingcartService = (ShoppingCartServiceImpl)BeanFactory.getBean("shoppingCartService");
		List<Shoppingcart> shoppingcarts = shoppingcartService.getByAccount(username,intpage);
		int countcart = shoppingcartService.CountByAccount(username);
		int totalPage = (countcart / numberPromotionofPage)
				+ ((countcart % numberPromotionofPage) > 0 ? 1
						: 0);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("ipage", ipage);
		model.addAttribute("orders",shoppingcarts);

		return "history";
	}
}
