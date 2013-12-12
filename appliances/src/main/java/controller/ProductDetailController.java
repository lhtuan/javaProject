package controller;

import global.BeanFactory;
import global.ProductSearchCondition;

import java.util.ArrayList;
import java.util.List;

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
	@RequestMapping(value = { "/productDetail" }, method = RequestMethod.GET)
	String productDetail(ModelMap model, HttpServletRequest request,
			@RequestParam(value = "id") int id) {

		ProductServiceImpl productService = (ProductServiceImpl) BeanFactory
				.getBean("productService");
		Product product = productService.get(id);
		int catalogID = product.getCatalog().getId();
		List<Product> SameProducts = productService.getProducts(new ProductSearchCondition(null, null, null, null, null, catalogID+""));
		List<Product> FourSameProducts = new ArrayList<Product>();
		int countSameProduct = 1;
		for (Product tempProduct : SameProducts) {
			if (countSameProduct <= 4) {
				if (tempProduct.getId() != id)
					FourSameProducts.add(tempProduct);
				countSameProduct++;
			}

		}
		model.addAttribute("FourSameProducts", FourSameProducts);
		model.addAttribute("product", product);
		return "productDetail";
	}
}
