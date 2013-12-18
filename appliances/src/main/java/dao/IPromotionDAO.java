package dao;

import java.util.List;

import pojo.Promotion;



public interface IPromotionDAO {
	public boolean saveOrUpdate(Promotion promotion);
	public Promotion get(int id);
	public List<Promotion> getAll();
	public List<Promotion> getPromotions(int page);
	boolean isExist(String name);
	public int CountPromotion();
	public boolean Delete(int id);
}
