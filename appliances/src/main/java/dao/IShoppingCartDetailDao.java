package dao;

import java.util.List;

import pojo.Shoppingcartdetail;

public interface IShoppingCartDetailDao {
	public boolean saveOrUpdate(Shoppingcartdetail shoppingCartDetail);
	public Shoppingcartdetail get(int id);
	public List<Shoppingcartdetail> getAll();
	public boolean isExist(int id);
}
