package com.poslovna.model;

public class NaseljenoMesto {

	private int id;
	private String name;
	private String ptt;
	
	private int maticnaDrzava;
	
	public NaseljenoMesto() {
		// TODO Auto-generated constructor stub
	}

	public NaseljenoMesto(String name, String ptt, int maticnaDrzava) {
		super();
		this.name = name;
		this.ptt = ptt;
		this.maticnaDrzava = maticnaDrzava;
	}
	
	public NaseljenoMesto(NaseljenoMesto nm){
		this.name = nm.getName();
		this.ptt = nm.getPtt();
		this.maticnaDrzava = nm.getMaticnaDrzava();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPtt() {
		return ptt;
	}

	public void setPtt(String ptt) {
		this.ptt = ptt;
	}

	public int getMaticnaDrzava() {
		return maticnaDrzava;
	}

	public void setMaticnaDrzava(int maticnaDrzava) {
		this.maticnaDrzava = maticnaDrzava;
	}
	
	
}
