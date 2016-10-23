package cafe.model.entities;

import java.util.*;

import javax.persistence.*;

@Entity
public class OrderStatus {
	@Id
	private String status;
	@OneToMany(mappedBy = "orderStatus", cascade = CascadeType.ALL)
	private Set<CafeOrder> orders;

	public OrderStatus(String status) {
		super();
		this.status = status;
	}

	public OrderStatus() {
		super();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<CafeOrder> getOrders() {
		return orders;
	}

	public void setOrders(Set<CafeOrder> orders) {
		this.orders = orders;
	}

}
