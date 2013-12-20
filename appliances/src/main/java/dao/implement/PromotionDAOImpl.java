package dao.implement;

import global.LoggHelper;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pojo.Catalog;
import pojo.Promotion;
import dao.IPromotionDAO;
import dao.base.BaseDao;
@Repository
public class PromotionDAOImpl extends BaseDao implements IPromotionDAO{

	@Transactional
	public boolean saveOrUpdate(Promotion promotion) {
		// TODO Auto-generated method stub
		try {
			session().saveOrUpdate(promotion);
			LoggHelper.info("Promotion is saved or updated");
		} catch (Exception ex) {
			LoggHelper.waring("Error when save or update promotion: "
					+ ex.getMessage());
		}
		return true;
	}
	@Transactional
	public Promotion get(int id) {
		// TODO Auto-generated method stub
		Promotion promotion = null;
		try {
			promotion = (Promotion) session().get(Promotion.class, id);
			LoggHelper.info("Get Promotion success");
		} catch (Exception ex) {
			LoggHelper.waring("Error when get Promotion: " + ex.getMessage());
		}
		return promotion;
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Promotion> getAll() {
		// TODO Auto-generated method stub
		Query query = session().createQuery("from Promotion");
		List<Promotion> promotions = null;
		try {
			promotions = query.list();
			LoggHelper.info("Get all Promotion success");
		} catch (Exception ex) {
			LoggHelper.waring("Error when get all Promotion: " + ex.getMessage());
		}
		return promotions;
	}
	@Transactional
	public boolean isExist(String name) {
		// TODO Auto-generated method stub
		Query query = session().createQuery(
				"from Promotion c where c.Id = '" + name + "'");
		List<Promotion> promotions = null;
		try {
			promotions = query.list();
			LoggHelper.info("Check Promotion exist success");
		} catch (Exception ex) {
			LoggHelper.waring("Error whenCheck Promotion exist: "
					+ ex.getMessage());
		}
		if (promotions == null)
			return false;
		else if (promotions.size() == 0)
			return false;
		return true;
	}
	@Transactional
	public List<Promotion> getPromotions(int page) {
		// TODO Auto-generated method stub
		 int numberPromotionOfPage = 10;
		Query query = session().createQuery("from Promotion c where c.deleted = false ");
		List<Promotion> promotions = null;
		try {
			query.setFirstResult(numberPromotionOfPage * (page - 1));
			query.setMaxResults(numberPromotionOfPage);
			promotions = query.list();
			LoggHelper.info("Get Promotions success");
		} catch (Exception ex) {
			LoggHelper.waring("Error when get Promotions: " + ex.getMessage());
		}
		return promotions;
	}
	@Transactional
	public int CountPromotion() {
		// TODO Auto-generated method stub
		int count = 0;
		Query query = session().createQuery("select count(*) from Promotion c where c.deleted = false ");
		List<Promotion> promotions = null;
		try {
			count = Integer.parseInt(query.list().get(0).toString());
			LoggHelper.info("count Promotion success");
		} catch (Exception ex) {
			LoggHelper.waring("Error when count Promotion: " + ex.getMessage());
		}
		return count;
	}
	public boolean Delete(int id ) {
		// TODO Auto-generated method stub
		Promotion promotion = null;
		try {
			promotion = (Promotion) session().get(Promotion.class, id);
			session().delete(promotion);
			LoggHelper.info("Promotion is delete");
		} catch (Exception ex) {
			LoggHelper.waring("Error when delte promotion: "
					+ ex.getMessage());
		}
		return true;
	}

}
