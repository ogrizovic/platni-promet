package com.poslovna.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateDeserializer;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

@Entity
public class ZatvaranjeRacuna {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "datumZatvaranja", columnDefinition = "DATE")
	@Temporal(TemporalType.DATE)
	@JsonSerialize(using = DateSerializer.class)
	@JsonDeserialize(using = DateDeserializer.class)
	private Date datumZatvaranja;
	
	@Column(nullable = true)
	@Size(max = 18)
	@Pattern(regexp = "[0-9]{18}")
	private String prebacenoNaRacun;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="racun_id")
	private Racun racun;
	
	public ZatvaranjeRacuna() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDatumZatvaranja() {
		return datumZatvaranja;
	}

	public void setDatumZatvaranja(Date datumZatvaranja) {
		this.datumZatvaranja = datumZatvaranja;
	}

	public String getPrebacenoNaRacun() {
		return prebacenoNaRacun;
	}

	public void setPrebacenoNaRacun(String prebacenoNaRacun) {
		this.prebacenoNaRacun = prebacenoNaRacun;
	}

	public Racun getRacun() {
		return racun;
	}

	public void setRacun(Racun racun) {
		this.racun = racun;
	}
	
	
}
