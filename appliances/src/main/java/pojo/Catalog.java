package pojo;

// Generated Dec 6, 2013 8:18:51 PM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Catalog generated by hbm2java
 */
@Entity
@Table(name = "catalog", catalog = "appliances")
public class Catalog implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String catalogName;
	private Set<Product> products = new HashSet<Product>(0);

	public Catalog() {
	}

	public Catalog(String catalogName, Set<Product> products) {
		this.catalogName = catalogName;
		this.products = products;
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

	@Column(name = "CatalogName", length = 100)
	public String getCatalogName() {
		return this.catalogName;
	}

	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catalog")
	public Set<Product> getProducts() {
		return this.products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

}
