package com.poslovna.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.poslovna.model.users.Klijent;

@Entity
@Table(name="racun")
public class Racun {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = true)
	private int id;
	
	@Column(nullable = false)
	private String brojRacuna;
	
	@Column(nullable = false)
	private boolean status;
	
	

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="klijent_id")
	private Klijent klijent;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="banka_id")
	private Banka banka;
	
	// TODO: dnevno stanje racuna, zatvaranje racuna, valuta
}
