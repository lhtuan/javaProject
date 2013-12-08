package dao.implement;

import global.LoggHelper;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pojo.Catalog;
import dao.ICatalogDao;
import dao.base.BaseDao;

@Repository
public class CatalogDaoImpl extends BaseDao implements ICatalogDao {

	@Transactional
	public boolean saveOrUpdate(Catalog catalog) {
		try {
			session().saveOrUpdate(catalog);
			LoggHelper.info("Catalog is saved or updated");
		} catch (Exception ex) {
			LoggHelper.waring("Error when save or update catalog: "
					+ ex.getMessage());
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Catalog> getAll() {
		Query query = session().createQuery("from Catalog");
		List<Catalog> catalogs = null;
		try {
			catalogs = query.list();
			LoggHelper.info("Get all catalogs success");
		} catch (Exception ex) {
			LoggHelper.waring("Error when get all catalog: " + ex.getMessage());
		}
		return catalogs;
	}

	@Transactional
	public Catalog get(int id) {
		Catalog catalog = null;
		try {
			catalog = (Catalog) session().get(Catalog.class, id);
			LoggHelper.info("Get catalog success");
		} catch (Exception ex) {
			LoggHelper.waring("Error when get catalog: " + ex.getMessage());
		}
		return catalog;
	}
	@Transactional
	public boolean isExist(String name) {
		Query query = session().createQuery(
				"from Catalog c where c.CatalogName = '" + name + "'");
		List<Catalog> catalogs = null;
		try {
			catalogs = query.list();
			LoggHelper.info("Check catalog exist success");
		} catch (Exception ex) {
			LoggHelper.waring("Error whenCheck catalog exist: "
					+ ex.getMessage());
		}
		if (catalogs == null)
			return false;
		else if (catalogs.size() == 0)
			return false;
		return true;
	}

}
