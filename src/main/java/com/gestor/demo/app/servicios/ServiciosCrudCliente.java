package com.gestor.demo.app.servicios;

import com.gestor.demo.app.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ServiciosCrudCliente  extends JpaRepository<Cliente, Integer>{

}