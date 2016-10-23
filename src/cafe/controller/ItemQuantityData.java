package cafe.controller;

public class ItemQuantityData {
	CafeOrderData order;
	MenuItemData item;
	int quantity;
	long orderId;

	public ItemQuantityData(MenuItemData item, int quantity, CafeOrderData order) {
		super();
		this.item = item;
		this.quantity = quantity;
		this.order = order;
	}

	public ItemQuantityData(MenuItemData item, int quantity, long orderId) {
		super();
		this.item = item;
		this.quantity = quantity;
		this.orderId = orderId;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public CafeOrderData getOrder() {
		return order;
	}

	public void setOrder(CafeOrderData order) {
		this.order = order;
	}

	public MenuItemData getItem() {
		return item;
	}

	public void setItem(MenuItemData item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
