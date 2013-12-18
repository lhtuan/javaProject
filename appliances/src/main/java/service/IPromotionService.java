package service;

import java.util.List;

import pojo.Promotion;



public interface IPromotionService {
	public String add(Promotion promotion);
	public String update(Promotion promotion);
	public List<Promotion> getAll();
	public List<Promotion> getPromotions(int page);
	public int CountPromotion();
	public Promotion get(int id);
	public String Delete(int id);
}
