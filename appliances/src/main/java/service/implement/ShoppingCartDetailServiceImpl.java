package service.implement;

import java.util.List;

import dao.implement.ShoppingCartDetailDaoImpl;
import pojo.Shoppingcart;
import pojo.Shoppingcartdetail;
import service.IShoppingCartDetailService;
import service.IShoppingCartService;

public class ShoppingCartDetailServiceImpl implements IShoppingCartDetailService {
	private ShoppingCartDetailDaoImpl shoppingCartDetailDao;

	public ShoppingCartDetailDaoImpl getShoppingCartDetailDao() {
		return shoppingCartDetailDao;
	}

	public void setShoppingCartDetailDao(
			ShoppingCartDetailDaoImpl shoppingCartDetailDao) {
		this.shoppingCartDetailDao = shoppingCartDetailDao;
	}

	public String add(Shoppingcartdetail cartDetail) {
		if (shoppingCartDetailDao.saveOrUpdate(cartDetail))
			return null;
		else
			return "Lá»—i chÆ°a xÃ¡c Ä‘á»‹nh";
	}

	public String update(Shoppingcartdetail cartDetail) {
		if (!shoppingCartDetailDao.isExist(cartDetail.getId()))
			return "Chi tiáº¿t giá»� hÃ ng khÃ´ng tá»“n táº¡i";
		else if (shoppingCartDetailDao.saveOrUpdate(cartDetail))
			return null;
		else
			return "Lá»—i chÆ°a xÃ¡c Ä‘á»‹nh";
	}

	public List<Shoppingcartdetail> shoppingcartdetails(int page) {
		// TODO Auto-generated method stub
		return shoppingCartDetailDao.Shoppingcartdetails(page);
	}

	public int Countshoppingcartdetail() {
		// TODO Auto-generated method stub
		return shoppingCartDetailDao.CountShoppingcartdetail();
	}

	public Shoppingcartdetail get(int id) {
		// TODO Auto-generated method stub
		return shoppingCartDetailDao.get(id);
	}

}
