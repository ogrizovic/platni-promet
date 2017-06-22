package com.poslovna.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class SifrarnikDelatnosti {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(unique = false, nullable = false)
	@Size(max=5)
	@NotEmpty
	@Pattern(regexp = "[\\d]{5}")
	private int sifraDelatnosti;
	
	@Column(nullable = false)
	@Size(max = 60)
	@Pattern(regexp = "[A-Z][a-z]*")
	private String nazivDelatnosti;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "banka_id")
	private Banka banka;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSifraDelatnosti() {
		return sifraDelatnosti;
	}

	public void setSifraDelatnosti(int sifraDelatnosti) {
		this.sifraDelatnosti = sifraDelatnosti;
	}

	public String getNazivDelatnosti() {
		return nazivDelatnosti;
	}

	public void setNazivDelatnosti(String nazivDelatnosti) {
		this.nazivDelatnosti = nazivDelatnosti;
	}

	public Banka getBanka() {
		return banka;
	}

	public void setBanka(Banka banka) {
		this.banka = banka;
	}
}
