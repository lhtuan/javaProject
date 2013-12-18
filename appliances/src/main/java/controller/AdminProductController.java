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
public class AdminProductController {
	@RequestMapping(value = { "/admin/viewproducts" }, method = RequestMethod.GET)
	public String product(
			ModelMap model,
			HttpServletRequest request,
			@RequestParam(value = "page", required = false) String page
		) {
//		String productPerPage = "10";
//		HttpSession session = request.getSession();
//		ProductSearchCondition searchCondition;
//		searchCondition = (ProductSearchCondition)session
//				.getAttribute("adminsearchCondition");
//		if (searchCondition == null) {
//			searchCondition = new ProductSearchCondition(null, null,
//					null, page, productPerPage, null);
//			session.setAttribute("adminsearchCondition", searchCondition);
//		} else {
//			if (productPerPage != null) {
//				searchCondition.setNumberProductOfPage(productPerPage);
//			}
//			if(page != null)
//			{
//				searchCondition.setPage(page);
//			}
//			session.setAttribute("adminsearchCondition", searchCondition);
//		}
//		
//		ProductServiceImpl productService = (ProductServiceImpl) BeanFactory
//				.getBean("productService");
//		List<Product> products = productService.getProducts(searchCondition);
//		int productCount = productService.countProducts(searchCondition);
//		model.addAttribute("adminproducts", products);
//		model.addAttribute("adminproductCount", productCount);
//		model.addAttribute("adminsearchCondition", searchCondition);
//		int totalPage = (productCount / Integer.parseInt(searchCondition
//				.getNumberProductOfPage()))
//				+ ((productCount % Integer.parseInt(searchCondition
//						.getNumberProductOfPage())) > 0 ? 1 : 0);
//		model.addAttribute("admintotalPage", totalPage);
//		model.addAttribute("adminproductPerPage",
//				searchCondition.getNumberProductOfPage());
		return "viewproducts";
	}
}
