package com.patriciocontreras.ventaproducto.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patriciocontreras.ventaproducto.models.entity.TipoProducto;

public interface ITipoProductoDao extends JpaRepository<TipoProducto, Long> {

}
