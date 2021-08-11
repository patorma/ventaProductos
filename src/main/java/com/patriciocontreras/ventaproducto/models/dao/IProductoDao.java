package com.patriciocontreras.ventaproducto.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import javax.persistence.NamedNativeQuery;

import com.patriciocontreras.ventaproducto.models.entity.Producto;
import com.patriciocontreras.ventaproducto.models.entity.TipoProducto;

public interface IProductoDao extends JpaRepository<Producto, Long> {

	@Query(value = "UPDATE Productos ",nativeQuery = true)
	public List<Producto> findTiposProductos(int dia);
	
	
}