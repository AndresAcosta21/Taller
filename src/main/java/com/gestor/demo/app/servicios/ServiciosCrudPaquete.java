package com.gestor.demo.app.servicios;

import com.gestor.demo.app.model.Paquete;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ServiciosCrudPaquete  extends JpaRepository<Paquete, Integer>{

}