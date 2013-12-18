package controller;

import global.BeanFactory;
import global.PropertiesHelper;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.Product;
import service.implement.ProductServiceImpl;

@Controller
public class CompareController {
	@SuppressWarnings("unchecked")
	@RequestMapping(value = { "/compare" }, method = RequestMethod.GET)
	public String compare(ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<Product> products = null;
		products = (List<Product>) session.getAttribute("products");
		model.addAttribute("products", products);
		return "compare";
	}

	/***
	 * Them san pham vao compare list
	 * 
	 * @param request
	 * @param id
	 * @return true: da them, false:danh sach full
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = { "/compare/add" }, method = RequestMethod.POST)
	public @ResponseBody
	boolean addToCompareByAjax(HttpServletRequest request,
			@RequestParam("id") int id) {
		ProductServiceImpl productService = (ProductServiceImpl) BeanFactory
				.getBean("productService");
		Product product = productService.get(id);

		HttpSession session = request.getSession();
		List<Product> products = null;
		products = (List<Product>) session.getAttribute("products");
		if (products != null) {
			PropertiesHelper properties = new PropertiesHelper("const");
			int maxSize = Integer.parseInt(properties.getValue("max_compare"));
			if (products.size() == maxSize)
				return false;
		}
		products.add(product);
		session.setAttribute("products", products);
		return true;
	}

	/***
	 * Them san pham vao compare list
	 * 
	 * @param request
	 * @param id
	 * @return true: da them, false:danh sach full
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = { "/compare/add" }, method = RequestMethod.GET)
	public String addToCompare(ModelMap model,HttpServletRequest request,
			@RequestParam("id") int id) {
		ProductServiceImpl productService = (ProductServiceImpl) BeanFactory
				.getBean("productService");
		Product product = productService.get(id);

		HttpSession session = request.getSession();
		List<Product> products = null;
		products = (List<Product>) session.getAttribute("products");
		if (products == null) {
			products = new ArrayList<Product>();
		}
		PropertiesHelper properties = new PropertiesHelper("const");
		int maxSize = Integer.parseInt(properties.getValue("max_compare"));
		if (products.size() < maxSize) {
			for (Product p : products) {
				if(p.getId() == id)
				{
					model.addAttribute("products", products);
					return "compare";//san pham da co trong compare list, khong add
				}
			}
			products.add(product);
			session.setAttribute("products", products);
		}
		model.addAttribute("products", products);
		return "compare";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = { "compare/delete" }, method = RequestMethod.GET)
	public String deleteFromCompare(ModelMap model,HttpServletRequest request,
			@RequestParam("id") int id) {
		HttpSession session = request.getSession();
		List<Product> products = null;
		products = (List<Product>) session.getAttribute("products");
		for (Product product : products) {
			if (product.getId() == id) {
				products.remove(product);
				break;
			}
		}
		model.addAttribute("products", products);
		return "compare";
	}
}
