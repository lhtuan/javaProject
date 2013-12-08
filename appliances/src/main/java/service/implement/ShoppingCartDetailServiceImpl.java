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
			return "Lỗi chưa xác định";
	}

	public String update(Shoppingcartdetail cartDetail) {
		if (!shoppingCartDetailDao.isExist(cartDetail.getId()))
			return "Chi tiết giỏ hàng không tồn tại";
		else if (shoppingCartDetailDao.saveOrUpdate(cartDetail))
			return null;
		else
			return "Lỗi chưa xác định";
	}

}
