package com.poslovna.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.poslovna.model.users.Klijent;

@Entity
@Table(name="racun")
public class Racun {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = true)
	private int id;
	
	@Column(nullable = false)
	@Size(max = 18)
	@Pattern(regexp = "[0-9]{18}")
	private String brojRacuna;
	
	@Column(nullable = false)
	private boolean status;
	
	

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="klijent_id")
	private Klijent klijent;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="banka_id")
	private Banka banka;
	
	@OneToMany(mappedBy = "racun")
	private Collection<DnevnoStanjeRacuna> dnevnoStanje;
	
	@OneToMany(mappedBy = "racun")
	private Collection<ZatvaranjeRacuna> zatvaranjaRacuna;
	
	@ManyToOne
	private Valuta valuta;
	
	public Racun() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrojRacuna() {
		return brojRacuna;
	}

	public void setBrojRacuna(String brojRacuna) {
		this.brojRacuna = brojRacuna;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Klijent getKlijent() {
		return klijent;
	}

	public void setKlijent(Klijent klijent) {
		this.klijent = klijent;
	}

	public Banka getBanka() {
		return banka;
	}

	public void setBanka(Banka banka) {
		this.banka = banka;
	}

	public Collection<DnevnoStanjeRacuna> getDnevnoStanje() {
		return dnevnoStanje;
	}

	public void setDnevnoStanje(Collection<DnevnoStanjeRacuna> dnevnoStanje) {
		this.dnevnoStanje = dnevnoStanje;
	}

	public Collection<ZatvaranjeRacuna> getZatvaranjaRacuna() {
		return zatvaranjaRacuna;
	}

	public void setZatvaranjaRacuna(Collection<ZatvaranjeRacuna> zatvaranjaRacuna) {
		this.zatvaranjaRacuna = zatvaranjaRacuna;
	}

	public Valuta getValuta() {
		return valuta;
	}

	public void setValuta(Valuta valuta) {
		this.valuta = valuta;
	}
	
	
	
}
