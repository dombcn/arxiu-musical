package com.trifulcas.musicrec.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trifulcas.musicrec.model.Format;
import com.trifulcas.musicrec.model.Gravacio;
import com.trifulcas.musicrec.model.Localitzacio;
import com.trifulcas.musicrec.model.LocalitzacioGravacio;
import com.trifulcas.musicrec.services.IFormatService;
import com.trifulcas.musicrec.services.IGravacioService;
import com.trifulcas.musicrec.services.ILocalitzacioService;
import com.trifulcas.musicrec.services.ILocalitzacioGravacioService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private IFormatService formatService;
	@Autowired
	private ILocalitzacioService localitzacioService;
	@Autowired
	private IGravacioService gravacioService;
	@Autowired
	private ILocalitzacioGravacioService localitzacioGravacioService;
	
	// FORMATS
	
	@GetMapping("/addFormat")
	public String addFormat(Model modelo) {
		Format format = new Format();
		modelo.addAttribute(format);
		modelo.addAttribute("titNewUpdate", "Afegir Format");
		return "form-format";
	}
	
	@PostMapping("/saveFormat")
	public String saveFormat(@Valid @ModelAttribute("format") Format format,
			BindingResult bindingResult, Model modelo) {
		modelo.addAttribute("titNewUpdate", "Afegir/Modificar Format");
		if (bindingResult.hasErrors()) {
			return "form-format";
		}
		else {
			try {
				formatService.save(format);
			}
			catch (Exception e) {
				System.err.println("Error guardant un Format. [" + e + "]");
				modelo.addAttribute("msgGenError", "Error al guardar aquest format.");
				return "form-format";
			}
			return "redirect:/lector/formats";
		}
	}
	
	@GetMapping("/updateFormat")
	public String updateFormat(@RequestParam("idFormat") Integer idFormat, Model modelo) {
		Format format = formatService.getFormat(idFormat);
		modelo.addAttribute(format);
		modelo.addAttribute("titNewUpdate", "Modificar Format");
		return "form-format";
	}

	@GetMapping("/deleteFormat")
	public String deleteFormat(@RequestParam("idFormat") int idFormat) {
		try {
			Format format = formatService.getFormat(idFormat);
			formatService.delete(format);
		}
		catch (Exception e) {
			System.err.println("Error eliminant un Format. [" + e + "]");
		}
		return "redirect:/lector/formats";
	}
	
	// LOCALITZACIONS
	
	@GetMapping("/addLocalitzacio")
	public String addLocalitzacio(Model modelo) {
		Localitzacio localitzacio = new Localitzacio();
		modelo.addAttribute(localitzacio);
		modelo.addAttribute("titNewUpdate", "Afegir Localització");
		return "form-localitzacio";
	}
	
	@PostMapping("/saveLocalitzacio")
	public String saveLocalitzacio(@Valid @ModelAttribute("localitzacio") 
			Localitzacio localitzacio, BindingResult bindingResult, Model modelo) {
		modelo.addAttribute("titNewUpdate", "Afegir/Modificar Localització");
		if (bindingResult.hasErrors()) {
			return "form-localitzacio";
		}
		else {
			try {
				localitzacioService.save(localitzacio);
			}
			catch (Exception e) {
				System.err.println("Error guardant una Localització. [" + e + "]");
				modelo.addAttribute("msgGenError", "Error al guardar aquesta localització.");
				return "form-localitzacio";
			}
			return "redirect:/lector/localitzacions";
		}
	}
	
	@GetMapping("/updateLocalitzacio")
	public String updateLocalitzacio(@RequestParam("idLocalitzacio") Integer idLocalitzacio, Model modelo) {
		Localitzacio localitzacio = localitzacioService.getLocalitzacio(idLocalitzacio);
		modelo.addAttribute(localitzacio);
		modelo.addAttribute("titNewUpdate", "Modificar Localització");
		return "form-localitzacio";
	}

	@GetMapping("/deleteLocalitzacio")
	public String deleteLocalitzacio(@RequestParam("idLocalitzacio") int idLocalitzacio) {
		try {
			Localitzacio localitzacio = localitzacioService.getLocalitzacio(idLocalitzacio);
			localitzacioService.delete(localitzacio);
		}
		catch (Exception e) {
			System.err.println("Error eliminant una Localització. [" + e + "]");
		}
		return "redirect:/lector/localitzacions";
	}
	
	// LOCALITZACIOGRAVACIONS
	
	@GetMapping("/addLocGrav")
	public String addLocGrav(Model modelo) {
		LocalitzacioGravacio localitzacioGravacio = new LocalitzacioGravacio();
		modelo.addAttribute(localitzacioGravacio);
		loadDropDownLists(modelo);
		modelo.addAttribute("titNewUpdate", "Afegir Localització d'una Gravació");
		modelo.addAttribute("msgGravacioNotNull", "");
		modelo.addAttribute("msgLocalitzacioNotNull", "");
		modelo.addAttribute("msgFormatNotNull", "");
		return "form-locgrav";
	}
	
	@PostMapping("/saveLocGrav")
	public String saveLocGrav(@Valid @ModelAttribute("localitzacioGravacio") 
			LocalitzacioGravacio localitzacioGravacio, BindingResult bindingResult, Model modelo) {
		modelo.addAttribute("titNewUpdate", "Afegir/Modificar Localització d'una Gravació");
		if (bindingResult.hasErrors()) {
			return "form-locgrav";
		}
		else {
			Gravacio gravacio = localitzacioGravacio.getGravacio();
			Localitzacio localitzacio = localitzacioGravacio.getLocalitzacio();
			Format format = localitzacioGravacio.getFormat();
			boolean err=false;
			if(gravacio.getIdGravacio() == null) {
				// Error: Gravacio must be NotNull
				modelo.addAttribute("msgGravacioNotNull", "L'àlbum (gravació) és obligatori.");
				err = true;
			}
			if(localitzacio.getIdLocalitzacio() == null) {
				// Error: Localització must be NotNull
				modelo.addAttribute("msgLocalitzacioNotNull", "La localització és obligatòria.");
				err = true;
			}
			if(format.getIdFormat() == null) {
				// Error: Format must be NotNull
				modelo.addAttribute("msgFormatNotNull", "El format és obligatori.");
				err = true;
			}
			if(err) {
				loadDropDownLists(modelo);
				return "form-locgrav";
			}
			else {
				try {
					localitzacioGravacioService.save(localitzacioGravacio);
				}
				catch (Exception e) {
					System.err.println("Error guardant una Localització d'una Gravació. [" + e + "]");
					modelo.addAttribute("msgGenError", "Error al guardar aquesta localització d'una gravació.");
					return "form-locgrav";
				}
				return "redirect:/lector/locGrav";
			}
		}
	}
	
	@GetMapping("/updateLocGrav")
	public String updateLocGrav(@RequestParam("idLocGrav") Integer idLocGrav, Model modelo) {
		LocalitzacioGravacio localitzacioGravacio = localitzacioGravacioService.getLocalitzacioGravacio(idLocGrav);
		modelo.addAttribute(localitzacioGravacio);
		loadDropDownLists(modelo);
		modelo.addAttribute("titNewUpdate", "Modificar Localització d'una Gravació");
		return "form-locgrav";
	}

	@GetMapping("/deleteLocGrav")
	public String deleteLocGrav(@RequestParam("idLocGrav") int idLocGrav) {
		try {
			LocalitzacioGravacio locGrav = localitzacioGravacioService.getLocalitzacioGravacio(idLocGrav);
			localitzacioGravacioService.delete(locGrav);
		}
		catch (Exception e) {
			System.err.println("Error eliminant una Localització d'una Gravació. [" + e + "]");
		}
		return "redirect:/lector/locGrav";
	}
	
	private void loadDropDownLists(Model modelo) {
		List<Format> formats = formatService.getFormats();
		modelo.addAttribute("formats", formats);
		List<Localitzacio> localitzacions = localitzacioService.getLocalitzacions();
		modelo.addAttribute("localitzacions", localitzacions);
		List<Gravacio> gravacions = gravacioService.getGravacions();
		modelo.addAttribute("gravacions", gravacions);
	}
	
}
