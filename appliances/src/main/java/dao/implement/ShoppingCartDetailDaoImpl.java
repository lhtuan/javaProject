package dao.implement;

import global.LoggHelper;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pojo.Promotion;
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
			Query query = session().createQuery("from Shoppingcartdetail c where c.deleted = false");
			shoppingCartDetails = query.list();
			LoggHelper.info("Get shopping cart details success");
		} catch (Exception ex) {
			LoggHelper.waring("Error when get shopping cart details");
		}
		return shoppingCartDetails;
	}
	@Transactional
	public boolean isExist(int id) {
		return get(id) == null ? false : true;
	}
	@Transactional
	public List<Shoppingcartdetail> Shoppingcartdetails(int page) {
		// TODO Auto-generated method stub
		 int numberPromotionOfPage = 10;
			Query query = session().createQuery("from Shoppingcartdetail c where c.deleted = false ");
			List<Shoppingcartdetail> Shoppingcartdetails = null;
			try {
				query.setFirstResult(numberPromotionOfPage * (page - 1));
				query.setMaxResults(numberPromotionOfPage);
				Shoppingcartdetails = query.list();
				LoggHelper.info("Get Shoppingcartdetails success");
			} catch (Exception ex) {
				LoggHelper.waring("Error when get Shoppingcartdetails: " + ex.getMessage());
			}
			return Shoppingcartdetails;
	}
	@Transactional
	public int CountShoppingcartdetail() {
		// TODO Auto-generated method stub
		int count = 0;
		Query query = session().createQuery("select count(*) from Shoppingcartdetail ");
		List<Shoppingcartdetail> Shoppingcartdetails = null;
		try {
			count = Integer.parseInt(query.list().get(0).toString());
			LoggHelper.info("count Shoppingcartdetail success");
		} catch (Exception ex) {
			LoggHelper.waring("Error when count Shoppingcartdetail: " + ex.getMessage());
		}
		return count;
	}

	public Shoppingcartdetail getbyCart(int idCart) {
		// TODO Auto-generated method stub
//		List<Shoppingcartdetail> shoppingCartDetail = null;
//		try {
//			Query query = session().createQuery("from Shoppingcartdetail c where c.shoppingcart = "+idCart+"");)
//			shoppingCartDetail = query.list();
//			LoggHelper.info("Get shopping cart detail success");
//		} catch (Exception ex) {
//			LoggHelper.waring("Error when get shopping cart detail");
//		}
//		return shoppingCartDetail;
		return null;
	}

}
