package cafe.controller;

import java.time.LocalDate;

public class InvoiceData {
	SupplierData supplier;
	ProductData product;
	double price;
	int amount;
	LocalDate date;

	public InvoiceData(SupplierData supplier, ProductData product, double price, int amount, LocalDate date) {
		super();
		this.supplier = supplier;
		this.product = product;
		this.price = price;
		this.amount = amount;
		this.date = date;
	}

	public SupplierData getSupplier() {
		return supplier;
	}

	public void setSupplier(SupplierData supplier) {
		this.supplier = supplier;
	}

	public ProductData getProduct() {
		return product;
	}

	public void setProduct(ProductData product) {
		this.product = product;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public InvoiceData() {
		super();
	}

}
