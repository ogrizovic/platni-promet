package com.poslovna.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class NaseljenoMesto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = true)
	private int id;
	
	@Column(nullable = false)
	@Size(max = 50)
	@Pattern(regexp = "[A-Z][a-z]*")
	private String name;
	
	@Column(nullable = false)
	@Size(max = 5)
	@Pattern(regexp = "[0-9]{5}")
	private String ptt;
	
	
	private int maticnaDrzava;
	
	public NaseljenoMesto() {
		// TODO Auto-generated constructor stub
	}

	public NaseljenoMesto(String name, String ptt, int maticnaDrzava) {
		super();
		this.name = name;
		this.ptt = ptt;
		this.maticnaDrzava = maticnaDrzava;
	}
	
	public NaseljenoMesto(NaseljenoMesto nm){
		this.name = nm.getName();
		this.ptt = nm.getPtt();
		this.maticnaDrzava = nm.getMaticnaDrzava();
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

	public String getPtt() {
		return ptt;
	}

	public void setPtt(String ptt) {
		this.ptt = ptt;
	}

	public int getMaticnaDrzava() {
		return maticnaDrzava;
	}

	public void setMaticnaDrzava(int maticnaDrzava) {
		this.maticnaDrzava = maticnaDrzava;
	}
	
	
}
