package controller;

import global.BeanFactory;
import global.LoggHelper;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.Shoppingcart;
import pojo.Shoppingcartdetail;
import service.implement.ProductServiceImpl;

@Controller
public class CartController {
	@RequestMapping(value = { "/cart" }, method = RequestMethod.GET)
	public String showCart(ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Shoppingcart cart = (Shoppingcart) session.getAttribute("cart");
		model.addAttribute("cart", cart);
		int total = getTotalPrice(cart);
		model.addAttribute("total", total);
		return "cart";
	}

	@RequestMapping(value = { "/cart/add" }, method = RequestMethod.GET)
	public String add(ModelMap model, HttpServletRequest request,
			@RequestParam(value = "id") String strId,
			@RequestParam(value = "number") String strNumber) {
		ProductServiceImpl productService = (ProductServiceImpl) BeanFactory
				.getBean("productService");
		int id = Integer.parseInt(strId);
		int number = Integer.parseInt(strNumber);
		HttpSession session = request.getSession();
		Shoppingcart cart = (Shoppingcart) session.getAttribute("cart");
		if (cart == null)
			cart = new Shoppingcart();
		Shoppingcartdetail cartDetail = new Shoppingcartdetail();
		cartDetail.setProduct(productService.get(id));
		cartDetail.setNumber(number);
		cart = addToCart(cart, cartDetail);
		session.setAttribute("cart", cart);
		model.addAttribute("cart", cart);
		int total = getTotalPrice(cart);
		model.addAttribute("total", total);
		LoggHelper.info("Add to cart success, cart number : "
				+ cart.getShoppingcartdetails().size());
		return "cart";
	}

	@RequestMapping(value = { "cart/edit" }, method = RequestMethod.GET)
	public @ResponseBody
	List<String> edit(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("id") int id, @RequestParam("number") int number) {
		HttpSession session = request.getSession();
		Shoppingcart cart = (Shoppingcart) session.getAttribute("cart");
		for (Shoppingcartdetail detail : cart.getShoppingcartdetails()) {
			if (detail.getProduct().getId() == id) {
				detail.setNumber(number);
			}
		}
		session.setAttribute("cart", cart);
		List<String> data = new ArrayList<String>();
		data.add(getTotalPrice(cart) + "");
		data.add(getCartNumber(cart) + "");
		return data;
	}

	@RequestMapping(value = { "cart/delete" }, method = RequestMethod.GET)
	public @ResponseBody
	List<String> delete(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("id") int id) {
		HttpSession session = request.getSession();
		Shoppingcart cart = (Shoppingcart) session.getAttribute("cart");
		for (Shoppingcartdetail detail : cart.getShoppingcartdetails()) {
			if (detail.getProduct().getId() == id) {
				cart.getShoppingcartdetails().remove(detail);
			}
		}
		session.setAttribute("cart", cart);
		List<String> data = new ArrayList<String>();
		data.add(getTotalPrice(cart) + "");
		data.add(getCartNumber(cart) + "");
		return data;
	}

	private Shoppingcart addToCart(Shoppingcart cart,
			Shoppingcartdetail cartDetail) {
		for (Shoppingcartdetail detail : cart.getShoppingcartdetails()) {
			if (cartDetail.getProduct().getProductName()
					.equalsIgnoreCase(detail.getProduct().getProductName())) {
				// san pham da ton tai, tang so luong
				detail.setNumber(detail.getNumber() + cartDetail.getNumber());
				return cart;
			}
		}
		// san pham chua co trong gio
		cart.getShoppingcartdetails().add(cartDetail);
		return cart;
	}

	private int getTotalPrice(Shoppingcart cart) {
		int total = 0;
		if (cart != null) {
			for (Shoppingcartdetail detail : cart.getShoppingcartdetails()) {
				total += detail.getNumber()
						* Integer.parseInt(detail.getProduct().getPrice());
			}
		}
		return total;
	}

	private int getCartNumber(Shoppingcart cart) {
		int number = 0;
		if (cart != null) {
			for (Shoppingcartdetail detail : cart.getShoppingcartdetails()) {
				number += detail.getNumber();
			}
		}
		return number;
	}
}
