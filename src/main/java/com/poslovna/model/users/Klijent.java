package com.poslovna.model.users;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateDeserializer;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import com.poslovna.model.NaseljenoMesto;
import com.poslovna.model.Racun;
import com.poslovna.model.users.access.User;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Klijent{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = true)
	private int id;
	
	@Column(nullable = false)
	@Size(max = 50)
	@Pattern(regexp = "[A-Z][a-z]*")
	private String ime;
	
	@Column(nullable = false)
	@Size(max = 50)
	@Pattern(regexp = "[A-Z][a-z]*")
	private String prezime;
	
	@Column(nullable = false)
	@Size(max = 256)
	@Pattern(regexp = "[A-Z][a-z]*")
	private String adresa;
	
	@Column(unique = true, nullable = false)
	@Size(max = 254)
	@Pattern(regexp = "([\\w\\.\\-_]+)?\\w+@[\\w-_]+(\\.\\w+){1,}")
	private String email;
	
	@Column(nullable = false)
	@Size(max = 20)
	@Pattern(regexp = "[\\d\\+]{6,20}")
	private String telefon;
	
	@Column(nullable = false)
	@Size(max = 5)
	@Pattern(regexp = "[0-9]{5}")
	private String ptt;
	
	@Column(nullable = false, length = 13)
	@Pattern(regexp = "[0-9]{13}", message = "JMBG mora imati 13 cifara.")
	private String jmbg;
	
	@Column(name = "datumRodjenja", columnDefinition = "DATE")
	@Temporal(TemporalType.DATE)
	@JsonSerialize(using = DateSerializer.class)
	@JsonDeserialize(using = DateDeserializer.class)
	private Date datumRodjenja;
	
	
	@ManyToOne
	private NaseljenoMesto mesto;
	
	@OneToMany(mappedBy="klijent")
	private Collection<Racun> racuni;
	
	@OneToOne
	@JoinColumn(name="id_usera")
	private User user;
	
	public Klijent() {
		this.racuni = new ArrayList<>();
	}

	public Klijent(String ime, String prezime, String adresa, NaseljenoMesto mesto, String email, String telefon, String ptt,
			String jmbg, Date datumRodjenja) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.adresa = adresa;
		this.mesto = mesto;
		this.email = email;
		this.telefon = telefon;
		this.ptt = ptt;
		this.jmbg = jmbg;
		this.datumRodjenja = datumRodjenja;
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

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public NaseljenoMesto getMesto() {
		return mesto;
	}

	public void setMesto(NaseljenoMesto mesto) {
		this.mesto = mesto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getPtt() {
		return ptt;
	}

	public void setPtt(String ptt) {
		this.ptt = ptt;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public Date getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public Collection<Racun> getRacuni() {
		return racuni;
	}

	public void setRacuni(Collection<Racun> racuni) {
		this.racuni = racuni;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
}
