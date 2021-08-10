package com.patriciocontreras.ventaproducto.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patriciocontreras.ventaproducto.models.entity.Cliente;

public interface IClienteDao extends JpaRepository<Cliente, Long>{

}
