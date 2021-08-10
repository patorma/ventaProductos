package com.patriciocontreras.ventaproducto.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "tipos_productos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@NonNull
public class TipoProducto implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=3, max=100)
	@NotEmpty 
	@Column(nullable = false,unique=true) 
	private String tipo;
	
	@Column(nullable = false)
	@NotEmpty  
	@Size(min=10, max=300)
	private String descripcion;
	
	
	



private static final long serialVersionUID = 1L;
}
