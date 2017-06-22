package com.poslovna.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poslovna.model.Racun;
import com.poslovna.service.RacunService;

@Controller
@RequestMapping(value = "/poslovna/racun")
public class RacunCtrl {

	@Autowired
	private RacunService racunService;
	
	public RacunCtrl() {
		// TODO Auto-generated constructor stub
	}
	
	public ResponseEntity<Racun> add(HttpServletRequest request, @RequestBody Racun racun){
		return null;
	}
}
