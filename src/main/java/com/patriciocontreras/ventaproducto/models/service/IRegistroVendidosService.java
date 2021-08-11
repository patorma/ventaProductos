package com.patriciocontreras.ventaproducto.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.patriciocontreras.ventaproducto.models.entity.RegistroVendidos;

public interface IRegistroVendidosService {
	
	public List<RegistroVendidos> findAll();

	public Page<RegistroVendidos> findAll(Pageable pageable);
	
	public RegistroVendidos findById(Long id);
	
	public RegistroVendidos save(RegistroVendidos cliente);
	
	public void delete(Long id);

}
