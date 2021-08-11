package com.patriciocontreras.ventaproducto.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patriciocontreras.ventaproducto.models.entity.RegistroVendidos;

public interface RegistroVendidosDao extends JpaRepository<RegistroVendidos, Long>{

}
