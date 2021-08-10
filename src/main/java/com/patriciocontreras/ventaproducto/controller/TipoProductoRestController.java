package com.patriciocontreras.ventaproducto.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.patriciocontreras.ventaproducto.models.entity.TipoProducto;
import com.patriciocontreras.ventaproducto.models.service.ITipoProductoService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("/api")
public class TipoProductoRestController {
	
	@Autowired
	private ITipoProductoService tipoProductoService;
	
	@GetMapping("/tipos")
	public List<TipoProducto> index(){
		return tipoProductoService.findAll();
	}
	
	@GetMapping("/tipos/page/{page}")
	public Page<TipoProducto> index(@PathVariable Integer page){
		Pageable pageable = PageRequest.of(page, 4);
		return tipoProductoService.findAll(pageable);
	}
	
	@GetMapping("/tipos/{id}")
	public ResponseEntity<?> show(@PathVariable Long id){
		
		TipoProducto tipoProducto = null;
		Map<String, Object> response  = new HashMap<>();
		
		try {
			tipoProducto = tipoProductoService.findById(id);
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos!");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(tipoProducto == null) {
			response.put("mensaje", "El tipo de producto con ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<TipoProducto>(tipoProducto,HttpStatus.OK);
	}
	
	@PostMapping("/tipos")
	public ResponseEntity<?> create(@Valid @RequestBody TipoProducto tipoProducto,BindingResult result){
		// es el nuevo tipo de producto creado
		
		TipoProducto tipoProductoNew = null;
		Map<String, Object> response = new HashMap<>();
		
		// se valida si contiene errores el objeto 
		if(result.hasErrors()) {
			// se debe obtener los mensajes de errror de cada campo 
						// y convertir estos en una lista de errores de tipo string
						// se debe convertir esta lista de fielderrors en String
						List<String> errors = result.getFieldErrors()
								.stream()
								.map(err -> "El campo '"+ err.getField() + "' "+err.getDefaultMessage())//muy parecido  al operador map en angular (rxjs), mismo concepto!
								.collect(Collectors.toList());// ahora podemos convertir de regreso el stream  aun tipo List
						response.put("errors", errors);
						// se responde con un responseentity con listados de error
						return new ResponseEntity<Map<String, Object>>(response,HttpStatus.BAD_REQUEST);
						// en lo anterior se recibe un field errors y lo convertimos a string
		}
		try {
			tipoProductoNew = tipoProductoService.save(tipoProducto);
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos!");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		//se podria pasar un map con un mensaje y con el gasto creado
			response.put("mensaje", "El tipo de producto ha sido creado con éxito! ");
			response.put("tipo de producto", tipoProductoNew);
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/tipos/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody TipoProducto tipoProducto,BindingResult result,@PathVariable Long id){
		
		//Obtenemos el tipo de producto que queremos modificar de la bd por Id
		TipoProducto tipoProductoActual = tipoProductoService.findById(id);
		
		//Tipo de producto ya actualizado
		TipoProducto tipoProductoUpdated = null;
		
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {
			// se debe obtener los mensajes de errror de cada campo 
			// y convertir estos en una lista de errores de tipo string
			
			// se debe convertir esta lista de fielderrors en String
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '"+ err.getField() + "' "+err.getDefaultMessage())// muy parecido  al operador map en angular (rxjs), mismo concepto!
					.collect(Collectors.toList());// ahora podemos convertir de regreso el stream  aun tipo List
			response.put("errors", errors);
			// se responde con un responseentity con listados de error
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.BAD_REQUEST);
			
			// en lo anterior se recibe un field errors y lo convertimos a string
		}
		
		if(tipoProductoActual == null) {
			response.put("mensaje", "Error: no se pudo editar, el tipo de gasto con ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		try {
			//modificamos los datos del tipo de producto actual con los datos del tipo de producto que te envien
			tipoProductoActual.setTipo(tipoProducto.getTipo());
			tipoProductoActual.setDescripcion(tipoProducto.getDescripcion());
			
			tipoProductoUpdated = tipoProductoService.save(tipoProductoActual);
			
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al actualizar el tipo de producto en la base de datos!");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El tipo de producto ha sido actualizado con éxito!");
		response.put("tipo de producto", tipoProductoUpdated);

		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/tipos/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		//Map para guardar el contenido que enviaremos en el ResponseEntity con mensajes
		Map<String, Object> response = new HashMap<>();
		
		try {
			tipoProductoService.delete(id);
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el tipo de producto de la base de datos!");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El tipo de producto fue eliminado con éxito!");
		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
		
		
	}

}
