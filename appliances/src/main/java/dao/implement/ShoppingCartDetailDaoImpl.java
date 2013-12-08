package dao.implement;

import global.LoggHelper;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pojo.Shoppingcartdetail;
import dao.IShoppingCartDetailDao;
import dao.base.BaseDao;

@Repository
public class ShoppingCartDetailDaoImpl extends BaseDao implements
		IShoppingCartDetailDao {
	@Transactional
	public boolean saveOrUpdate(Shoppingcartdetail shoppingCartDetail) {
		try {
			session().saveOrUpdate(shoppingCartDetail);
			LoggHelper.info("Shopping cart detail is saved or updated");
		} catch (Exception ex) {
			LoggHelper.waring("Error when save or update shopping cart detai");
			return false;
		}
		return true;
	}

	@Transactional
	public Shoppingcartdetail get(int id) {
		Shoppingcartdetail shoppingCartDetail = null;
		try {
			shoppingCartDetail = (Shoppingcartdetail) session().get(
					Shoppingcartdetail.class, id);
			LoggHelper.info("Get shopping cart detail success");
		} catch (Exception ex) {
			LoggHelper.waring("Error when get shopping cart detail");
		}
		return shoppingCartDetail;
	}

	@Transactional
	public List<Shoppingcartdetail> getAll() {
		List<Shoppingcartdetail> shoppingCartDetails = null;
		try {
			Query query = session().createQuery("from Shoppingcartdetail");
			shoppingCartDetails = query.list();
			LoggHelper.info("Get shopping cart details success");
		} catch (Exception ex) {
			LoggHelper.waring("Error when get shopping cart details");
		}
		return shoppingCartDetails;
	}

	public boolean isExist(int id) {
		return get(id) == null ? false : true;
	}

}
