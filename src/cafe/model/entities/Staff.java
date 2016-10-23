package cafe.model.entities;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Staff {
	@Id
	private int id;
	@ManyToOne
	private Role role;
	private String name;
	private String password;
	@OneToMany(mappedBy = "staff", cascade = CascadeType.ALL)
	private Set<CafeOrder> orders;

	public Staff() {
		super();
	}

	public Staff(int id, Role role, String name, String password) {
		super();
		this.id = id;
		this.role = role;
		this.name = name;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
