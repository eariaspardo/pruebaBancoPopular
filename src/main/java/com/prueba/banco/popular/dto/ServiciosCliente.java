package com.prueba.banco.popular.dto;

import java.util.List;

public class ServiciosCliente {
	
	private Integer documento;
	
	private String nombre;
	
	private List<ServiciosConsumidos> servicios;
	
	public ServiciosCliente() {
	}
	
	public ServiciosCliente(Integer documento, String nombre, List<ServiciosConsumidos> servicios) {
		this.documento = documento;
		this.nombre = nombre;
		this.servicios = servicios;
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

	public List<ServiciosConsumidos> getServicios() {
		return servicios;
	}

	public void setServicios(List<ServiciosConsumidos> servicios) {
		this.servicios = servicios;
	}
	
	

}
