package com.poslovna.controller;

import java.util.ArrayList;

import javax.interceptor.Interceptors;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poslovna.model.Drzava;
import com.poslovna.model.users.access.AuthorizationInterceptor;
import com.poslovna.service.DrzavaService;

@RestController
@RequestMapping("/drzave")
public class DrzavaCtrl {
	
	@Autowired
	private DrzavaService drzavaService;
	
	public DrzavaCtrl() {
		// TODO Auto-generated constructor stub
	}
	
	@Interceptors(AuthorizationInterceptor.class)
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Drzava>> getAll(HttpServletRequest request){
		ArrayList<Drzava> drz = drzavaService.getAll();
		if (drz == null){
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		return new ResponseEntity<ArrayList<Drzava>>(drz, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", 
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Drzava> getById(@PathVariable Integer id){
		Drzava drz = drzavaService.getById(id);
		if (drz == null){
			return new ResponseEntity<Drzava>(HttpStatus.FORBIDDEN);
		}
		return new ResponseEntity<Drzava>(drz, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Drzava> add(@RequestBody Drzava d) {
		Drzava dr = drzavaService.add(d);
		if (dr == null){
			return new ResponseEntity<Drzava>(HttpStatus.FORBIDDEN);
		}
		return new ResponseEntity<Drzava>(dr, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}",
			method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Drzava> update(@RequestBody Drzava d, @PathVariable Integer id) {
		Drzava dr  = drzavaService.update(d, id);
		if (dr == null){
			return new ResponseEntity<Drzava>(HttpStatus.FORBIDDEN);
		}
		return new ResponseEntity<Drzava>(dr, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}",
			method = RequestMethod.DELETE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Drzava> delete(@PathVariable Integer id) {
		boolean succes = drzavaService.delete(id);
		if (!succes){
			return new ResponseEntity<Drzava>(HttpStatus.FORBIDDEN);
		}
		return new ResponseEntity<Drzava>(HttpStatus.OK);
	}
}
