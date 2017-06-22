package com.poslovna.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.poslovna.model.NaseljenoMesto;
import com.poslovna.service.DrzavaService;
import com.poslovna.service.NaseljenoMestoService;

@Controller
public class DrzavaRegCtrl {

	@Autowired
	private NaseljenoMestoService nmService;
	@Autowired
	private DrzavaService dService;
	
	@RequestMapping(value = "/naseljenaMestaV",
			method = RequestMethod.GET)
	public String getDrzaveView(HttpServletRequest request, Model model){
		int idDrzave = Integer.parseInt(request.getParameter("id"));
		ArrayList<NaseljenoMesto> nMesta = nmService.getAll(idDrzave);
		
		model.addAttribute("idDrzave", idDrzave);
		model.addAttribute("drzava", dService.getById(idDrzave).getNaziv());
		model.addAttribute("nMesta", nMesta);
		
		
		return "naseljenaMestaView";
	}
}
