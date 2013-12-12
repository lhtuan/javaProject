package dao;

import global.ProductSearchCondition;

import java.util.List;

import pojo.Product;

public interface IProductDao {
	public boolean saveOrUpdate(Product product);
	public Product get(int id);
	public List<Product> getAll();
	public List<Product> getProducts(ProductSearchCondition searchCondition);
	public int countProducts(ProductSearchCondition searchCondition);
	public boolean isExist(String name);
	
}
