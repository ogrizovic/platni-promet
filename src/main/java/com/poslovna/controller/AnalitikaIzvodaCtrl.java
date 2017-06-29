package com.poslovna.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.poslovna.model.AnalitikaIzvoda;
import com.poslovna.service.AnalitikaIzvodaService;

@Controller
@RequestMapping(value = "/analitikaIzvoda")
public class AnalitikaIzvodaCtrl {

	@Autowired
	private AnalitikaIzvodaService analitikaService;
	
	public AnalitikaIzvodaCtrl() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<AnalitikaIzvoda> getAll(@RequestBody String racunId){
		return analitikaService.getAllZaRacun(Integer.parseInt(racunId));
	}
	
	@RequestMapping(value = "/add", 
			method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AnalitikaIzvoda> add(@RequestBody AnalitikaIzvoda ai){
		analitikaService.add(ai);
		return new ResponseEntity<AnalitikaIzvoda>(ai, HttpStatus.OK);
	}
}
