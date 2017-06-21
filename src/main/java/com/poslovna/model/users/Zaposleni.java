package com.poslovna.model.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import com.poslovna.model.Banka;

@Entity
@Table(name="zaposleni")
public class Zaposleni extends Subjekat {
	
	@Column(nullable=false)
	private String ime;
	
	@Column(nullable=false)
	private String prezime;
	
	@Column(nullable = false, length = 13)
	@Pattern(regexp = "[0-9]{13}", message = "JMBG mora imati 13 cifara.")
	private String jmbg;
	
	@ManyToOne
	private Banka bank;
	
	public Zaposleni() {
		// TODO Auto-generated constructor stub
	}
	
	public Zaposleni(String ime, String prezime, String jmbg) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}
	
	
}
