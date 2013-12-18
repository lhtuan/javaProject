package controller;

import java.util.List;

import global.BeanFactory;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.DefaultEditorKit.BeepAction;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pojo.Account;
import pojo.Promotion;
import service.implement.AccountServiceImpl;
import service.implement.PromotionServiceImpl;

@Controller
public class AccountController {
	
	private int numberAccountofPage = 10;
	
	@RequestMapping(value={"/admin/viewuser"},method = RequestMethod.GET)
	public String defalut(ModelMap model,HttpServletRequest request,
			@RequestParam(value = "page",required=false) String page)
	{
		String ipage = "";
		if(page ==null)
			page="1";
		ipage = page;
			
		int intpage = Integer.parseInt(page);
		AccountServiceImpl accountService = (AccountServiceImpl)BeanFactory.getBean("accountService");
		List<Account> accounts = accountService.getAccounts(intpage);
		int countAccout = accountService.countAccouts();
		int totalPage = (countAccout/numberAccountofPage) + ((countAccout/numberAccountofPage) > 0 ? 1 : 0);
		model.addAttribute("totalPage",totalPage);
		model.addAttribute("accounts",accounts);
		model.addAttribute("ipage",ipage);
		return "viewuser";
	}
	@RequestMapping(value={"/admin/adduser"},method = RequestMethod.GET)
	public String AddUser(ModelMap model)
	{
		
		return "adduser";
	}
	@RequestMapping(value={"/admin/edituser"},method = RequestMethod.GET)
	public String EditUser(ModelMap model,	HttpServletRequest request,
			@RequestParam(value = "username",required=false) String username)
	{
		
		AccountServiceImpl accountService = (AccountServiceImpl)BeanFactory.getBean("accountService");
		Account account = accountService.get(username);
		model.addAttribute("account", account);
		return "edituser";
	}
}
