package service.implement;

import java.util.List;

import pojo.Catalog;
import service.ICatalogService;
import dao.implement.CatalogDaoImpl;

public class CatalogServiceImpl implements ICatalogService {
	private CatalogDaoImpl catalogDao;
	public CatalogDaoImpl getCatalogDao() {
		return catalogDao;
	}

	public void setCatalogDao(CatalogDaoImpl catalogDao) {
		this.catalogDao = catalogDao;
	}
	/***
	 * Them catalog / String: loi / null: them thanh cong
	 */
	public String add(Catalog catalog) {
		if(catalogDao.isExist(catalog.getCatalogName()))
		{
			return "Danh mục đã tồn tại";
		}
		else
		{
			if(catalogDao.saveOrUpdate(catalog))
				return null;
			else
				return "Lỗi chưa xác định";
		}	
	}
	/***
	 * Cap nhat thong tin catalog
	 */
	public String update(Catalog catalog) {
		if(!catalogDao.isExist(catalog.getCatalogName()))
		{
			return "Danh mục không tồn tại";
		}
		else
		{
			if(catalogDao.saveOrUpdate(catalog))
				return null;
			else
				return "Lỗi chưa xác định";
		}	
	}
	/***
	 * Lay toan bo catalog
	 */
	public List<Catalog> getAll() {
		return catalogDao.getAll();
	}

	

	
}
