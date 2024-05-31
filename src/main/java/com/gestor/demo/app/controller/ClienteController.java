package com.gestor.demo.app.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gestor.demo.app.model.Cliente;
import com.gestor.demo.app.model.Paquete;
import com.gestor.demo.app.servicios.ServiciosCrudCliente;
import com.gestor.demo.app.servicios.ServiciosCrudPaquete;
@Controller
public class ClienteController {

	@Autowired
	private ServiciosCrudCliente servicioscrudcliente;
	
	@Autowired
	private ServiciosCrudPaquete servicioscrudpaquete;
	
	
	@GetMapping("/verCliente")
	public String listarCliente(Model model) {
		List<Cliente> listaCliente =servicioscrudcliente.findAll();
		model.addAttribute("listaCliente",listaCliente);
		
		return "verCliente";
	}
	
	@GetMapping("/Vercliente/formCliente")
	public String mostrarFormulario (Model model) {
		model.addAttribute("cliente",new Cliente());
		
		
		List<Cliente>
		ListaCliente = servicioscrudcliente.findAll();
		model.addAttribute("ListaCliente", ListaCliente);
		
		List<Paquete>
		listaPaquete = servicioscrudpaquete.findAll();
		model.addAttribute("listaPaquete", listaPaquete);
		
		return "formCliente";
	}

	@PostMapping("/guardarCliente")
	public String guardarClub (Cliente cliente) {
		servicioscrudcliente.save(cliente);
		return "redirect:/verCliente";
	}
	
	@GetMapping ("/cliente/editar/{id}")
	public String modificarCliente (@PathVariable("id") Integer id, Model model) {
		Cliente cliente = servicioscrudcliente.findById(id).get();
		model.addAttribute("cliente",cliente);
		List<Cliente>
		listaCliente = servicioscrudcliente.findAll();
		
		model.addAttribute("listaCliente", listaCliente);
		
		List<Paquete>
		listPaquete = servicioscrudpaquete.findAll();
		
		model.addAttribute("listPaquete", listPaquete);
		
		return "formCliente";
	}
	
	@GetMapping ("/cliente/eliminar/{id}")
	public String eliminarCliente(@PathVariable("id") Integer id, Model model) {
		servicioscrudcliente.deleteById(id);
		return "redirect:/verCliente";
	}
}
