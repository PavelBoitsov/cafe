package cafe.model.entities;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "Invoices")
public class Invoice {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "InvoiceId")
	private long id;
	@ManyToOne
	private Product product;
	@ManyToOne
	private Supplier supplier;
	private LocalDate date;
	private double price;
	private int amount;

	public Invoice() {
		super();
	}

	public Invoice(Product product, Supplier supplier, LocalDate date, double price, int amount) {
		super();
		this.product = product;
		this.supplier = supplier;
		this.date = date;
		this.price = price;
		this.amount = amount;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
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

}
