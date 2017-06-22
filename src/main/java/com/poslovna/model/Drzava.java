package com.poslovna.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Drzava {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(nullable = false)
	@Size(max = 50)
	@Pattern(regexp = "[A-Z][a-z]*")
	private String naziv;
	
	public Drzava() {
		// TODO Auto-generated constructor stub
	}


	public Drzava(String name) {
		super();
		this.naziv = name;
	}


	@Override
	public String toString() {
		return id + naziv;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	
}
