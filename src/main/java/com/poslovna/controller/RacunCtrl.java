package com.poslovna.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.poslovna.model.DnevnoStanjeRacuna;
import com.poslovna.model.Racun;
import com.poslovna.model.Valuta;
import com.poslovna.model.users.Client;
import com.poslovna.model.users.Klijent;
import com.poslovna.model.users.PravnoLice;
import com.poslovna.model.users.access.User;
import com.poslovna.repo.BankaRepo;
import com.poslovna.repo.KlijentRepo;
import com.poslovna.service.KlijentService;
import com.poslovna.service.RacunService;

@Controller
@RequestMapping(value = "/racuni")
public class RacunCtrl {

	@Autowired
	private RacunService racunService;
	
	@Autowired
	private KlijentService klijentService;
	
	@Autowired
	private BankaRepo bankaRepo;
	
	public RacunCtrl() {
		// TODO Auto-generated constructor stub
	}
	
	// kada se pravi novi racun prosledjuje se samo valuta racuna
	@RequestMapping(value="/fizickoLice",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Racun> addFizickiRacun(HttpServletRequest request, @RequestBody Valuta valuta){
		Racun racun = new Racun();
		User sessionUser = (User) request.getSession().getAttribute("user");
		if (sessionUser == null){
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		Klijent klijent =  sessionUser.getKlijent();
		racun.setValuta(valuta);
		racun.setKlijent(klijent);
		racun.setStatus("A");
		racun.setBanka(bankaRepo.findOne(1)); // jedna jedina banka u bazi
		racun.setBrojRacuna(racunService.generateBrojRacuna());
		
		ArrayList<Racun> racuni = (ArrayList<Racun>) klijent.getRacuni();
		racuni.add(racun);
		klijent.setRacuni(racuni);
		
		klijentService.update(klijent);
		
		return new ResponseEntity<Racun>(racun, HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ArrayList<Racun> getAll(){
		return (ArrayList<Racun>) racunService.getAll();
	}
	
	@RequestMapping(value = "/stanje", 
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody DnevnoStanjeRacuna getStanjeRacuna(@RequestParam(value = "racunId") String racunId,
			@RequestParam(value = "datum") String datum){
		Racun racun = racunService.getById(Integer.parseInt(racunId));
		Set<DnevnoStanjeRacuna> stanja = (Set<DnevnoStanjeRacuna>) racun.getDnevnoStanje();
		for(DnevnoStanjeRacuna dsr : stanja){
			if(dsr.getDatumStanja().equals(datum)){
				return dsr;
			}
		}
		return null;
	}
}
