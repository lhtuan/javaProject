package pojo;

// Generated Dec 20, 2013 9:23:39 AM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Product generated by hbm2java
 */
@Entity
@Table(name = "product", catalog = "appliances")
public class Product implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Catalog catalog;
	private String productName;
	private String description;
	private String productInfo;
	private String price;
	private Double rate;
	private Integer rateCount;
	private Boolean deleted;
	private Set<Shoppingcartdetail> shoppingcartdetails = new HashSet<Shoppingcartdetail>(0);

	public Product() {
	}

	public Product(Catalog catalog, String productName) {
		this.catalog = catalog;
		this.productName = productName;
	}

	public Product(Catalog catalog, String productName, String description,
			String productInfo, String price, Double rate, Integer rateCount,
			Boolean deleted, Set<Shoppingcartdetail> shoppingcartdetails) {
		this.catalog = catalog;
		this.productName = productName;
		this.description = description;
		this.productInfo = productInfo;
		this.price = price;
		this.rate = rate;
		this.rateCount = rateCount;
		this.deleted = deleted;
		this.shoppingcartdetails = shoppingcartdetails;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Catalog", nullable = false)
	public Catalog getCatalog() {
		return this.catalog;
	}

	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}

	@Column(name = "ProductName", nullable = false, length = 100)
	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Column(name = "Description", length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "ProductInfo", length = 65535)
	public String getProductInfo() {
		return this.productInfo;
	}

	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}

	@Column(name = "Price", length = 20)
	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Column(name = "Rate", precision = 22, scale = 0)
	public Double getRate() {
		return this.rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	@Column(name = "RateCount")
	public Integer getRateCount() {
		return this.rateCount;
	}

	public void setRateCount(Integer rateCount) {
		this.rateCount = rateCount;
	}

	@Column(name = "Deleted")
	public Boolean getDeleted() {
		return this.deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	public Set<Shoppingcartdetail> getShoppingcartdetails() {
		return this.shoppingcartdetails;
	}

	public void setShoppingcartdetails(Set<Shoppingcartdetail> shoppingcartdetails) {
		this.shoppingcartdetails = shoppingcartdetails;
	}

}
