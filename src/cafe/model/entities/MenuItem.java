package cafe.model.entities;

import java.util.Set;

import javax.persistence.*;

@Entity
public class MenuItem {
	@Id
	private String menuItem;
	private Double price;
	@ManyToOne
	private MenuGroup menuGroup;
	@OneToMany(mappedBy = "menuItem", cascade = CascadeType.ALL)
	private Set<ItemQuantity> itemQuntity;
	@OneToMany(mappedBy = "menuItem", cascade = CascadeType.ALL)
	private Set<Calculation> calculations;

	public MenuItem() {
		super();
	}

	public MenuItem(String item, Double price, MenuGroup menuGroup) {
		super();
		this.menuItem = item;
		this.price = price;
		this.menuGroup = menuGroup;
	}

	public String getItem() {
		return menuItem;
	}

	public void setItem(String item) {
		this.menuItem = item;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public MenuGroup getMenuGroup() {
		return menuGroup;
	}

	public void setMenuGroup(MenuGroup menuGroup) {
		this.menuGroup = menuGroup;
	}

	public Set<ItemQuantity> getItemQuntity() {
		return itemQuntity;
	}

	public void setItemQuntity(Set<ItemQuantity> itemQuntity) {
		this.itemQuntity = itemQuntity;
	}

	public Set<Calculation> getCalculations() {
		return calculations;
	}

	public void setCalculations(Set<Calculation> calculations) {
		this.calculations = calculations;
	}

}
