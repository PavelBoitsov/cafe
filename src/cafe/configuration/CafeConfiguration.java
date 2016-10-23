package cafe.configuration;

public class CafeConfiguration {
	int nTables;
	String[] orderStatus;
	String[] roles;

	public CafeConfiguration(int nTables, String[] orderStatus, String[] roles) {
		super();
		this.nTables = nTables;
		this.orderStatus = orderStatus;
		this.roles = roles;
	}

	public int getnTables() {
		return nTables;
	}

	public void setnTables(int nTables) {
		this.nTables = nTables;
	}

	public String[] getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String[] orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String[] getRoles() {
		return roles;
	}

	public void setRoles(String[] roles) {
		this.roles = roles;
	}

	public CafeConfiguration() {
		super();
	}

}
