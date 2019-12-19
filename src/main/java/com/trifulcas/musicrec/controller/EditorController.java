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

import com.trifulcas.musicrec.model.Autor;
import com.trifulcas.musicrec.model.Genere;
import com.trifulcas.musicrec.model.Gravacio;
import com.trifulcas.musicrec.services.IAutorService;
import com.trifulcas.musicrec.services.IGenereService;
import com.trifulcas.musicrec.services.IGravacioService;

@Controller
@RequestMapping("/editor")
public class EditorController {
	
	@Autowired
	private IAutorService autorService;
	@Autowired
	private IGenereService genereService;
	@Autowired
	private IGravacioService gravacioService;
	
	// AUTORS
	
	@GetMapping("/addAutor")
	public String addAutor(Model modelo) {
		Autor autor = new Autor();
		modelo.addAttribute(autor);
		modelo.addAttribute("titNewUpdate", "Afegir Autor");
		return "form-autor";
	}
	
	@PostMapping("/saveAutor")
	public String saveAutor(@Valid @ModelAttribute("autor") Autor autor,
			BindingResult bindingResult, Model modelo) {
		modelo.addAttribute("titNewUpdate", "Afegir/Modificar Autor");
		if (bindingResult.hasErrors()) {
			return "form-autor";
		}
		else {
			try {
				autorService.save(autor);
			}
			catch (Exception e) {
				System.err.println("Error guardant un Autor. [" + e + "]");
				modelo.addAttribute("msgGenError", "Error al guardar aquest autor.");
				return "form-autor";
			}
			return "redirect:/lector/autors";
		}
	}
	
	@GetMapping("/updateAutor")
	public String updateAutor(@RequestParam("idAutor") Integer idAutor, Model modelo) {
		Autor autor = autorService.getAutor(idAutor);
		modelo.addAttribute(autor);
		modelo.addAttribute("titNewUpdate", "Modificar Autor");
		return "form-autor";
	}

	@GetMapping("/deleteAutor")
	public String deleteAutor(@RequestParam("idAutor") int idAutor) {
		try {
			Autor autor = autorService.getAutor(idAutor);
			autorService.delete(autor);
		}
		catch (Exception e) {
			System.err.println("Error eliminant un Autor. [" + e + "]");
		}
		return "redirect:/lector/autors";
	}
	
	// GENERES
	
	@GetMapping("/addGenere")
	public String addGenere(Model modelo) {
		Genere genere = new Genere();
		modelo.addAttribute(genere);
		modelo.addAttribute("titNewUpdate", "Afegir Gènere");
		modelo.addAttribute("msgGenError", "");
		return "form-genere";
	}
	
	@PostMapping("/saveGenere")
	public String saveGenere(@Valid @ModelAttribute("genere") Genere genere,
			BindingResult bindingResult, Model modelo) {
		modelo.addAttribute("titNewUpdate", "Afegir/Modificar Gènere");
		if (bindingResult.hasErrors()) {
			return "form-genere";
		}
		else {
			try {
				genereService.save(genere);
			}
			catch (Exception e) {
				System.err.println("Error guardant un Genere. [" + e + "]");
				modelo.addAttribute("msgGenError", "Error al guardar aquest gènere.");
				return "form-genere";
			}
			return "redirect:/lector/generes";
		}
	}
	
	@GetMapping("/updateGenere")
	public String updateGenere(@RequestParam("idGenere") Integer idGenere, Model modelo) {
		Genere genere = genereService.getGenere(idGenere);
		modelo.addAttribute(genere);
		modelo.addAttribute("titNewUpdate", "Modificar Gènere");
		modelo.addAttribute("msgGenError", "");
		return "form-genere";
	}

	@GetMapping("/deleteGenere")
	public String deleteGenere(@RequestParam("idGenere") int idGenere) {
		try {
			Genere genere = genereService.getGenere(idGenere);
			genereService.delete(genere);}
		catch (Exception e) {
			System.err.println("Error eliminant un Genere. [" + e + "]");
		}
		return "redirect:/lector/generes";
	}
	
	// GRAVACIONS
	
	@GetMapping("/addGravacio")
	public String addGravacio(Model modelo) {
		Gravacio gravacio = new Gravacio();
		modelo.addAttribute(gravacio);
		loadDropDownLists(modelo);
		modelo.addAttribute("titNewUpdate", "Afegir Gravació");
		modelo.addAttribute("msgInterpretNotNull", "");
		return "form-gravacio";
	}
	
	@PostMapping("/saveGravacio")
	public String saveGravacio(@Valid @ModelAttribute("gravacio") Gravacio gravacio, 
			BindingResult bindingResult, Model modelo) {
		modelo.addAttribute("titNewUpdate", "Afegir/Modificar Gravació");
		if (bindingResult.hasErrors()) {
			return "form-gravacio";
		}
		else {
			Autor interpret = gravacio.getInterpret();
			if(interpret.getIdAutor() == null) {
				// Error: Interprete must be NotNull
				loadDropDownLists(modelo);
				modelo.addAttribute("msgInterpretNotNull", "L'intèrpret és obligatori.");
				return "form-gravacio";
			}
			else {
				// To solve problem of Hibernate when idCompositor is null
				Autor compositor = gravacio.getCompositor();
				if(compositor.getIdAutor() == null) {
					gravacio.setCompositor(null);
				}
				// To solve problem of Hibernate when idGenere is null
				Genere genere = gravacio.getGenere();
				if(genere.getIdGenere() == null) {
					gravacio.setGenere(null);
				}
				try {
					gravacioService.save(gravacio);
				}
				catch (Exception e) {
					System.err.println("Error guardant una Gravació. [" + e + "]");
					modelo.addAttribute("msgGenError", "Error al guardar aquesta gravació.");
					return "form-gravació";
				}
				return "redirect:/lector/gravacions";
			}
		}
	}
	
	@GetMapping("/updateGravacio")
	public String updateGravacio(@RequestParam("idGravacio") Integer idGravacio, Model modelo) {
		Gravacio gravacio = gravacioService.getGravacio(idGravacio);
		modelo.addAttribute(gravacio);
		loadDropDownLists(modelo);
		modelo.addAttribute("titNewUpdate", "Modificar Gravació");
		modelo.addAttribute("msgInterpretNotNull", "");
		return "form-gravacio";
	}
	
	@GetMapping("/deleteGravacio")
	public String deleteGravacio(@RequestParam("idGravacio") int idGravacio) {
		try {
			Gravacio gravacio = gravacioService.getGravacio(idGravacio);
			gravacioService.delete(gravacio);
		}
		catch (Exception e) {
			System.err.println("Error eliminant una Gravació. [" + e + "]");
		}
		return "redirect:/lector/gravacions";
	}
	
	private void loadDropDownLists(Model modelo) {
		List<Autor> interprets = autorService.getAutors();
		modelo.addAttribute("interprets", interprets);
		List<Autor> compositors = autorService.getAutors();
		modelo.addAttribute("compositors", compositors);
		List<Genere> generes = genereService.getGeneres();
		modelo.addAttribute("generes", generes);
	}
	
}
