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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name="clientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@NonNull
public class Cliente implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false) 
	@Size(min=3, max=50)
	@NotEmpty 
	private String nombre;
	
	@Column(nullable = false) 
	@Size(min=3, max=80)
	@NotEmpty 
	private String apellido;

	@Column(nullable = false) 
	private int telefono;
	
	@Column(nullable = false) 
	@Size(min=3, max=255)
	@NotEmpty 
	private String direccion;
	
	
	
	
	
	
	private static final long serialVersionUID = 1L;

}
