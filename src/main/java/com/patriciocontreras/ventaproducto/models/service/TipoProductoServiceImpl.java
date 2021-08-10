package com.patriciocontreras.ventaproducto.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.patriciocontreras.ventaproducto.models.dao.ITipoProductoDao;
import com.patriciocontreras.ventaproducto.models.entity.TipoProducto;

@Service
public class TipoProductoServiceImpl implements ITipoProductoService {
	
	@Autowired
	private ITipoProductoDao tipoProductoDao;

	@Override
	@Transactional(readOnly = true)
	public List<TipoProducto> findAll() {
	
		return tipoProductoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<TipoProducto> findAll(Pageable pageable) {
		
		return tipoProductoDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public TipoProducto findById(Long id) {
	
		return tipoProductoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public TipoProducto save(TipoProducto tipoProducto) {
		
		return tipoProductoDao.save(tipoProducto);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		tipoProductoDao.deleteById(id);

	}

}
