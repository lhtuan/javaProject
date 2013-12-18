package controller;

import global.BeanFactory;
import global.ProductSearchCondition;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pojo.Product;
import service.implement.ProductServiceImpl;

@Controller
public class ProductController {
	@RequestMapping(value = { "/product" }, method = RequestMethod.GET)
	public String product(
			ModelMap model,
			HttpServletRequest request,
			@RequestParam(value = "isKeepProduct", required = false) String isKeepProduct,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "catalog", required = false) String catalog,
			@RequestParam(value = "minPrice", required = false) String minPrice,
			@RequestParam(value = "maxPrice", required = false) String maxPrice,
			@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "productPerPage", required = false) String productPerPage) {
		HttpSession session = request.getSession();
		if (isKeepProduct == null)
			session.removeAttribute("searchCondition");
		ProductSearchCondition searchCondition;
		searchCondition = (ProductSearchCondition)session
				.getAttribute("searchCondition");
		if (searchCondition == null) {
			searchCondition = new ProductSearchCondition(name, minPrice,
					maxPrice, page, productPerPage, catalog,null);
			session.setAttribute("searchCondition", searchCondition);
		} else {
			if (productPerPage != null) {
				searchCondition.setNumberProductOfPage(productPerPage);
			}
			if(page != null)
			{
				searchCondition.setPage(page);
			}
			session.setAttribute("searchCondition", searchCondition);
		}
		
		ProductServiceImpl productService = (ProductServiceImpl) BeanFactory
				.getBean("productService");
		List<Product> products = productService.getProducts(searchCondition);
		int productCount = productService.countProducts(searchCondition);
		model.addAttribute("products", products);
		model.addAttribute("productCount", productCount);
		model.addAttribute("searchCondition", searchCondition);
		int totalPage = (productCount / Integer.parseInt(searchCondition
				.getNumberProductOfPage()))
				+ ((productCount % Integer.parseInt(searchCondition
						.getNumberProductOfPage())) > 0 ? 1 : 0);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("productPerPage",
				searchCondition.getNumberProductOfPage());
		return "product";
	}
}
