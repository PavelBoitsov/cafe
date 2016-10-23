package cafe.controller;

import java.time.LocalDate;

public class ClientData {
	int id;
	String name;
	LocalDate birthDay;
	int disount;
	String info;

	public ClientData(int id, String name, LocalDate birthDay, int disount, String info) {
		super();
		this.id = id;
		this.name = name;
		this.birthDay = birthDay;
		this.disount = disount;
		this.info = info;
	}

	public ClientData(int id, String name, LocalDate birthDay, int disount) {
		super();
		this.id = id;
		this.name = name;
		this.birthDay = birthDay;
		this.disount = disount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}

	public int getDisount() {
		return disount;
	}

	public void setDisount(int disount) {
		this.disount = disount;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

}
