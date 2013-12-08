package dao.implement;

import global.LoggHelper;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pojo.Account;
import pojo.Shoppingcart;
import dao.IShoppingCartDao;
import dao.base.BaseDao;
@Repository
public class ShoppingCartDaoImpl extends BaseDao implements IShoppingCartDao {
	@Transactional
	public boolean saveOrUpdate(Shoppingcart shoppingCart) {
		try {
			session().saveOrUpdate(shoppingCart);
			LoggHelper.info("Shopping cart is saved or updated");
		} catch (Exception ex) {
			LoggHelper.waring("Error when save or update shopping cart");
			return false;
		}
		return true;
	}
	@Transactional
	public Shoppingcart get(int id) {
		Shoppingcart shoppingCart = null;
		try {
			shoppingCart = (Shoppingcart) session().get(Shoppingcart.class, id);
			LoggHelper.info("Get shopping cart success");
		} catch (Exception ex) {
			LoggHelper.waring("Error when get shopping cart");
		}
		return shoppingCart;
	}
	@Transactional
	public List<Shoppingcart> getAll() {
		List<Shoppingcart> shoppingCarts = null;
		try {
			Query query = session().createQuery("from Shoppingcart");
			shoppingCarts = query.list();
			LoggHelper.info("Get shopping carts success");
		} catch (Exception ex) {
			LoggHelper.waring("Error when get shopping carts");
		}
		return shoppingCarts;
	}
	@Transactional
	public List<Shoppingcart> getByAccount(String username) {
		List<Shoppingcart> shoppingCarts = null;
		try {
			Query query = session().createQuery(
					"from Shoppingcart cart where cart.Username = '" + username
							+ "'");
			shoppingCarts = query.list();
			LoggHelper.info("Get shopping carts success");
		} catch (Exception ex) {
			LoggHelper.waring("Error when get shopping carts");
		}
		return shoppingCarts;
	}
	@Transactional
	public boolean isExist(int id) {
		return get(id) == null ? false : true;
	}

}
