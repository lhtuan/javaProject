package service;

import global.ProductSearchCondition;

import java.util.List;

import pojo.Product;

public interface IProductService {
	public String add(Product product);
	public String update(Product product);
	public List<Product> getProducts(ProductSearchCondition condition);
	public int countProducts(ProductSearchCondition condition);
	public Product get(int id);
}
