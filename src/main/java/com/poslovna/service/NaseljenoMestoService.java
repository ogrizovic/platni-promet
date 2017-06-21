package com.poslovna.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.poslovna.model.NaseljenoMesto;

@Service
public class NaseljenoMestoService {

	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	ArrayList<NaseljenoMesto> naseljenaM = new ArrayList<NaseljenoMesto>();
	Type type = new TypeToken<ArrayList<NaseljenoMesto>>() {}.getType();
	private int idCount;

	public NaseljenoMestoService() {
		// TODO Auto-generated constructor stub
		setNaseljenaM(getAll(0));
		setIdCount();
	}
	
	// Ako je idDrzave = 0 vraca sva naseljena mesta iz svih drzava
	public ArrayList<NaseljenoMesto> getAll(Integer idDrzave){
		
		Reader reader;
		
		try {
			reader = new FileReader("C:\\Users\\Nikola\\Downloads\\4.Godina\\BEZBEDNOST\\GIT2\\platni-promet\\src\\main\\webapp\\naseljenaMesta.json");
			
			setNaseljenaM(gson.fromJson(reader, type));
			
			if (idDrzave == 0){
				return getNaseljenaM();
			}
			else {
				ArrayList<NaseljenoMesto> nmDrzave = new ArrayList<>();
				for (NaseljenoMesto nm : naseljenaM) {
					if (nm.getMaticnaDrzava() == idDrzave){
						nmDrzave.add(nm);
					}
				}
				return nmDrzave;
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	public NaseljenoMesto getById(Integer id){
		for (NaseljenoMesto nm : naseljenaM) {
			if(nm.getId() == id){
				return nm;
			}
		}
		return null;
	}
	
	public NaseljenoMesto add(NaseljenoMesto nm){
		setIdCount();
		nm.setId(++idCount);
		getNaseljenaM().add(nm);
		
		Writer writer;
		
		try {
			writer = new FileWriter("C:\\Users\\Nikola\\Downloads\\4.Godina\\BEZBEDNOST\\GIT2\\platni-promet\\src\\main\\webapp\\naseljenaMesta.json");
			
			gson.toJson(naseljenaM, writer);
			
			writer.close();
			
			return nm;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	public NaseljenoMesto update(NaseljenoMesto nm, Integer id){
		for (NaseljenoMesto nasm : naseljenaM) {
			if(id == nasm.getId()){
				//nm.setMaticnaDrzava(nasm.getMaticnaDrzava());
				nm.setId(id);
				naseljenaM.remove(nasm);
				naseljenaM.add(nm);
				
				Writer writer;
				try {
					writer = new FileWriter("C:\\Users\\Nikola\\Downloads\\4.Godina\\BEZBEDNOST\\GIT2\\platni-promet\\src\\main\\webapp\\naseljenaMesta.json");
					
					gson.toJson(naseljenaM, writer);
					
					writer.close();
					
					return nm;
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
			}
		}
		return null;
	}
	
	public boolean delete(int id){
		for (NaseljenoMesto nasm : naseljenaM) {
			if(nasm.getId() == id){
				naseljenaM.remove(nasm);
				setIdCount();
				
				Writer writer;
				try {
					writer = new FileWriter("C:\\Users\\Nikola\\Downloads\\4.Godina\\BEZBEDNOST\\GIT2\\platni-promet\\src\\main\\webapp\\naseljenaMesta.json");
					
					gson.toJson(naseljenaM, writer);
					
					writer.close();
					
					return true;
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				}
				
			}
		}
		return false;
	}

	public boolean deleteAll(Integer idDrzave){
		ArrayList<NaseljenoMesto> novaNaseljenaM = new ArrayList<>();
		for (NaseljenoMesto nm : naseljenaM) {
			if (nm.getMaticnaDrzava() != idDrzave){
				novaNaseljenaM.add(nm);
			}
		}
		
		setNaseljenaM(novaNaseljenaM);
		
		setIdCount();
		
		Writer writer;
		try {
			writer = new FileWriter("C:\\Users\\Nikola\\Downloads\\4.Godina\\BEZBEDNOST\\GIT2\\platni-promet\\src\\main\\webapp\\naseljenaMesta.json");
			
			gson.toJson(naseljenaM, writer);
			
			writer.close();
			
			return true;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	
	public ArrayList<NaseljenoMesto> getNaseljenaM() {
		return naseljenaM;
	}

	public void setNaseljenaM(ArrayList<NaseljenoMesto> naseljenaM) {
		this.naseljenaM = naseljenaM;
	}

	public int getIdCount() {
		return idCount;
	}

	public void setIdCount() {
		ArrayList<Integer> ids = new ArrayList<>();
		for (NaseljenoMesto nm : naseljenaM) {
			ids.add(nm.getId());
		}
		this.idCount = Collections.max(ids); 
	}
	
}
