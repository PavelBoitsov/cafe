package cafe.controller;

public class MenuItemData {
	String menuItem;
	double price;
	MenuGroupData menuGroup;

	public MenuItemData(String menuItem, double price, MenuGroupData menuGroup) {
		super();
		this.menuItem = menuItem;
		this.price = price;
		this.menuGroup = menuGroup;
	}

	public String getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(String item) {
		this.menuItem = item;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public MenuGroupData getMenuGroup() {
		return menuGroup;
	}

	public void setMenuGroup(MenuGroupData menuGroup) {
		this.menuGroup = menuGroup;
	}

}
