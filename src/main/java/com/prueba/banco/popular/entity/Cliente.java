package com.prueba.banco.popular.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "documento", nullable = false)
	private Integer documento;
	
	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	@Column(name = "fecha_ingreso", nullable = false)
	private Date fechaIngreso;
	
	@Column(name = "fecha_salida", nullable = false)
	private Date fechaSalida;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cliente")
	private List<Acompanantes> acompanantes;
	
	@ManyToMany
    @JoinTable(name = "cliente_servicio",
        joinColumns = @JoinColumn(name = "id_cliente"),
        inverseJoinColumns = @JoinColumn(name = "id_servicio"))
	private List<Servicios> servicios;
	
	public Cliente() {
	}

	public Cliente(Integer id, Integer documento, String nombre, Date fechaIngreso, Date fechaSalida) {
		this.id = id;
		this.documento = documento;
		this.nombre = nombre;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDocumento() {
		return documento;
	}

	public void setDocumento(Integer documento) {
		this.documento = documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public List<Acompanantes> getAcompanantes() {
		return acompanantes;
	}

	public void setAcompanantes(List<Acompanantes> acompanantes) {
		this.acompanantes = acompanantes;
	}
	
	public List<Servicios> getServicios() {
		return servicios;
	}

	public void setServicios(List<Servicios> servicios) {
		this.servicios = servicios;
	}
	
}
