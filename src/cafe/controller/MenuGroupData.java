package cafe.controller;

public class MenuGroupData {
	int id;
	String groupName;
	String subGroupName;

	public MenuGroupData(int id, String groupName, String subGroupName) {
		super();
		this.id = id;
		this.groupName = groupName;
		this.subGroupName = subGroupName;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getSubGroupName() {
		return subGroupName;
	}

	public void setSubGroupName(String subGroupName) {
		this.subGroupName = subGroupName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
