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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.JoinColumn;
import javax.persistence.UniqueConstraint;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name="registros_vendidos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@NonNull
public class RegistroVendidos implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false) 
	@Size(min=3, max=255)
	@NotEmpty 
	private String descripcion;
	
	@Column(name = "fecha_venta")
	@NotNull(message = "no puede estar vacio")
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="producto_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer","hadler"})
	private Producto  producto;
	
	/*@ManyToMany(fetch =  FetchType.LAZY)
	@JoinTable(name = "productos_vendidos",joinColumns = @JoinColumn(name="cliente_id")
	,inverseJoinColumns  = @JoinColumn(name="producto_id"),
	uniqueConstraints = {@UniqueConstraint(columnNames = {"cliente_id","producto_id"})}
	)
	private List<Producto> productos;*/
	
	
	
	
	
	
	
	private static final long serialVersionUID = 1L;

}
