package cafe.model.entities;

import java.util.*;

import javax.persistence.*;

@Entity
public class TablePlace {
	@Id
	private int id;
	private int topPosition;
	private int leftPosition;
	private int widthPosition;
	private int heightPosition;
	@OneToMany(mappedBy = "tablePlace", cascade = CascadeType.ALL)
	private Set<CafeOrder> orders;

	public TablePlace() {
		super();
	}

	public TablePlace(int id, int topPosition, int leftPosition, int widthPosition, int heightPosition) {
		super();
		this.id = id;
		this.topPosition = topPosition;
		this.leftPosition = leftPosition;
		this.widthPosition = widthPosition;
		this.heightPosition = heightPosition;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTopPosition() {
		return topPosition;
	}

	public void setTopPosition(int topPosition) {
		this.topPosition = topPosition;
	}

	public int getLeftPosition() {
		return leftPosition;
	}

	public void setLeftPosition(int leftPosition) {
		this.leftPosition = leftPosition;
	}

	public int getWidthPosition() {
		return widthPosition;
	}

	public void setWidthPosition(int widthPosition) {
		this.widthPosition = widthPosition;
	}

	public int getHeightPosition() {
		return heightPosition;
	}

	public void setHeightPosition(int heightPosition) {
		this.heightPosition = heightPosition;
	}

	public Set<CafeOrder> getOrders() {
		return orders;
	}

	public void setOrders(Set<CafeOrder> orders) {
		this.orders = orders;
	}

}
