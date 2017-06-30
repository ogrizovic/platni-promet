package com.poslovna.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.poslovna.model.AnalitikaIzvoda;
import com.poslovna.model.NaseljenoMesto;
import com.poslovna.service.UplataService;

@Controller
@RequestMapping(value = "/uplataCtrl")
public class UplataCtrl {
	
	@Autowired
	private UplataService uplataService;
	
	
	public UplataCtrl(){	
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes=MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<HttpStatus> add(@RequestBody String xmlName) {

	System.out.println(xmlName);
	
	AnalitikaIzvoda ai = uplataService.odrediKojiJeXml(xmlName); // u slucaju da treba da se vrati na front analitika izvoda
	
	return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
}
