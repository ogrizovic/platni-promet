package com.poslovna.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class StavkaPoruke {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="stavka_id")
	private AnalitikaIzvoda stavka;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="prenos_id")
	private MedjubankarskiPrenos prenos;
	
	public StavkaPoruke() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AnalitikaIzvoda getStavka() {
		return stavka;
	}

	public void setStavka(AnalitikaIzvoda stavka) {
		this.stavka = stavka;
	}

	public MedjubankarskiPrenos getPrenos() {
		return prenos;
	}

	public void setPrenos(MedjubankarskiPrenos prenos) {
		this.prenos = prenos;
	}
	
	
	
}
