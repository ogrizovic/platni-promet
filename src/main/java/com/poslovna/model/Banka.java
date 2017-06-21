package com.poslovna.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Banka {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = true)
	private int id;
	
	@Column(nullable = false)
	@Size(max = 50)
	@Pattern(regexp = "[A-Z][a-z][0-9]*")
	private String naziv;
	
	@Column(nullable = false)
	@Size(max = 3)
	@Pattern(regexp = "[0-9]{3}")
	private String sifraBanke;
	
	@Column(nullable=false, unique=true, length = 8)
	@Pattern(regexp="[0-9]{8}")
	@NotEmpty
	private String swift;
	
	@Column(nullable=false)
	@Size(max = 18)
	@NotEmpty
	private String obracunskiRacun;
	
	public Banka() {
		// TODO Auto-generated constructor stub
	}

	public Banka(String naziv, String sifraBanke, String swift, String obracunskiRacun) {
		super();
		this.naziv = naziv;
		this.sifraBanke = sifraBanke;
		this.swift = swift;
		this.obracunskiRacun = obracunskiRacun;
	}
	
	

	public Banka(int id, String naziv, String sifraBanke, String swift, String obracunskiRacun) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.sifraBanke = sifraBanke;
		this.swift = swift;
		this.obracunskiRacun = obracunskiRacun;
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

	public String getSifraBanke() {
		return sifraBanke;
	}

	public void setSifraBanke(String sifraBanke) {
		this.sifraBanke = sifraBanke;
	}

	public String getSwift() {
		return swift;
	}

	public void setSwift(String swift) {
		this.swift = swift;
	}

	public String getObracunskiRacun() {
		return obracunskiRacun;
	}

	public void setObracunskiRacun(String obracunskiRacun) {
		this.obracunskiRacun = obracunskiRacun;
	}
	
	
}
