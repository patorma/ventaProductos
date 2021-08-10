package com.patriciocontreras.ventaproducto.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patriciocontreras.ventaproducto.models.entity.Producto;
import com.patriciocontreras.ventaproducto.models.service.IProductoService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("/api")
public class ProductoRestController {
	
	@Autowired
	private IProductoService productoService;
	
	@GetMapping("/productos")
	public List<Producto> index(){
		
		return productoService.findAll();
		
	}
	
	@GetMapping("/productos/page/{page}")
	public Page<Producto> index(@PathVariable Integer page){
		Pageable pageable = PageRequest.of(page, 4);
		return productoService.findAll(pageable);
	}
	
	@GetMapping("/productos/{id}")
	public ResponseEntity<?> show(@PathVariable Long id){
		
		Producto producto = null;
		Map<String, Object> response  = new HashMap<>();
		
		try {
			producto = productoService.findById(id);
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos!");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(producto == null) {
			response.put("mensaje", "El producto con ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Producto>(producto,HttpStatus.OK);
	}
	
	

}
