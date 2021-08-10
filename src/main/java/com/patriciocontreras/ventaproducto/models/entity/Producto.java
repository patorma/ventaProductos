package com.patriciocontreras.ventaproducto.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "productos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@NonNull
public class Producto implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=3, max=100)
	@NotEmpty 
	@Column(nullable = false,unique=true) 
	private String nombre;
	
	@Column(nullable = false) 
	@Range(min=01,message = "Solo numeros positivos")
	private int price;
	
	@Column(nullable = false) 
	private int sellIn;
	
	@Column(nullable = false)
	private int stock;
	
	@Column(nullable = false)
	@NotEmpty  
	@Size(min=10, max=300)
	private String descripcion;

	@Column(name = "fecha_ingreso")
	@NotNull(message = "no puede estar vacio")
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@NotNull(message = "El tipo de producto no puede estar vacio")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="tipo_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer","hadler"})
	private TipoProducto tipo;
	
	@ManyToMany(fetch =  FetchType.LAZY)
	@JoinTable(name = "productos_vendidos",joinColumns = @JoinColumn(name="producto_id")
	,inverseJoinColumns = @JoinColumn(name="cliente_id"),
	uniqueConstraints = {@UniqueConstraint(columnNames = {"producto_id","cliente_id"})})
	private List<Cliente> clientes;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

}
