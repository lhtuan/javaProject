package dao;

import java.util.List;

import pojo.Account;
import pojo.Shoppingcart;

public interface IShoppingCartDao {
	public boolean saveOrUpdate(Shoppingcart shoppingCart);
	public Shoppingcart get(int id);
	public List<Shoppingcart> getAll();
	public List<Shoppingcart> getByAccount(String username);
	boolean isExist(int id);
}
