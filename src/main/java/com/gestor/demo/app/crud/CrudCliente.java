package com.gestor.demo.app.crud;

import org.springframework.data.repository.CrudRepository;

import com.gestor.demo.app.model.Cliente;

public interface CrudCliente extends CrudRepository<Cliente, Integer>{

}
