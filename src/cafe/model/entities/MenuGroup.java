package cafe.model.entities;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "MenuGroups")
public class MenuGroup {

	@Id
	private int id;
	private String groupName;
	private String subGroupName;
	@OneToMany(mappedBy = "menuGroup", cascade = CascadeType.ALL)
	private Set<MenuItem> menuItems;

	public MenuGroup() {
		super();
	}

	public MenuGroup(int id, String groupName, String subGroupName) {
		super();
		this.id = id;
		this.groupName = groupName;
		this.subGroupName = subGroupName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

}
