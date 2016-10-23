package cafe.controller;

public class CafeOrderData {
	int staffId;
	int tableId;

	public CafeOrderData() {
		super();
	}

	public CafeOrderData(int staffId, int tableId) {
		super();
		this.staffId = staffId;
		this.tableId = tableId;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public int getTableId() {
		return tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

}
