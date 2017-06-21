package com.poslovna.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class KursUValuti {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(unique = false, nullable = false)
	@Size(max=10)
	@NotEmpty
	@Pattern(regexp = "[0-9]*.[0-9]?[0-9]{4}")
	private double kupovni;
	
	@Column(unique = false, nullable = false)
	@Size(max=10)
	@NotEmpty
	@Pattern(regexp = "[0-9]*.[0-9]?[0-9]{4}")
	private double prodajni;
	
	@Column(unique = false, nullable = false)
	@Size(max=10)
	@NotEmpty
	@Pattern(regexp = "[0-9]*.[0-9]?[0-9]{4}")
	private double srednji;
	
	
	@ManyToOne
	@JoinColumn(name = "osnovnaValuta")
	private Valuta osnovnaValuta;
	
	@ManyToOne
	@JoinColumn(name = "premaValuti")
	private Valuta premaValuti;
	
	@ManyToOne
	@JoinColumn(name = "kursnaLista")
	private KursnaLista kursnaLista;
	
	public KursUValuti() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getKupovni() {
		return kupovni;
	}

	public void setKupovni(double kupovni) {
		this.kupovni = kupovni;
	}

	public double getProdajni() {
		return prodajni;
	}

	public void setProdajni(double prodajni) {
		this.prodajni = prodajni;
	}

	public double getSrednji() {
		return srednji;
	}

	public void setSrednji(double srednji) {
		this.srednji = srednji;
	}

	public Valuta getOsnovnaValuta() {
		return osnovnaValuta;
	}

	public void setOsnovnaValuta(Valuta osnovnaValuta) {
		this.osnovnaValuta = osnovnaValuta;
	}

	public Valuta getPremaValuti() {
		return premaValuti;
	}

	public void setPremaValuti(Valuta premaValuti) {
		this.premaValuti = premaValuti;
	}

	public KursnaLista getKursnaLista() {
		return kursnaLista;
	}

	public void setKursnaLista(KursnaLista kursnaLista) {
		this.kursnaLista = kursnaLista;
	}
	
	
}
