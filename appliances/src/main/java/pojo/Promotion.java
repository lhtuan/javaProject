package pojo;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "promotion", catalog = "appliances")
public class Promotion implements  java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Date dateStart;
	private Date dateEnd;
	private String promotionName;
	private int valueSaleOff;
	public Promotion()
	{
	
	}
	public Promotion(Date datestart , Date dateend, String promotionmae, int valuesaleoff){
		this.dateEnd = dateend;
		this.dateStart = datestart;
		this.promotionName = promotionmae;
		this.valueSaleOff = valuesaleoff;
	}
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "Id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "PromotionName", length = 100)
	public String getPromotionName() {
		return this.promotionName;
	}

	public void setPromotionName(String promotionname) {
		this.promotionName = promotionname;
	}
	@Column(name = "DateStart")
	public Date getDateStart() {
		return this.dateStart;
	}

	public void setDateStart(Date datestart) {
		this.dateStart = datestart;
	}
	@Column(name = "DateEnd")
	public Date getDateEnd() {
		return this.dateEnd;
	}

	public void setDateEnd(Date dateend) {
		this.dateEnd= dateend;
	}
	@Column(name = "ValueSaleOff")
	public int getValueSaleOff() {
		return this.valueSaleOff;
	}

	public void setValueSaleOff(int valueSaleOff) {
		this.valueSaleOff= valueSaleOff;
	}
}
