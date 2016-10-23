package cafe.model.entities;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.*;

@Entity
public class CafeOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OrderId")
	private long id;

	@ManyToOne
	private Staff staff;
	@ManyToOne
	private OrderStatus orderStatus;
	@ManyToOne
	private TablePlace tablePlace;
	@ManyToOne
	private Client client;
	@OneToMany(mappedBy = "order", cascade=CascadeType.ALL)
	private Set<ItemQuantity> itemsQuantity;

	LocalDateTime dateTime;
	int nGuests;
	double orderCheck;

	public CafeOrder() {
		super();
	}

	public CafeOrder(Staff staff, OrderStatus orderStatus, TablePlace tablePlace, Client client, LocalDateTime dateTime,
			int nGuests, double orderCheck) {
		super();
		this.staff = staff;
		this.orderStatus = orderStatus;
		this.tablePlace = tablePlace;
		this.client = client;
		this.dateTime = dateTime;
		this.nGuests = nGuests;
		this.orderCheck = orderCheck;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public TablePlace getTablePlace() {
		return tablePlace;
	}

	public void setTablePlace(TablePlace tablePlace) {
		this.tablePlace = tablePlace;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Set<ItemQuantity> getItemsQuantity() {
		return itemsQuantity;
	}

	public void setItemsQuantity(Set<ItemQuantity> itemsQuantity) {
		this.itemsQuantity = itemsQuantity;
	}

	public int getnGuests() {
		return nGuests;
	}

	public void setnGuests(int nGuests) {
		this.nGuests = nGuests;
	}

	public double getOrderCheck() {
		return orderCheck;
	}

	public void setOrderCheck(double orderCheck) {
		this.orderCheck = orderCheck;
	}

}
