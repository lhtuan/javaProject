package service;

import java.util.List;

import pojo.Shoppingcartdetail;

public interface IShoppingCartDetailService {
	public String add(Shoppingcartdetail cartDetail);
	public String update(Shoppingcartdetail cartDetail);
	public List<Shoppingcartdetail> shoppingcartdetails(int page);
	public int Countshoppingcartdetail();
	public Shoppingcartdetail get(int id);
}
