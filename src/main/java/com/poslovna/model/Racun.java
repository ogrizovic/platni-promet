package com.poslovna.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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

import org.hibernate.annotations.IndexColumn;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.poslovna.model.users.Klijent;

@Entity
@Table(name="racun")
public class Racun {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = true)
	private int id;
	
	@Column(nullable = false, unique = true)
	@Size(max = 18)
	@Pattern(regexp = "[0-9]{18}")
	private String brojRacuna;
	
	@Pattern(regexp = "[ABZabz]{1}")
	@Column(nullable = false)
	private String status;
	
	

	@ManyToOne(fetch=FetchType.LAZY)
	@JsonBackReference
	@JoinColumn(name="klijent_id")
	private Klijent klijent;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonBackReference
	@JoinColumn(name="banka_id")
	private Banka banka;
	
	@OneToMany(mappedBy = "racun", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	//@JsonManagedReference
	private Set<DnevnoStanjeRacuna> dnevnoStanje = new HashSet<DnevnoStanjeRacuna>();
	
	@OneToMany(mappedBy = "racun", cascade = {CascadeType.ALL})
	@JsonManagedReference
	private Collection<ZatvaranjeRacuna> zatvaranjaRacuna;
	
	@ManyToOne
	@JsonBackReference
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

	public String isStatus() {
		return status;
	}

	public void setStatus(String status) {
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
		this.dnevnoStanje = (Set<DnevnoStanjeRacuna>) dnevnoStanje;
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
