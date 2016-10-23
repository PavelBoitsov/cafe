package cafe.model.entities;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Suppliers")
public class Supplier {
	@Id
	private int id;
	private String info;
	@OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL)
	private Set<Invoice> invoices;

	public Supplier() {
		super();
	}

	public Supplier(int id, String info) {
		super();
		this.id = id;
		this.info = info;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

}
