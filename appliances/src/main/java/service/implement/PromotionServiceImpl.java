package service.implement;

import java.util.List;

import dao.implement.CatalogDaoImpl;
import dao.implement.PromotionDAOImpl;
import pojo.Promotion;
import service.IPromotionService;

public class PromotionServiceImpl implements IPromotionService{

	private PromotionDAOImpl promotiondao;
	public PromotionDAOImpl getPromotionDao() {
		return promotiondao;
	}

	public void setPromotionDAO(PromotionDAOImpl promotiondao) {
		this.promotiondao = promotiondao;
	}
	public String add(Promotion promotion) {
		// TODO Auto-generated method stub
		if(promotiondao.isExist(promotion.getPromotionName()))
		{
			return "Danh mục đã tồn tại";
		}
		else
		{
			if(promotiondao.saveOrUpdate(promotion))
				return null;
			else
				return "Lỗi chưa xác định";
		}	
	}

	public String update(Promotion promotion) {
		// TODO Auto-generated method stub
//		if(!promotiondao.isExist(promotion.getPromotionName()))
//		{
//			return "Danh mục không tồn tại";
//		}
//		else
//		{
			if(promotiondao.saveOrUpdate(promotion))
				return null;
			else
				return "Lỗi chưa xác định";
//		}	
	}

	public List<Promotion> getAll() {
		// TODO Auto-generated method stub
		return promotiondao.getAll();
	}

	public List<Promotion> getPromotions(int page) {
		// TODO Auto-generated method stub
		return promotiondao.getPromotions(page);
	}

	public int CountPromotion() {
		// TODO Auto-generated method stub
		return promotiondao.CountPromotion();
	}

	public Promotion get(int id) {
		// TODO Auto-generated method stub
		return promotiondao.get(id);
	}

	public String Delete(int id) {
		// TODO Auto-generated method stub
		if(promotiondao.Delete(id))
			return null;
		else
			return "Lỗi chưa xác định";
	}
	

}
