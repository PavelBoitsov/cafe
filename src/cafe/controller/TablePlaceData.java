package cafe.controller;

public class TablePlaceData {
	int id;
	int top;
	int left;
	int width;
	int height;

	public TablePlaceData(int id, int top, int left, int width, int height) {
		super();
		this.id = id;
		this.top = top;
		this.left = left;
		this.width = width;
		this.height = height;
	}

	public TablePlaceData(int id) {
		super();
		this.id = id;
	}

	public TablePlaceData() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

	public int getLeft() {
		return left;
	}

	public void setLeft(int left) {
		this.left = left;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
