package intercepter;

import global.BeanFactory;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import pojo.Catalog;
import pojo.Shoppingcart;
import pojo.Shoppingcartdetail;
import service.implement.CatalogServiceImpl;

public class Intercepter implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub

		return true;
	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		modelAndView = new ModelAndView();
		CatalogServiceImpl catalogService = (CatalogServiceImpl) BeanFactory
				.getBean("catalogService");
		List<Catalog> catalogs = catalogService.getAll();
		request.setAttribute("catalogs", catalogs);

		int cartNumber = 0;
		int totalPrice = 0;
		HttpSession session = request.getSession();
		if (session != null) {
			Shoppingcart cart = (Shoppingcart) session.getAttribute("cart");
			if (cart != null) {
				for (Shoppingcartdetail detail : cart.getShoppingcartdetails()) {
					cartNumber += detail.getNumber();
					totalPrice += detail.getNumber()
							* Integer.parseInt(detail.getProduct().getPrice());
				}
			}
		}
		request.setAttribute("cartNumber", cartNumber);
		request.setAttribute("totalPrice", totalPrice);
	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
