package com.patriciocontreras.ventaproducto.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import javax.persistence.NamedNativeQuery;
import javax.transaction.Transactional;

import com.patriciocontreras.ventaproducto.models.entity.Producto;
import com.patriciocontreras.ventaproducto.models.entity.TipoProducto;

public interface IProductoDao extends JpaRepository<Producto, Long> {

	// con este método  se realiza la evaluacion
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE Productos SET price=price-?1, sell_in=sell_in-?1 WHERE price!=80 AND price > 0 ",nativeQuery = true)
	public void findTiposProductos( int dia);
}