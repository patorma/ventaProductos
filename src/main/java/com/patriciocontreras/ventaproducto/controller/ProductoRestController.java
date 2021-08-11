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
	
	@PostMapping("/productos")
	public ResponseEntity<?> create(@Valid @RequestBody Producto producto,BindingResult result){
		
		//productoNew es el nuevo producto que va a ser creado
		Producto productoNew = null;
		
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
			productoNew = productoService.save(producto);
			
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos!");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		//se podria pasar un map con un mensaje y con el producto creado
		response.put("mensaje", "El producto ha sido creado con éxito! ");
		response.put("producto", productoNew);
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/productos/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Producto producto,BindingResult result,@PathVariable Long id){
		
		//Obtenemos el producto que queremos modificar de la bd por Id
		Producto productoActual = productoService.findById(id);
		
		// El producto ya actualizado
		
		Producto productoUpdated = null;
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
		
		if(productoActual == null) {
			response.put("mensaje", "Error: no se pudo editar, el producto con ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		try {
			//modificamos los datos del producto actual con los datos del producto que te envien
			productoActual.setNombre(producto.getNombre());
			productoActual.setPrice(producto.getPrice());
			productoActual.setSellIn(producto.getSellIn());
			productoActual.setStock(producto.getStock());
			productoActual.setDescripcion(producto.getDescripcion());
			productoActual.setFecha(producto.getFecha());
			
			productoUpdated = productoService.save(productoActual);
			
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al actualizar el producto en la base de datos!");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El producto ha sido actualizado con éxito!");
		response.put("producto", productoUpdated);
		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/productos/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		//Map para guardar el contenido que enviaremos en el ResponseEntity con mensajes
		Map<String, Object> response = new HashMap<>();
		
		try {
			productoService.delete(id);
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el producto de la base de datos!");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El producto fue eliminado con éxito!");
		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
	}
	
	/*@GetMapping("/productos/productosVendidos")
	public List<Producto> listarProductosVendidos(){
		return productoService.findTiposProductos();
	}*/
}
