package dao;

import java.util.List;

import pojo.Catalog;

public interface ICatalogDao {
	
	public boolean saveOrUpdate(Catalog catalog);
	public Catalog get(int id);
	public List<Catalog> getAll();
	boolean isExist(String name);
}
