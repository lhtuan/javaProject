package service;

import java.util.List;

import pojo.Account;
import pojo.Shoppingcart;

public interface IShoppingCartService {
	public String add(Shoppingcart shoppingCart);
	public String update(Shoppingcart shoppingCart);
	public List<Shoppingcart> getAll();
	public List<Shoppingcart> getByAccount(String username,int page);
	public int CountByAccount(String username);
	public List<Shoppingcart> getShoppingCarts(int page);
	public int CountShoppingCart();
	public Shoppingcart get(int id);
}
