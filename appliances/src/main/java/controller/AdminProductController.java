package controller;

import global.BeanFactory;
import global.ProductSearchCondition;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.service.jta.platform.internal.ResinJtaPlatform;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pojo.Catalog;
import pojo.Product;
import service.implement.CatalogServiceImpl;
import service.implement.ProductServiceImpl;

@Controller
public class AdminProductController {
	ProductServiceImpl productService = (ProductServiceImpl) BeanFactory
			.getBean("productService");
	CatalogServiceImpl catalogService = (CatalogServiceImpl)BeanFactory.getBean("catalogService");
	@RequestMapping(value = { "/admin/viewproducts" }, method = RequestMethod.GET)
	public String product(
			ModelMap model,
			HttpServletRequest request,
			@RequestParam(value = "page", required = false) String page
		) {
		String productPerPage = "10";
		HttpSession session = request.getSession();
		ProductSearchCondition searchCondition;
		searchCondition = (ProductSearchCondition)session
				.getAttribute("adminsearchCondition");
		if (searchCondition == null) {
			searchCondition = new ProductSearchCondition(null, null, null, page, productPerPage, null, null);
			session.setAttribute("adminsearchCondition", searchCondition);
		} else {
			if (productPerPage != null) {
				searchCondition.setNumberProductOfPage(productPerPage);
			}
			if(page != null)
			{
				searchCondition.setPage(page);
			}
			session.setAttribute("adminsearchCondition", searchCondition);
			
			
		}
		getProducts(model, searchCondition);
		return "viewproducts";
	}
	
	
	@RequestMapping(value = { "/admin/completeaddproduct" }, method = RequestMethod.GET)
	public String SaveAddProducy(ModelMap model,
			HttpServletRequest request,
			@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "productname", required = false) String productname,
			@RequestParam(value = "loaisanpham", required = false) String loaisanpham,
			@RequestParam(value = "Description", required = false) String Description,
			@RequestParam(value = "gia", required = false) String gia){
		
		String productPerPage = "10";
		HttpSession session = request.getSession();
		ProductSearchCondition searchCondition;
		searchCondition = (ProductSearchCondition)session
				.getAttribute("adminsearchCondition");
		if (searchCondition == null) {
			searchCondition = new ProductSearchCondition(null, null, null, page, productPerPage, null, null);
			session.setAttribute("adminsearchCondition", searchCondition);
		} else {
			if (productPerPage != null) {
				searchCondition.setNumberProductOfPage(productPerPage);
			}
			if(page != null)
			{
				searchCondition.setPage(page);
			}
			session.setAttribute("adminsearchCondition", searchCondition);
			
			
		}
		Catalog catalog = catalogService.get(Integer.parseInt(loaisanpham));
		Product product = new Product(catalog, productname);
		product.setDeleted(false);
		product.setDescription(Description);
		product.setPrice(gia);
		product.setProductInfo(Description);
		product.setRate(1.0);
		product.setRateCount(0);
		
		String result = productService.add(product);
		
		if(result != null){
			model.addAttribute("erroraddproduct", result);
			return "addproduct";
		}
		
		
		getProducts(model, searchCondition);
		return "viewproducts";
	}
	@RequestMapping(value = { "/admin/completeeditproduct" }, method = RequestMethod.GET)
	public String SaveEditProduct(ModelMap model,
			HttpServletRequest request,
			@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "productname", required = false) String productname,
			@RequestParam(value = "loaisanpham", required = false) String loaisanpham,
			@RequestParam(value = "Description", required = false) String Description,
			@RequestParam(value = "gia", required = false) String gia,
			@RequestParam(value = "id", required = false) String id){
		
		
		String productPerPage = "10";
		HttpSession session = request.getSession();
		ProductSearchCondition searchCondition;
		searchCondition = (ProductSearchCondition)session
				.getAttribute("adminsearchCondition");
		if (searchCondition == null) {
			searchCondition = new ProductSearchCondition(null, null, null, page, productPerPage, null, null);
			session.setAttribute("adminsearchCondition", searchCondition);
		} else {
			if (productPerPage != null) {
				searchCondition.setNumberProductOfPage(productPerPage);
			}
			if(page != null)
			{
				searchCondition.setPage(page);
			}
			session.setAttribute("adminsearchCondition", searchCondition);
			
			
		}
		
		
		
		Product product = productService.get(Integer.parseInt(id));
		Catalog catalog = catalogService.get(Integer.parseInt(loaisanpham));
		product.setDescription(Description);
		product.setPrice(gia);
		product.setCatalog(catalog);
		String result = productService.update(product);
		if(result != null){
			model.addAttribute("erroreditproduct", result);
			return "editproduct";
		}
		getProducts(model, searchCondition);
		return "viewproducts";
	}
	
	
	@RequestMapping(value = { "/admin/editproduct" }, method = RequestMethod.GET)
	public String Editproduct(ModelMap model,
			HttpServletRequest request,
			@RequestParam(value = "id", required = false) String id	){
		
		Product product = productService.get(Integer.parseInt(id));
		List<Catalog> catalogs = catalogService.getAll();
		model.addAttribute("catalogs", catalogs);
		model.addAttribute("product", product);
		return "editproduct";
	}
	@RequestMapping(value = { "/admin/addproduct" }, method = RequestMethod.GET)
	public String addproduct(ModelMap model){
		List<Catalog> catalogs = catalogService.getAll();
		model.addAttribute("catalogs", catalogs);
		return "addproduct";
	}
	
	@RequestMapping(value = { "/admin/deleteproduct" }, method = RequestMethod.GET)
	public String DeleteProduct(ModelMap model,
			HttpServletRequest request,
			@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "id", required = false) String id){
		
		String productPerPage = "10";
		HttpSession session = request.getSession();
		ProductSearchCondition searchCondition;
		searchCondition = (ProductSearchCondition)session
				.getAttribute("adminsearchCondition");
		if (searchCondition == null) {
			searchCondition = new ProductSearchCondition(null, null, null, page, productPerPage, null, null);
			session.setAttribute("adminsearchCondition", searchCondition);
		} else {
			if (productPerPage != null) {
				searchCondition.setNumberProductOfPage(productPerPage);
			}
			if(page != null)
			{
				searchCondition.setPage(page);
			}
			session.setAttribute("adminsearchCondition", searchCondition);
			
			
		}
		
		
		
		Product product = productService.get(Integer.parseInt(id));
		product.setDeleted(true);
		String result = productService.update(product);
		if(result != null){
			model.addAttribute("errordelete", result);
		}
		getProducts(model, searchCondition);
		return "viewproducts";
	}
	
	
	public void getProducts (ModelMap model,ProductSearchCondition searchCondition){
		
		
	
		List<Product> products = productService.getProducts(searchCondition);
		int productCount = productService.countProducts(searchCondition);
		model.addAttribute("adminproducts", products);
		model.addAttribute("adminproductCount", productCount);
		model.addAttribute("adminsearchCondition", searchCondition);
		int totalPage = (productCount / Integer.parseInt(searchCondition
				.getNumberProductOfPage()))
				+ ((productCount % Integer.parseInt(searchCondition
						.getNumberProductOfPage())) > 0 ? 1 : 0);
		model.addAttribute("admintotalPage", totalPage);
		model.addAttribute("adminproductPerPage",
				searchCondition.getNumberProductOfPage());
	}
}
