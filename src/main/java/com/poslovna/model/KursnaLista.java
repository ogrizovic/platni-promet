package com.poslovna.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateDeserializer;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

@Entity
public class KursnaLista {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "datum", columnDefinition = "DATE")
	@Temporal(TemporalType.DATE)
	@JsonSerialize(using = DateSerializer.class)
	@JsonDeserialize(using = DateDeserializer.class)
	private Date datum;
	
	@Column(nullable = false)
	@Size(max = 3)
	@Pattern(regexp = "[0-9]{3}")
	private int brojKursneListe;
	
	@Column(name = "primenjujeSeOd", columnDefinition = "DATE")
	@Temporal(TemporalType.DATE)
	@JsonSerialize(using = DateSerializer.class)
	@JsonDeserialize(using = DateDeserializer.class)
	private Date primenjujeSeOd;
	
	
	@ManyToOne
	@JoinColumn(name = "banka_id")
	private Banka banka;
	
	@OneToMany(mappedBy = "kursnaLista")
	private KursUValuti kursUValuti;
	
	public KursnaLista() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public int getBrojKursneListe() {
		return brojKursneListe;
	}

	public void setBrojKursneListe(int brojKursneListe) {
		this.brojKursneListe = brojKursneListe;
	}

	public Date getPrimenjujeSeOd() {
		return primenjujeSeOd;
	}

	public void setPrimenjujeSeOd(Date primenjujeSeOd) {
		this.primenjujeSeOd = primenjujeSeOd;
	}

	public Banka getBanka() {
		return banka;
	}

	public void setBanka(Banka banka) {
		this.banka = banka;
	}

	public KursUValuti getKursUValuti() {
		return kursUValuti;
	}

	public void setKursUValuti(KursUValuti kursUValuti) {
		this.kursUValuti = kursUValuti;
	}
	
	
}
