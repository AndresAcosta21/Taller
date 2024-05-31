package com.gestor.demo.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.gestor.demo.app.model.Paquete;
import com.gestor.demo.app.servicios.ServiciosCrudPaquete;

@Controller
public class PaqueteController {

	
	@Autowired
	private ServiciosCrudPaquete servicioscrudpaquete;
	
	@GetMapping("/verPaquete")
	public String listarPaquete(Model model) {
		List<Paquete> listaPaquete =servicioscrudpaquete.findAll();
		model.addAttribute("listaPaquete",listaPaquete);
		
		return "verPaquete";
	}
	
	@GetMapping("/Verpaquete/formPaquete")
	public String mostrarFormulario (Model model) {
		model.addAttribute("paquete",new Paquete());
		
		List<Paquete>
		listaPaquete = servicioscrudpaquete.findAll();
		model.addAttribute("listaPaquete", listaPaquete);
		
		
		return "formPaquete";
	}

	@PostMapping("/guardarPaquete")
	public String guardarPaquete (Paquete paquete) {
		servicioscrudpaquete.save(paquete);
		return "redirect:/verPaquete";
	}
	
	@GetMapping ("/paquete/editar/{id}")
	public String modificarPaquete (@PathVariable("id") Integer id, Model model) {
		Paquete paquete = servicioscrudpaquete.findById(id).get();
		model.addAttribute("paquete",paquete);
		List<Paquete>
		listaPaquete = servicioscrudpaquete.findAll();
		
		model.addAttribute("listaPaquete", listaPaquete);
		
//		List<Paquete>
//		listPaquete = servicioscrudpaquete.findAll();
//		
//		model.addAttribute("listPaquete", listPaquete);
//		
		return "formPaquete";
	}
	
	@GetMapping ("/paquete/eliminar/{id}")
	public String eliminarpaquete(@PathVariable("id") Integer id, Model model) {
		servicioscrudpaquete.deleteById(id);
		return "redirect:/verPaquete";
	}
}
