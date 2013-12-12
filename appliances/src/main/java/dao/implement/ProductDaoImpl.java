package dao.implement;

import global.LoggHelper;
import global.ProductSearchCondition;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pojo.Product;
import dao.IProductDao;
import dao.base.BaseDao;
@Repository
public class ProductDaoImpl extends BaseDao implements IProductDao {
	@Transactional
	public boolean saveOrUpdate(Product product) {
		try {
			session().saveOrUpdate(product);
			LoggHelper.info("Product is saved or updated");
		} catch (Exception ex) {
			LoggHelper.waring("Error when save or update product: "
					+ ex.getMessage());
			return false;
		}
		return true;
	}
	@Transactional
	public Product get(int id) {
		Product product = null;
		try {
			product = (Product) session().get(Product.class, id);
			LoggHelper.info("Get product success");
		} catch (Exception ex) {
			LoggHelper.waring("Error get product: " + ex.getMessage());
		}
		return product;
	}
	/***
	 * Lay danh sach san pham
	 */
	@Transactional
	public List<Product> getProducts(ProductSearchCondition searchCondition) {
		List<Product> Products = null;
		int page = Integer.parseInt(searchCondition.getPage());
		int numberProductOfPage = Integer.parseInt(searchCondition
				.getNumberProductOfPage());
		String hql = "from Product " + searchCondition.getConditionString();
		try {
			Query query = session().createQuery(hql);
			if (searchCondition.getName() != null) {
				query.setString(0, "%" + searchCondition.getName() + "%");
			}
			query.setFirstResult(numberProductOfPage * (page - 1));
			query.setMaxResults(numberProductOfPage);
			Products = query.list();
			LoggHelper.info("Get products success");
		} catch (Exception ex) {
			LoggHelper.waring("Get products error: " + ex.getMessage());
		}
		return Products;
	}
	@Transactional
	public int countProducts(ProductSearchCondition searchCondition) {
		int count = 0;
		String hql = "select count(*) from Product "
				+ searchCondition.getConditionString();
		try {
			Query query = session().createQuery(hql);
			if (searchCondition.getName() != null) {
				query.setString(0, "%" + searchCondition.getName() + "%");
			}
			count = Integer.parseInt(query.list().get(0).toString());
			LoggHelper.info("Get products success");
		} catch (Exception ex) {
			LoggHelper.waring("Get products error: " + ex.getMessage());
		}
		return count;
	}
	@Transactional
	public List<Product> getAll() {
		List<Product> Products = null;
		try {
			Query query = session().createQuery("from Product");
			Products = query.list();
			LoggHelper.info("Get products success");
		} catch (Exception ex) {
			LoggHelper.waring("Get products error: " + ex.getMessage());
		}
		return Products;
	}
	@Transactional
	public boolean isExist(String name) {
		List<Product> Products = null;
		try {
			Query query = session().createQuery(
					"from Product p where p.ProductName = '" + name + "'");
			Products = query.list();
			LoggHelper.info("Check product exist success");
		} catch (Exception ex) {
			LoggHelper.waring("Check product exist error: " + ex.getMessage());
		}
		if (Products == null)
			return false;
		else if (Products.size() == 0)
			return false;
		return true;
	}
	
}
