package com.trifulcas.musicrec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trifulcas.musicrec.model.Autor;
import com.trifulcas.musicrec.model.Format;
import com.trifulcas.musicrec.model.Genere;
import com.trifulcas.musicrec.model.Gravacio;
import com.trifulcas.musicrec.model.Localitzacio;
import com.trifulcas.musicrec.model.LocalitzacioGravacio;
import com.trifulcas.musicrec.services.IAutorService;
import com.trifulcas.musicrec.services.IFormatService;
import com.trifulcas.musicrec.services.IGenereService;
import com.trifulcas.musicrec.services.IGravacioService;
import com.trifulcas.musicrec.services.ILocalitzacioService;
import com.trifulcas.musicrec.services.ILocalitzacioGravacioService;

@Controller
@RequestMapping("/lector")
public class LectorController {
	
	@Autowired
	private IAutorService autorService;
	@Autowired
	private IFormatService formatService;
	@Autowired
	private IGenereService genereService;
	@Autowired
	private IGravacioService gravacioService;
	@Autowired
	private ILocalitzacioService localitzacioService;
	@Autowired
	private ILocalitzacioGravacioService localitzacioGravacioService;
	
	@GetMapping("/autors")
	public String autors(Model modelo) {
		List<Autor> autors = autorService.getAutors();
		modelo.addAttribute("autors", autors);
		return "autors";
	}

	@GetMapping("/generes")
	public String generes(Model modelo) {
		List<Genere> generes = genereService.getGeneres();
		modelo.addAttribute("generes", generes);
		return "generes";
	}

	@GetMapping("/formats")
	public String formats(Model modelo) {
		List<Format> formats = formatService.getFormats();
		modelo.addAttribute("formats", formats);
		return "formats";
	}

	@GetMapping("/localitzacions")
	public String localitzacions(Model modelo) {
		List<Localitzacio> localitzacions = localitzacioService.getLocalitzacions();
		modelo.addAttribute("localitzacions", localitzacions);
		return "localitzacions";
	}
	
	@GetMapping("/gravacions")
	public String gravacions(Model modelo) {
		List<Gravacio> gravacions = gravacioService.getGravacions();
		modelo.addAttribute("gravacions", gravacions);
		modelo.addAttribute("titGrav", "Totes les Gravacions");
		return "gravacions";
	}
	
	@GetMapping("/gravacionsInterpret")
	public String gravacionsInterpret(Model modelo, @RequestParam Integer idInterpret) {
		List<Gravacio> gravacions = gravacioService.getGravacionsInterpret(idInterpret);
		Autor interpret=autorService.getAutor(idInterpret);
		modelo.addAttribute("gravacions", gravacions);
		modelo.addAttribute("titGrav", "Gravacions de " + interpret.getNom() + " (intèrpret)");
		return "gravacions";
	}
	
	@GetMapping("/gravacionsCompositor")
	public String gravacionsCompositor(Model modelo, @RequestParam Integer idCompositor) {
		List<Gravacio> gravacions = gravacioService.getGravacionsCompositor(idCompositor);
		Autor compositor=autorService.getAutor(idCompositor);
		modelo.addAttribute("gravacions", gravacions);
		modelo.addAttribute("titGrav", "Gravacions de " + compositor.getNom() + " (compositor)");
		return "gravacions";
	}
	
	@GetMapping("/gravacionsGenere")
	public String gravacionsGenere(Model modelo, @RequestParam Integer idGenere) {
		List<Gravacio> gravacions = gravacioService.getGravacionsGenere(idGenere);
		Genere genere=genereService.getGenere(idGenere);
		modelo.addAttribute("gravacions", gravacions);
		modelo.addAttribute("titGrav", "Gravacions de Música " + genere.getNom());
		return "gravacions";
	}
	
	@GetMapping("/locGrav")
	public String locGrav(Model modelo) {
		List<LocalitzacioGravacio> locGravs = localitzacioGravacioService.getLocGrav();
		modelo.addAttribute("locGravs", locGravs);
		modelo.addAttribute("titLocGrav", "Totes les Localitzacions de Gravacions");
		return "locGravacions";
	}
	
	@GetMapping("/locGravFormat")
	public String locGravFormat(Model modelo, @RequestParam Integer idFormat) {
		List<LocalitzacioGravacio> locGravs = localitzacioGravacioService.getLocGravFormat(idFormat);
		Format format=formatService.getFormat(idFormat);
		modelo.addAttribute("locGravs", locGravs);
		modelo.addAttribute("titLocGrav", "Localitzacio Gravacions en format " + format.getNom());
		return "locGravacions";
	}
	
	@GetMapping("/locGravLocalitzacio")
	public String locGravLocalitzacio(Model modelo, @RequestParam Integer idLocalitzacio) {
		List<LocalitzacioGravacio> locGravs = localitzacioGravacioService.getLocGravLocalitzacio(idLocalitzacio);
		Localitzacio localitzacio=localitzacioService.getLocalitzacio(idLocalitzacio);
		modelo.addAttribute("locGravs", locGravs);
		modelo.addAttribute("titLocGrav", "Gravacions en localització " + localitzacio.getDescLloc());
		return "locGravacions";
	}
	
	@GetMapping("/locGravGravacio")
	public String locGravGravacio(Model modelo, @RequestParam Integer idGravacio) {
		List<LocalitzacioGravacio> locGravs = localitzacioGravacioService.getLocGravGravacio(idGravacio);
		Gravacio gravacio=gravacioService.getGravacio(idGravacio);
		modelo.addAttribute("locGravs", locGravs);
		modelo.addAttribute("titLocGrav", "Localitzacions Gravació " + gravacio.getAlbum());
		return "locGravacions";
	}
	
}