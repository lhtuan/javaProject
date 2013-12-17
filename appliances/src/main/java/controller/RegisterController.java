package controller;

import global.BeanFactory;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.Account;
import pojo.Userauth;
import service.implement.AccountServiceImpl;
import service.implement.UserauthServiceImpl;

@Controller
public class RegisterController {
	AccountServiceImpl accountService;
	UserauthServiceImpl userauthService;
	@RequestMapping(value = { "/register" }, method = RequestMethod.GET)
	public String loadRegister(ModelMap model) {
		return "register";
	}

	@RequestMapping(value = { "/register" }, method = RequestMethod.POST)
	public String doRegister(ModelMap model, HttpServletRequest request,
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam("confirmpassword") String confirmpassword,
			@RequestParam("email") String email,
			@RequestParam("fullname") String fullname,
			@RequestParam("phone") String phone,
			@RequestParam("address") String address) {
		if(!password.equalsIgnoreCase(confirmpassword))//xac nhan mat khau khong chinh xac
		{
			model.addAttribute("registerError", "Xác nhận mật khẩu không chính xác");
			return "register";
		}
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
				return "register";
			} else {
				userauths.add(newAuth);
				newAcc.setUserauths(userauths);
				newAcc.setFullName(fullname);
				newAcc.setAddress(address);
				newAcc.setEmail(email);
				newAcc.setPhone(phone);
				accountService.update(newAcc);
				return "login";
			}
		}
		// that bai
		model.addAttribute("registerError", result);
		return "register";
	}
	@RequestMapping(value={"/register/checkaccount"},method = RequestMethod.GET)
	public @ResponseBody boolean checkAccountExist(@RequestParam("username")String username)
	{
		accountService = (AccountServiceImpl)BeanFactory.getBean("accountService");
		Account account = accountService.get(username);
		return account != null;
	}
}
