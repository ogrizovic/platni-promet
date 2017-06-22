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
public class AnalitikaIzvoda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(unique = false, nullable = false)
	@Size(max = 256)
	@NotEmpty
	@Pattern(regexp = "[\\w]{,256}")
	private String nalogodavac;
	
	@Column(unique = false, nullable = false)
	@Size(max = 256)
	@NotEmpty
	@Pattern(regexp = "[\\w]{,256}")
	private String primalac;
	
	@Column(unique = false, nullable = false)
	@Size(max = 256)
	@NotEmpty
	@Pattern(regexp = "[\\w]{,256}")
	private String svrhaPlacanja;
	
	@Column(name = "datumValute", columnDefinition = "DATE")
	@Temporal(TemporalType.DATE)
	@JsonSerialize(using = DateSerializer.class)
	@JsonDeserialize(using = DateDeserializer.class)
	private Date datumValute;
	
	@Column(name = "datumPrijema", columnDefinition = "DATE")
	@Temporal(TemporalType.DATE)
	@JsonSerialize(using = DateSerializer.class)
	@JsonDeserialize(using = DateDeserializer.class)
	private Date datumPrijema;
	
	@Column(unique = false, nullable = false)
	@Size(min=18, max=18)
	@NotEmpty
	@Pattern(regexp = "[\\d]{,18}")
	private String racunDuznika;
	
	@Column(unique = false, nullable = false)
	@Size(min=2, max=2)
	@NotEmpty
	@Pattern(regexp = "[\\d]{2}")
	private int modelZaduzenja;
	
	@Column(unique = false, nullable = false)
	@Size(max=2)
	@NotEmpty
	@Pattern(regexp = "[\\d]{20}")
	private String pozivNaBrojZaduzenja;
	
	@Column(unique = false, nullable = false)
	@Size(min=18, max=18)
	@NotEmpty
	@Pattern(regexp = "[\\d]{,18}")
	private String racunPoverioca;
	
	@Column(unique = false, nullable = true)
	@Size(min=2, max=2)
	@NotEmpty
	@Pattern(regexp = "[\\d]{2}")
	private int modelOdobrenja;
	
	@Column(unique = false, nullable = true)
	@Size(max=2)
	@NotEmpty
	@Pattern(regexp = "[\\d]{20}")
	private String pozivNaBrojOdobrenja;
	
	@Column(unique = false, nullable = false)
	@Size(max=15)
	@NotEmpty
	@Pattern(regexp = "^[0-9]+([\\,\\.][0-9]{1,})?$")
	private double iznos; 
	
	@Column(nullable = false)
	private boolean hitno;
	
	@Column(unique = false, nullable = false)
	@Size(max=1)
	@NotEmpty
	@Pattern(regexp = "[\\d]{1}")
	private int tipGreske;
	
	
	
	@ManyToOne
	private NaseljenoMesto mestoPrijema;
	
	@ManyToOne
	private DnevnoStanjeRacuna dnevnoStanje;
	
	@ManyToOne
	private Valuta valuta;
	
	public AnalitikaIzvoda() {
		// TODO Auto-generated constructor stub
	}

	public AnalitikaIzvoda(String nalogodavac, String primalac, String svrhaPlacanja, Date datumValute,
			Date datumPrijema, String racunDuznika, int modelZaduzenja, String pozivNaBrojZaduzenja,
			String racunPoverioca, int modelOdobrenja, String pozivNaBrojOdobrenja, double iznos, boolean hitno,
			int tipGreske) {
		super();
		this.nalogodavac = nalogodavac;
		this.primalac = primalac;
		this.svrhaPlacanja = svrhaPlacanja;
		this.datumValute = datumValute;
		this.datumPrijema = datumPrijema;
		this.racunDuznika = racunDuznika;
		this.modelZaduzenja = modelZaduzenja;
		this.pozivNaBrojZaduzenja = pozivNaBrojZaduzenja;
		this.racunPoverioca = racunPoverioca;
		this.modelOdobrenja = modelOdobrenja;
		this.pozivNaBrojOdobrenja = pozivNaBrojOdobrenja;
		this.iznos = iznos;
		this.hitno = hitno;
		this.tipGreske = tipGreske;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNalogodavac() {
		return nalogodavac;
	}

	public void setNalogodavac(String nalogodavac) {
		this.nalogodavac = nalogodavac;
	}

	public String getPrimalac() {
		return primalac;
	}

	public void setPrimalac(String primalac) {
		this.primalac = primalac;
	}

	public String getSvrhaPlacanja() {
		return svrhaPlacanja;
	}

	public void setSvrhaPlacanja(String svrhaPlacanja) {
		this.svrhaPlacanja = svrhaPlacanja;
	}

	public Date getDatumValute() {
		return datumValute;
	}

	public void setDatumValute(Date datumValute) {
		this.datumValute = datumValute;
	}

	public Date getDatumPrijema() {
		return datumPrijema;
	}

	public void setDatumPrijema(Date datumPrijema) {
		this.datumPrijema = datumPrijema;
	}

	public String getRacunDuznika() {
		return racunDuznika;
	}

	public void setRacunDuznika(String racunDuznika) {
		this.racunDuznika = racunDuznika;
	}

	public int getModelZaduzenja() {
		return modelZaduzenja;
	}

	public void setModelZaduzenja(int modelZaduzenja) {
		this.modelZaduzenja = modelZaduzenja;
	}

	public String getPozivNaBrojZaduzenja() {
		return pozivNaBrojZaduzenja;
	}

	public void setPozivNaBrojZaduzenja(String pozivNaBrojZaduzenja) {
		this.pozivNaBrojZaduzenja = pozivNaBrojZaduzenja;
	}

	public String getRacunPoverioca() {
		return racunPoverioca;
	}

	public void setRacunPoverioca(String racunPoverioca) {
		this.racunPoverioca = racunPoverioca;
	}

	public int getModelOdobrenja() {
		return modelOdobrenja;
	}

	public void setModelOdobrenja(int modelOdobrenja) {
		this.modelOdobrenja = modelOdobrenja;
	}

	public String getPozivNaBrojOdobrenja() {
		return pozivNaBrojOdobrenja;
	}

	public void setPozivNaBrojOdobrenja(String pozivNaBrojOdobrenja) {
		this.pozivNaBrojOdobrenja = pozivNaBrojOdobrenja;
	}

	public double getIznos() {
		return iznos;
	}

	public void setIznos(double iznos) {
		this.iznos = iznos;
	}

	public boolean isHitno() {
		return hitno;
	}

	public void setHitno(boolean hitno) {
		this.hitno = hitno;
	}

	public int getTipGreske() {
		return tipGreske;
	}

	public void setTipGreske(int tipGreske) {
		this.tipGreske = tipGreske;
	}

	public NaseljenoMesto getMestoPrijema() {
		return mestoPrijema;
	}

	public void setMestoPrijema(NaseljenoMesto mestoPrijema) {
		this.mestoPrijema = mestoPrijema;
	}

	public DnevnoStanjeRacuna getDnevnoStanje() {
		return dnevnoStanje;
	}

	public void setDnevnoStanje(DnevnoStanjeRacuna dnevnoStanje) {
		this.dnevnoStanje = dnevnoStanje;
	}

	public Valuta getValuta() {
		return valuta;
	}

	public void setValuta(Valuta valuta) {
		this.valuta = valuta;
	}
	
	
}
