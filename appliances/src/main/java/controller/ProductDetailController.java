package controller;

import global.BeanFactory;
import global.MathHelper;
import global.ProductSearchCondition;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
		List<Product> SameProducts = productService.getProducts(new ProductSearchCondition(null, null, null, null, null,catalogID+"",null));
		List<Product> FourSameProducts = new ArrayList<Product>();
		int countSameProduct = 1;
		for (Product tempProduct : SameProducts) {
			if (countSameProduct <= 4) {
				if (tempProduct.getId() != id)
					FourSameProducts.add(tempProduct);
				countSameProduct++;
			}

		}
		product.setRate(MathHelper.roundDouble(product.getRate(), 1));
		model.addAttribute("FourSameProducts", FourSameProducts);
		model.addAttribute("product", product);
		return "productDetail";
	}
	@RequestMapping(value={"/productDetail/rate"},method = RequestMethod.GET)
	public @ResponseBody List<String> rate(@RequestParam("id")int id,@RequestParam("rate")double rate)
	{
		List<String> data = new ArrayList<String>();
		ProductServiceImpl productService = (ProductServiceImpl) BeanFactory
				.getBean("productService");
		Product product = productService.get(id);
		int rateCount = product.getRateCount();
		double curRate = product.getRate();// lay rate hien tai
		curRate = (curRate*rateCount +rate)/(rateCount+1);
		rateCount++;//cap nhat len 1;
		product.setRateCount(rateCount);
		product.setRate(curRate);
		productService.update(product);
		curRate = MathHelper.roundDouble(curRate, 1);
		data.add(String.valueOf(curRate));
		data.add(String.valueOf(rateCount));
		return data;
	}
}
