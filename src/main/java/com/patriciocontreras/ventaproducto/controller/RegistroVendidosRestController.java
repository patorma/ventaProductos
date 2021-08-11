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

import com.patriciocontreras.ventaproducto.models.entity.RegistroVendidos;
import com.patriciocontreras.ventaproducto.models.service.IRegistroVendidosService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("/api")
public class RegistroVendidosRestController {
	
	@Autowired
	private IRegistroVendidosService registroService;
	
	@GetMapping("/registroVendidos")
	public List<RegistroVendidos> index(){
		return registroService.findAll();
	}
	
	@GetMapping("/registroVendidos/page/{page}")
	public Page<RegistroVendidos> index(@PathVariable Integer page){
		Pageable pageable = PageRequest.of(page, 4);
		return registroService.findAll(pageable);
		
	}
	
	@GetMapping("/registroVendidos/{id}")
	public ResponseEntity<?> show(@PathVariable Long id){
		RegistroVendidos registro = null;
		Map<String, Object> response  = new HashMap<>();
		try {
			registro = registroService.findById(id);
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos!");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(registro == null) {
			response.put("mensaje", "El registro de venta con ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<RegistroVendidos>(registro,HttpStatus.OK);
		
	}
	
	@PostMapping("/registroVendidos")
	public ResponseEntity<?> create(@Valid @RequestBody RegistroVendidos registro,BindingResult result){
		
		RegistroVendidos registroNew = null;
		
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
			registroNew = registroService.save(registro);
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos!");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		//se podria pasar un map con un mensaje y con el registro creado
				response.put("mensaje", "El registro de venta ha sido creado con éxito! ");
				response.put("registro de venta",registroNew);
				return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}
	
	@PutMapping("/registroVendidos/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody RegistroVendidos registro,BindingResult result,@PathVariable Long id){

		//Obtenemos el registro de venta que queremos modificar de la bd por Id
		RegistroVendidos registroActual = registroService.findById(id);
		
		//Registro de venta que ya fue actualizado
		RegistroVendidos registroUpdated = null;
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
		
		if(registroActual == null) {
			response.put("mensaje", "Error: no se pudo editar, el registro con ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		try {
			registroActual.setFecha(registro.getFecha());
			registroActual.setDescripcion(registro.getDescripcion());
			 registroUpdated = registroService.save(registroActual);
			
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al actualizar el registro de venta en la base de datos!");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El registro de venta ha sido actualizado con éxito!");
		response.put("registro", registroUpdated);
		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/registroVendidos/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		
		//Map para guardar el contenido que enviaremos en el ResponseEntity con mensajes
		Map<String, Object> response = new HashMap<>();
		
		try {
			registroService.delete(id);
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el registro de venta de la base de datos!");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El registro de venta fue eliminado con éxito!");
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
		
	}
	

}
