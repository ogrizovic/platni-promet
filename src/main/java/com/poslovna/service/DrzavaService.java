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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.poslovna.model.Drzava;

@Service
public class DrzavaService {
	
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	ArrayList<Drzava> drzave = new ArrayList<Drzava>();
	Type type = new TypeToken<ArrayList<Drzava>>() {}.getType();
	private int idCount;
	
	@Autowired
	private NaseljenoMestoService nmService;

	public DrzavaService() {
		// TODO Auto-generated constructor stub
		setDrzave(getAll());
		setIdCount();
	}
	
	public ArrayList<Drzava> getAll(){
		Reader reader;
		
		try {
			reader = new FileReader("D:\\workspace_4\\poslovna\\src\\main\\webapp\\drzave.json");
			
			setDrzave(gson.fromJson(reader, type));
			
			return getDrzave();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	public Drzava getById(int id){
		for (Drzava drzava : drzave) {
			if(drzava.getId() == id){
				return drzava;
			}
		}
		return null;
	}
	
	public Drzava add(Drzava d){
		setIdCount();
		d.setId(++idCount);
		getDrzave().add(d);
		
		Writer writer;
		
		try {
			writer = new FileWriter("D:\\workspace_4\\poslovna\\src\\main\\webapp\\drzave.json");
			
			gson.toJson(drzave, writer);
			
			writer.close();
			
			return d;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	public Drzava update(Drzava d, Integer id){
		for (Drzava drzava : drzave) {
			if(id == drzava.getId()){
				drzave.remove(drzava);
				d.setId(id);
				drzave.add(d);
				
				Writer writer;
				try {
					writer = new FileWriter("D:\\workspace_4\\poslovna\\src\\main\\webapp\\drzave.json");
					
					gson.toJson(drzave, writer);
					
					writer.close();
					
					return d;
					
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
		for (Drzava drzava : drzave) {
			if(drzava.getId() == id){
				drzave.remove(drzava);
				setIdCount();
				
				nmService.deleteAll(id);
				
				Writer writer;
				try {
					writer = new FileWriter("D:\\workspace_4\\poslovna\\src\\main\\webapp\\drzave.json");
					
					gson.toJson(drzave, writer);
					
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
	
	
	
	
	
	
	
	
	public int getIdCount() {
		return idCount;
	}

	public void setIdCount() {
		ArrayList<Integer> ids = new ArrayList<>();
		for (Drzava drzava : drzave) {
			ids.add(drzava.getId());
		}
		
		this.idCount = Collections.max(ids); 
	}

	public ArrayList<Drzava> getDrzave() {
		return drzave;
	}

	public void setDrzave(ArrayList<Drzava> drzave) {
		this.drzave = drzave;
	}
	
	
}
