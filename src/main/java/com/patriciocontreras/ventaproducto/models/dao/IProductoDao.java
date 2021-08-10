package com.patriciocontreras.ventaproducto.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patriciocontreras.ventaproducto.models.entity.Producto;

public interface IProductoDao extends JpaRepository<Producto, Long> {

}
