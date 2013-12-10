package controller;

import global.BeanFactory;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pojo.Product;
import service.implement.ProductServiceImpl;

@Controller
public class ProductDetailController {
	@RequestMapping(value={"/productDetail"},method= RequestMethod.GET)
	String productDetail(ModelMap model,HttpServletRequest request,
			@RequestParam(value="id",required =false)String strId)
	{
		if(strId != null)
		{
			int id = Integer.parseInt(strId);
			ProductServiceImpl productService = (ProductServiceImpl)BeanFactory.getBean("productService");
			Product product = productService.get(id);
			model.addAttribute("product", product);
			return "productDetail";
		}	
		else
			return "home";
	}
}
