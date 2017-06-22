package com.poslovna.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateDeserializer;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

@Entity
public class DnevnoStanjeRacuna {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name = "datumStanja", columnDefinition = "DATE")
	@Temporal(TemporalType.DATE)
	@JsonSerialize(using = DateSerializer.class)
	@JsonDeserialize(using = DateDeserializer.class)
	private Date datumStanja;
	
	@Column(unique = false, nullable = true)
	@Size(max=15)
	@NotEmpty
	@Pattern(regexp = "^[0-9]+([\\,\\.][0-9]{1,})?$")
	private double prethodnoStanje;
	
	@Column(unique = false, nullable = true)
	@Size(max=15)
	@NotEmpty
	@Pattern(regexp = "^[0-9]+([\\,\\.][0-9]{1,})?$")
	private double prometNaTeret;
	
	@Column(unique = false, nullable = true)
	@Size(max=15)
	@NotEmpty
	@Pattern(regexp = "^[0-9]+([\\,\\.][0-9]{1,})?$")
	private double prometUKorist;
	
	@Column(unique = false, nullable = true)
	@Size(max=15)
	@NotEmpty
	@Pattern(regexp = "^[0-9]+([\\,\\.][0-9]{1,})?$")
	private double novoStanje;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="racun_id")
	private Racun racun;
	
	@OneToMany
	private Collection<AnalitikaIzvoda> analitikeIzvoda;
	
	public DnevnoStanjeRacuna() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDatumStanja() {
		return datumStanja;
	}

	public void setDatumStanja(Date datumStanja) {
		this.datumStanja = datumStanja;
	}

	public double getPrethodnoStanje() {
		return prethodnoStanje;
	}

	public void setPrethodnoStanje(double prethodnoStanje) {
		this.prethodnoStanje = prethodnoStanje;
	}

	public double getPrometNaTeret() {
		return prometNaTeret;
	}

	public void setPrometNaTeret(double prometNaTeret) {
		this.prometNaTeret = prometNaTeret;
	}

	public double getPrometUKorist() {
		return prometUKorist;
	}

	public void setPrometUKorist(double prometUKorist) {
		this.prometUKorist = prometUKorist;
	}

	public double getNovoStanje() {
		return novoStanje;
	}

	public void setNovoStanje(double novoStanje) {
		this.novoStanje = novoStanje;
	}

	public Racun getRacun() {
		return racun;
	}

	public void setRacun(Racun racun) {
		this.racun = racun;
	}

	public Collection<AnalitikaIzvoda> getAnalitikeIzvoda() {
		return analitikeIzvoda;
	}

	public void setAnalitikeIzvoda(Collection<AnalitikaIzvoda> analitikeIzvoda) {
		this.analitikeIzvoda = analitikeIzvoda;
	}
	
	
}
