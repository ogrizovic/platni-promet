package com.poslovna.model;

public class Drzava {

	private int id;
	private String name;
	
	public Drzava() {
		// TODO Auto-generated constructor stub
	}


	public Drzava(String name) {
		super();
		this.name = name;
	}


	@Override
	public String toString() {
		return id + name;
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
	
	
}
