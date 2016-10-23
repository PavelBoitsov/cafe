package cafe.model.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.*;

@Table(name = "Clients")
@Entity
public class Client {
	@Id
	private int id;
	private String name;
	private LocalDate birthDay;
	private int disount;
	private String info;
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	private Set<CafeOrder> orders;

	public Client() {
		super();
	}

	public Client(int id, String name, LocalDate birthDay, int disount, String info) {
		super();
		this.id = id;
		this.name = name;
		this.birthDay = birthDay;
		this.disount = disount;
		this.info = info;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}

	public int getDisount() {
		return disount;
	}

	public void setDisount(int disount) {
		this.disount = disount;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Set<CafeOrder> getOrders() {
		return orders;
	}

	public void setOrders(Set<CafeOrder> orders) {
		this.orders = orders;
	}

}
