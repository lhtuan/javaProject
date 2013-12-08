package service.implement;

import java.util.List;

import dao.implement.ShoppingCartDaoImpl;
import pojo.Shoppingcart;
import service.IShoppingCartService;

public class ShoppingCartServiceImpl implements IShoppingCartService {
	private ShoppingCartDaoImpl shoppingCartDao;
	public ShoppingCartDaoImpl getShoppingCartDao() {
		return shoppingCartDao;
	}

	public void setShoppingCartDao(ShoppingCartDaoImpl shoppingCartDao) {
		this.shoppingCartDao = shoppingCartDao;
	}

	public String add(Shoppingcart shoppingCart) {
		if(shoppingCartDao.saveOrUpdate(shoppingCart))
			return null;
		else
			return "Lỗi chưa xác định";
	}
	/***
	 * Cap nhat thong tin gio hang
	 */
	public String update(Shoppingcart shoppingCart) {
		if(!shoppingCartDao.isExist(shoppingCart.getId()))
		{
			return "Giỏ hàng chưa tồn tại";
		}
		else
		{
			if(shoppingCartDao.saveOrUpdate(shoppingCart))
				return null;
			else
				return "Lỗi chưa xác định";
		}
	}

	public List<Shoppingcart> getAll() {
		// TODO Auto-generated method stub
		return shoppingCartDao.getAll();
	}

	public List<Shoppingcart> getByAccount(String username) {
		// TODO Auto-generated method stub
		return shoppingCartDao.getByAccount(username);
	}

	
}
