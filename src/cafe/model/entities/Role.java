package cafe.model.entities;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Roles")
public class Role {
	@Id
	private String role;
	@OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
	private Set<Staff> staff;

	public Role() {
		super();
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<Staff> getStaff() {
		return staff;
	}

	public void setStaff(Set<Staff> staff) {
		this.staff = staff;
	}

	public Role(String role) {
		super();
		this.role = role;
	}

}
