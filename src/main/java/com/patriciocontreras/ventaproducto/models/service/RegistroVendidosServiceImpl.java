package com.patriciocontreras.ventaproducto.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.patriciocontreras.ventaproducto.models.dao.RegistroVendidosDao;
import com.patriciocontreras.ventaproducto.models.entity.RegistroVendidos;

@Service
public class RegistroVendidosServiceImpl implements IRegistroVendidosService {

	@Autowired
	private RegistroVendidosDao registroDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<RegistroVendidos> findAll() {
		
		return registroDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<RegistroVendidos> findAll(Pageable pageable) {
	
		return registroDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public RegistroVendidos findById(Long id) {
	
		return registroDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public RegistroVendidos save(RegistroVendidos cliente) {
		
		return registroDao.save(cliente);
	}

	@Override
	@Transactional
	public void delete(Long id) {
	   registroDao.deleteById(id);

	}

}
