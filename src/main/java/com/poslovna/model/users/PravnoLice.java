package com.poslovna.model.users;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.poslovna.model.NaseljenoMesto;
import com.poslovna.model.users.access.Role;

@Entity
public class PravnoLice extends Klijent {

	@Column(nullable = false)
	@Size(max = 50)
	@Pattern(regexp = "[A-Z][a-z]*")
	private String naziv;
	
	@Column(nullable = false)
	@Size(max = 50)
	@Pattern(regexp = "[A-Z][a-z][0-9]*")
	private String delatnost;
	
	@Column(nullable = false, length = 9)
	@Pattern(regexp = "[0-9]{9}", message = "PIB mora imati 9 cifara.")
	private String pib;
	
	@Column(nullable = false, length = 8)
	@Pattern(regexp = "[0-9]{8}", message = "MBP mora imati 8 cifara.")
	private String matnicniBrPreduzeca;
	
	public PravnoLice() {
		// TODO Auto-generated constructor stub
	}

	public PravnoLice(String ime, String prezime, String adresa, NaseljenoMesto mesto, String email, String telefon, String ptt,
			String jmbg, String datumRodjenja, Role role, String naziv, String delatnost, String pib, String matnicniBrPreduzeca) {
		super(ime, prezime, adresa, mesto, email, telefon, ptt, jmbg, datumRodjenja);
		this.naziv = naziv;
		this.delatnost = delatnost;
		this.pib = pib;
		this.matnicniBrPreduzeca = matnicniBrPreduzeca;
	}

	public PravnoLice(String ime, String prezime, String adresa, NaseljenoMesto mesto, String email, String telefon, String ptt,
			String jmbg, String datumRodjenja, Role role) {
		super(ime, prezime, adresa, mesto, email, telefon, ptt, jmbg, datumRodjenja);
		// TODO Auto-generated constructor stub
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getDelatnost() {
		return delatnost;
	}

	public void setDelatnost(String delatnost) {
		this.delatnost = delatnost;
	}

	public String getPib() {
		return pib;
	}

	public void setPib(String pib) {
		this.pib = pib;
	}

	public String getMatnicniBrPreduzeca() {
		return matnicniBrPreduzeca;
	}

	public void setMatnicniBrPreduzeca(String matnicniBrPreduzeca) {
		this.matnicniBrPreduzeca = matnicniBrPreduzeca;
	}
	
}
