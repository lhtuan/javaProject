package controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import global.BeanFactory;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.DefaultEditorKit.BeepAction;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pojo.Account;
import pojo.Promotion;
import pojo.Userauth;
import service.implement.AccountServiceImpl;
import service.implement.PromotionServiceImpl;
import service.implement.UserauthServiceImpl;

@Controller
public class AccountController {
	
	private int numberAccountofPage = 10;
	AccountServiceImpl accountService;
	UserauthServiceImpl userauthService;
	@RequestMapping(value={"/admin/viewuser"},method = RequestMethod.GET)
	public String defalut(ModelMap model,HttpServletRequest request,
			@RequestParam(value = "page",required=false) String page)
	{
		getAcccouts(model, page);
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
	@RequestMapping(value={"/admin/complateadduser"},method = RequestMethod.GET)
	public String SaveNewUser(ModelMap model,HttpServletRequest request,
			@RequestParam(value = "page",required=false) String page,
			@RequestParam(value = "username", required = false) String username,
			@RequestParam(value = "password", required = false) String password,
			@RequestParam(value = "fullname", required = false) String fullname,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "phone", required = false) String phone,
			@RequestParam(value = "adress", required = false) String address)
	{
		Md5PasswordEncoder md5 = new Md5PasswordEncoder();		
		Account account = new Account(username,md5.encodePassword(password, null), true);
		accountService = (AccountServiceImpl) BeanFactory
				.getBean("accountService");
		String result = accountService.create(account);
		if (result == null)// thanh cong
		{
			userauthService = (UserauthServiceImpl) BeanFactory
					.getBean("userauthService");
			Account newAcc = accountService.get(username);
			Set<Userauth> userauths = new HashSet<Userauth>(0);
			Userauth newAuth = new Userauth(newAcc, "ROLE_USER");
			if (userauthService.add(newAuth) != null) {// loi tao roles
				model.addAttribute("registerError", "Tạo roles that bai");
				return "adduser";
			} else {
				userauths.add(newAuth);
				newAcc.setUserauths(userauths);
				newAcc.setFullName(fullname);
				newAcc.setAddress(address);
				newAcc.setEmail(email);
				newAcc.setPhone(phone);
				newAcc.setBanned(false);
				accountService.update(newAcc);
				getAcccouts(model, page);
				return "viewuser";
			}
		}
		// that bai
		model.addAttribute("registerError", result);
		return "adduser";
	}
	@RequestMapping(value={"/admin/complateupdate"},method = RequestMethod.GET)
	public String SaveUpdate(ModelMap model,HttpServletRequest request,
			@RequestParam(value = "page",required=false) String page,
			@RequestParam(value = "username", required = false) String username,
			@RequestParam(value = "password", required = false) String password,
			@RequestParam(value = "fullname", required = false) String fullname,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "phone", required = false) String phone,
			@RequestParam(value = "adress", required = false) String address)
	{
		
		accountService = (AccountServiceImpl)BeanFactory.getBean("accountService");
		Account account = accountService.get(username);
		Md5PasswordEncoder md5 = new Md5PasswordEncoder();	
		account.setPassword(md5.encodePassword(password, null));
		account.setFullName(fullname);
		account.setEmail(email);
		account.setPhone(phone);
		account.setAddress(address);
		String result = accountService.update(account);
		if (result == null)// thanh cong
		{
			getAcccouts(model, page);
			return "viewuser";
		}
		// that bai
				model.addAttribute("editError", result);
				return "edituser";
	}
	@RequestMapping(value={"/admin/deleteuser"},method = RequestMethod.GET)
	public String DeletedUser(ModelMap model,	HttpServletRequest request,
			@RequestParam(value = "page",required=false) String page,
			@RequestParam(value = "username",required=false) String username)
	{
		
		AccountServiceImpl accountService = (AccountServiceImpl)BeanFactory.getBean("accountService");
		Account account = accountService.get(username);
		account.setBanned(true);
		String result  = accountService.update(account);
		if (result != null)// thanh cong
		{
			model.addAttribute("DeletedError", result);
		}
		
		getAcccouts(model, page);
		return "viewuser";
	}
	
	
	
	public void getAcccouts(ModelMap model, String page){
		String ipage = "";
		if(page ==null)
			page="1";
		ipage = page;
			
		int intpage = Integer.parseInt(page);
		AccountServiceImpl accountService = (AccountServiceImpl)BeanFactory.getBean("accountService");
		List<Account> accounts = accountService.getAccounts(intpage);
		int countAccout = accountService.countAccouts();
		int totalPage = (countAccout/numberAccountofPage) + ((countAccout % numberAccountofPage) > 0 ? 1 : 0);
		model.addAttribute("totalPage",totalPage);
		model.addAttribute("accounts",accounts);
		model.addAttribute("ipage",ipage);
	}
}
