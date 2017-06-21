package com.poslovna.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateDeserializer;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

@Entity
public class MedjubankarskiPrenos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(nullable = false)
	@Size(max = 5)
	@NotEmpty
	@Pattern(regexp = "[A-Za-z0-9]{5}")
	private String vrsta;
	
	@Column(name = "datumprenosa", columnDefinition = "DATE")
	@Temporal(TemporalType.DATE)
	@JsonSerialize(using = DateSerializer.class)
	@JsonDeserialize(using = DateDeserializer.class)
	private Date datum;
	
	@Column(unique = false, nullable = false)
	@Size(max=15)
	@NotEmpty
	@Pattern(regexp = "^[0-9]+([\\,\\.][0-9]{1,})?$")
	private double ukupno;
	
	@ManyToOne
	private Banka bankaPosiljalac;
	
	@ManyToOne
	private Banka bankaPrimalac;
	
	
	
	public MedjubankarskiPrenos() {
		// TODO Auto-generated constructor stub
	}

	public MedjubankarskiPrenos(String vrsta, Date datum, double ukupno) {
		super();
		this.vrsta = vrsta;
		this.datum = datum;
		this.ukupno = ukupno;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVrsta() {
		return vrsta;
	}

	public void setVrsta(String vrsta) {
		this.vrsta = vrsta;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public double getUkupno() {
		return ukupno;
	}

	public void setUkupno(double ukupno) {
		this.ukupno = ukupno;
	}

	public Banka getBankaPosiljalac() {
		return bankaPosiljalac;
	}

	public void setBankaPosiljalac(Banka bankaPosiljalac) {
		this.bankaPosiljalac = bankaPosiljalac;
	}

	public Banka getBankaPrimalac() {
		return bankaPrimalac;
	}

	public void setBankaPrimalac(Banka bankaPrimalac) {
		this.bankaPrimalac = bankaPrimalac;
	}
	
	
}
