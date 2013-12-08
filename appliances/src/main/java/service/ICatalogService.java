package service;

import java.util.List;

import pojo.Catalog;

public interface ICatalogService {
	public String add(Catalog catalog);
	public String update(Catalog catalog);
	public List<Catalog> getAll();
}
