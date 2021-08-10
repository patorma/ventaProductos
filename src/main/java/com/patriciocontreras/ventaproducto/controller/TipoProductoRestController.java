package com.patriciocontreras.ventaproducto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patriciocontreras.ventaproducto.models.entity.TipoProducto;
import com.patriciocontreras.ventaproducto.models.service.ITipoProductoService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("/api")
public class TipoProductoRestController {
	
	@Autowired
	private ITipoProductoService tipoPoductoService;
	
	@GetMapping("/tipos")
	public List<TipoProducto> index(){
		return tipoPoductoService.findAll();
	}

}
