package cafe.controller;


public class ProductData {
	String productName;
	String unitName;
	double avgPrice;
	

	public ProductData(String productName, String unitName) {
		super();
		this.productName = productName;
		this.unitName = unitName;
	}

	public double getAvgPrice() {
		return avgPrice;
	}

	public void setAvgPrice(double avgPrice) {
		this.avgPrice = avgPrice;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

}
