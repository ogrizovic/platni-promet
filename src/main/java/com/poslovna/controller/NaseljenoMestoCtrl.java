package com.poslovna.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.poslovna.model.NaseljenoMesto;
import com.poslovna.service.NaseljenoMestoService;

@RestController
@RequestMapping("/drzave/{idDrzave}/naseljena-mesta")
public class NaseljenoMestoCtrl {

	@Autowired
	private NaseljenoMestoService nmService;
	
	public NaseljenoMestoCtrl() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<NaseljenoMesto>> getAll(@PathVariable Integer idDrzave){
		ArrayList<NaseljenoMesto> nm = nmService.getAll(idDrzave);
		if (nm == null){
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		return new ResponseEntity<ArrayList<NaseljenoMesto>>(nm, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", 
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<NaseljenoMesto> getById(@PathVariable Integer id){
		NaseljenoMesto nm = nmService.getById(id);
		if (nm == null){
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		return new ResponseEntity<NaseljenoMesto>(nm, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<NaseljenoMesto> add(@RequestBody NaseljenoMesto nm, @PathVariable Integer idDrzave) {
		NaseljenoMesto nam = new NaseljenoMesto(nm);
		//nam.setMaticnaDrzava(idDrzave);
		
		if (nmService.add(nam) == null){
			return new ResponseEntity<NaseljenoMesto>(HttpStatus.FORBIDDEN);
		}
		return new ResponseEntity<NaseljenoMesto>(nam, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}",
			method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<NaseljenoMesto> update(@RequestBody NaseljenoMesto nm, @PathVariable Integer id) {
		NaseljenoMesto nam  = nmService.update(nm, id);
		if (nam == null){
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		return new ResponseEntity<NaseljenoMesto>(nam, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}",
			method = RequestMethod.DELETE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<NaseljenoMesto> delete(@PathVariable Integer id) {
		boolean succes = nmService.delete(id);
		if (!succes){
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
