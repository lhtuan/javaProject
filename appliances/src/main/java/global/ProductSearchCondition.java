package global;


public class ProductSearchCondition {
	private String name;
	private String minPrice;
	private String maxPrice;
	private String page;
	private String productPerPage;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(String minPrice) {
		this.minPrice = minPrice;
	}
	public String getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(String maxPrice) {
		this.maxPrice = maxPrice;
	}
	public ProductSearchCondition(String _name,String _minPrice,String _maxPrice,String _page,String _productPerPage)
	{
		name = _name;
		minPrice = _minPrice;
		maxPrice = _maxPrice;
		page = _page;
		productPerPage =_productPerPage;
	}
	public String getConditionString()
	{
		String condition = " where 1=1 ";
		if(name != null)
			condition = condition + " and ProductName like ?";
		if(minPrice != null)
			condition = condition + " and Price >= "+minPrice;
		if(maxPrice != null)
			condition = condition + " and Price <= "+maxPrice;
		return condition;
	}
	public String getNumberProductOfPage() {
		return productPerPage;
	}
	public void setNumberProductOfPage(String numberProductOfPage) {
		this.productPerPage = numberProductOfPage;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
}
