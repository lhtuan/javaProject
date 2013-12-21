package service.implement;

import java.util.List;

import pojo.Shoppingcart;
import service.IShoppingCartService;
import dao.implement.ShoppingCartDaoImpl;

public class ShoppingCartServiceImpl implements IShoppingCartService {
	private ShoppingCartDaoImpl shoppingCartDao;

	public ShoppingCartDaoImpl getShoppingCartDao() {
		return shoppingCartDao;
	}

	public void setShoppingCartDao(ShoppingCartDaoImpl shoppingCartDao) {
		this.shoppingCartDao = shoppingCartDao;
	}

	public String add(Shoppingcart shoppingCart) {
		if (shoppingCartDao.saveOrUpdate(shoppingCart))
			return null;
		else
			return "Lá»—i chÆ°a xÃ¡c Ä‘á»‹nh";
	}

	/***
	 * Cap nhat thong tin gio hang
	 */
	public String update(Shoppingcart shoppingCart) {
		if (!shoppingCartDao.isExist(shoppingCart.getId())) {
			return "Giá»� hÃ ng khÃ´ng tá»“n táº¡i";
		} else {
			if (shoppingCartDao.saveOrUpdate(shoppingCart))
				return null;
			else
				return "Lá»—i chÆ°a xÃ¡c Ä‘á»‹nh";
		}
	}

	public List<Shoppingcart> getAll() {
		// TODO Auto-generated method stub
		return shoppingCartDao.getAll();
	}

	public List<Shoppingcart> getByAccount(String username,int page) {
		// TODO Auto-generated method stub
		return shoppingCartDao.getByAccount(username,page);
	}

	public List<Shoppingcart> getShoppingCarts(int page) {
		// TODO Auto-generated method stub
		return shoppingCartDao.getShoppingcart(page);
	}

	public int CountShoppingCart() {
		// TODO Auto-generated method stub
		return shoppingCartDao.CountShoppingCart();
	}

	public Shoppingcart get(int id) {
		// TODO Auto-generated method stub
		return shoppingCartDao.get(id);
	}

	public int CountByAccount(String username) {
		// TODO Auto-generated method stub
		return shoppingCartDao.CountByAccount(username);
	}

}
