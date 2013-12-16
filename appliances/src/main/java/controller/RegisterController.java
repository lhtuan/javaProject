package controller;

import global.BeanFactory;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pojo.Account;
import pojo.Userauth;
import service.implement.AccountServiceImpl;
import service.implement.UserauthServiceImpl;

@Controller
public class RegisterController {
	@RequestMapping(value = { "/register" }, method = RequestMethod.GET)
	public String loadRegister() {
		return "register";
	}

	@RequestMapping(value = { "/register" }, method = RequestMethod.POST)
	public String doRegister(ModelMap model, HttpServletRequest request,
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam("username") String confirmpassword,
			@RequestParam("email") String email,
			@RequestParam("username") String fullname,
			@RequestParam("username") String phone,
			@RequestParam("username") String address) {

		Account account = new Account(username, password, true);
		AccountServiceImpl accountService = (AccountServiceImpl) BeanFactory
				.getBean("accountService");
		String result = accountService.create(account);
		if (result == null)// thanh cong
		{
			UserauthServiceImpl userauthService = (UserauthServiceImpl) BeanFactory
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
}
