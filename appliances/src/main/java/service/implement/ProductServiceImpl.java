package service.implement;

import global.MathHelper;
import global.ProductSearchCondition;

import java.util.List;

import dao.implement.ProductDaoImpl;
import pojo.Product;
import service.IProductService;

public class ProductServiceImpl implements IProductService {
	private ProductDaoImpl productDao;
	public ProductDaoImpl getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDaoImpl productDao) {
		this.productDao = productDao;
	}
	/***
	 * Them product / String : loi / null: them thanh cong
	 */
	public String add(Product product) {
		if(productDao.isExist(product.getProductName()))
		{
			return "Sản phẩm đã tồn tại";
		}
		else
		{
			if(productDao.saveOrUpdate(product))
				return null;
			else
				return "Lỗi chưa xác định";
		}
	}
	/***
	 * Cap nhat thong tin san pham / String : loi / null: cap nhat thanh cong
	 */
	public String update(Product product) {
		if(!productDao.isExist(product.getProductName()))
		{
			return "Sản phẩm không tồn tại";
		}
		else
		{
			if(productDao.saveOrUpdate(product))
				return null;
			else
				return "Lỗi chưa xác định";
		}
	}
	
	public List<Product> getProducts(ProductSearchCondition condition) {
		condition = processSearCondition(condition);
		return productDao.getProducts(condition);
	}

	public int countProducts(ProductSearchCondition condition) {
		return productDao.countProducts(condition);
	}

	private  ProductSearchCondition processSearCondition(ProductSearchCondition condition)
	{
		String strPage =condition.getPage();
		if(strPage == null || !MathHelper.isNumber(strPage))
		{
			strPage ="1";
			condition.setPage(strPage);
		}
		String strProductPerPage = condition.getNumberProductOfPage();
		if(strProductPerPage == null || !MathHelper.isNumber(strProductPerPage))
		{
			strProductPerPage = "14";
			condition.setNumberProductOfPage(strProductPerPage);
		}
		return condition;
	}

	public Product get(int id) {
		return productDao.get(id);
	}

	
}
