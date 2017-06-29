package com.poslovna.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.poslovna.model.AnalitikaIzvoda;
import com.poslovna.model.NaseljenoMesto;

@Controller
@RequestMapping(value = "/poslovna/uplata")
public class UplataCtrl {
	
	public UplataCtrl(){	
	}
	
	public Long i = (long) 0;
	
	@RequestMapping(method = RequestMethod.POST, consumes=MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<HttpStatus> add(@RequestBody String nm) {

	System.out.println(nm);
	return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
