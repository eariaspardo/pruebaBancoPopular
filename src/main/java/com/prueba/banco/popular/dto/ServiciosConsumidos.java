package com.prueba.banco.popular.dto;

public class ServiciosConsumidos {
	
	private String descripcion;
	
	private Double precio;

	public ServiciosConsumidos() {
	}
	
	public ServiciosConsumidos( String descripcion, Double precio) {
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	

}
