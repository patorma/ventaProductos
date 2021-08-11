package com.patriciocontreras.ventaproducto.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.patriciocontreras.ventaproducto.models.dao.IProductoDao;
import com.patriciocontreras.ventaproducto.models.entity.Producto;

@Service
public class IProductoServiceImpl implements IProductoService {
	
	@Autowired
	private IProductoDao productoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		
		return productoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Producto> findAll(Pageable pageable) {
		
		return productoDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findById(Long id) {
		
		return productoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Producto save(Producto producto) {
		
		return productoDao.save(producto);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		productoDao.deleteById(id);
		
	}

	

	@Override
	@Transactional
	public void findTiposProductos(int dia) {
		
		 productoDao.findTiposProductos(dia);
	}

	/*@Override
	@Transactional(readOnly = true)
	public List<Producto> findTiposProductos() {
		
		return productoDao.findTiposProductos();
	}*/

}
