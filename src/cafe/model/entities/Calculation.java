package cafe.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Calculation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "calculationId")
	private long id;
	@ManyToOne
	private Product product;
	@ManyToOne
	private MenuItem menuItem;
	private int count;

	public Calculation(Product product, MenuItem item, int count) {
		super();
		this.product = product;
		this.menuItem = item;
		this.count = count;
	}

	public Calculation() {
		super();
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

	public MenuItem getItem() {
		return menuItem;
	}

	public void setItem(MenuItem item) {
		this.menuItem = item;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
