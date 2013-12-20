package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import global.BeanFactory;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pojo.Promotion;
import service.implement.PromotionServiceImpl;

@Controller
public class PromotionController {

	private int numberPromotionofPage = 10;
	@RequestMapping(value={"/admin/viewpromotion"},method = RequestMethod.GET)
	public String Promotions(ModelMap model,	HttpServletRequest request,
			@RequestParam(value = "page",required=false) String page)
	{
		String ipage = "";
		if(page ==null)
			page="1";
		ipage = page;
			
		int intpage = Integer.parseInt(page);
		PromotionServiceImpl promotionService = (PromotionServiceImpl)BeanFactory.getBean("promotionService");
		List<Promotion> Promotions = promotionService.getPromotions(intpage);
		int PromotionCount = promotionService.CountPromotion();
		int totalPage = (PromotionCount/numberPromotionofPage) + ((PromotionCount/numberPromotionofPage) > 0 ? 1 : 0);
		model.addAttribute("totalPage",totalPage);
		model.addAttribute("Promotions",Promotions);
		model.addAttribute("ipage",ipage);
		return "viewpromotion";
	}
	@RequestMapping(value={"/admin/editpromotion"},method = RequestMethod.GET)
	public String EditPromotion(ModelMap model,	HttpServletRequest request,
			@RequestParam(value = "id",required=false) String id)
	{
		int idPromotion = Integer.parseInt(id);
		PromotionServiceImpl promotionService = (PromotionServiceImpl)BeanFactory.getBean("promotionService");
		Promotion promotion = promotionService.get(idPromotion);
		model.addAttribute("promotion", promotion);
		return "editpromotion";
	}
	@RequestMapping(value={"/admin/promotions"},method = RequestMethod.GET)
	public String SaveEditPromotion(ModelMap model,	HttpServletRequest request,
			@RequestParam(value = "namepromotion", required = false) String promtionname,
			@RequestParam(value = "datestart", required = false) String datestart,
			@RequestParam(value = "dateend", required = false) String dateend,
			@RequestParam(value = "valuesaleoff", required = false) String valuesaleoff,
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "page",required=false) String page) throws ParseException
	{
		
		
		PromotionServiceImpl promotionService = (PromotionServiceImpl)BeanFactory.getBean("promotionService");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date mdatestart = sdf.parse(datestart);
		Date mdateend = sdf.parse(dateend);
		int mvalueslaeoff = Integer.parseInt(valuesaleoff);
		Promotion promotion;
		if(id != "")
		{
			int idPromotion = Integer.parseInt(id);
			promotion = promotionService.get(idPromotion);
			promotion.setDateEnd(mdateend);
			promotion.setDateStart(mdatestart);
			promotion.setValueSaleOff(mvalueslaeoff);
			promotion.setPromotionName(promtionname);
		}
		else{
			promotion = new Promotion(promtionname,mdatestart, mdateend,  mvalueslaeoff,false);
		}
		
		promotionService.update(promotion);
		
		String ipage = "";
		if(page ==null)
			page="1";
		ipage = page;
		int intpage = Integer.parseInt(page);
		List<Promotion> Promotions = promotionService.getPromotions(intpage);
		int PromotionCount = promotionService.CountPromotion();
		int totalPage = (PromotionCount/numberPromotionofPage) + ((PromotionCount/numberPromotionofPage) > 0 ? 1 : 0);
		model.addAttribute("totalPage",totalPage);
		model.addAttribute("Promotions",Promotions);
		model.addAttribute("ipage",ipage);
		return "viewpromotion";
	}
	@RequestMapping(value={"/admin/deletepromotion"},method = RequestMethod.GET)
	public String DeletePromotion(ModelMap model,	HttpServletRequest request,
			@RequestParam(value = "id",required=false) String id,
			@RequestParam(value = "page",required=false) String page)
	{
		int idPromotion = Integer.parseInt(id);
		PromotionServiceImpl promotionService = (PromotionServiceImpl)BeanFactory.getBean("promotionService");
		//Promotion promotion = promotionService.get(idPromotion);
		 promotionService.Delete(idPromotion);
		String ipage = "";
		if(page ==null)
			page="1";
		ipage = page;
			
		int intpage = Integer.parseInt(page);
		List<Promotion> Promotions = promotionService.getPromotions(intpage);
		int PromotionCount = promotionService.CountPromotion();
		int totalPage = (PromotionCount/numberPromotionofPage) + ((PromotionCount/numberPromotionofPage) > 0 ? 1 : 0);
		model.addAttribute("totalPage",totalPage);
		model.addAttribute("Promotions",Promotions);
		model.addAttribute("ipage",ipage);
		return "viewpromotion";
	}
	@RequestMapping(value={"/admin/addpromotion"},method = RequestMethod.GET)
	public String AddPromotion(ModelMap model)
	{
		return "addpromotion";
	}
}
