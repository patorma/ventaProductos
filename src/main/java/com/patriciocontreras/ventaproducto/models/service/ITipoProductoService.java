package com.patriciocontreras.ventaproducto.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.patriciocontreras.ventaproducto.models.entity.TipoProducto;

public interface ITipoProductoService {

	public List<TipoProducto> findAll();
	
	public Page<TipoProducto> findAll(Pageable pageable);
	
	public TipoProducto findById(Long id);
	
	public TipoProducto save(TipoProducto tipoProducto);

	public void delete(Long id);
}
