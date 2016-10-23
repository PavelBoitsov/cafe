package cafe.model.entities;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "Products")
public class Product {
	@Id
	private String productName;
	private int balance;
	private String unitName;
	private double avgPrice;
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private Set<Invoice> invoices;

	public Product(String productName, String unitName) {
		super();
		this.productName = productName;
		this.unitName = unitName;

	}

	public Product() {
		super();
	}

	public Set<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(Set<Invoice> invoices) {
		this.invoices = invoices;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public double getAvgPrice() {
		return avgPrice;
	}

	public void setAvgPrice(double avgPrice) {
		this.avgPrice = avgPrice;
	}

}
