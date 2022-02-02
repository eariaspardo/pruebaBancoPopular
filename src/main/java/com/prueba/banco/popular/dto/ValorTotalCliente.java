package com.prueba.banco.popular.dto;

public class ValorTotalCliente {
	
	private Integer documento;
	
	private String nombre;
	
	private Double totalServicios;
	
	private Double totalAlojamiento;
	
	private Double total;
	
	public ValorTotalCliente() {
	}
	
	public ValorTotalCliente(Integer documento, String nombre, Double totalServicios, Double totalAlojamiento,
			Double total) {
		this.documento = documento;
		this.nombre = nombre;
		this.totalServicios = totalServicios;
		this.totalAlojamiento = totalAlojamiento;
		this.total = total;
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

	public Double getTotalServicios() {
		return totalServicios;
	}

	public void setTotalServicios(Double totalServicios) {
		this.totalServicios = totalServicios;
	}

	public Double getTotalAlojamiento() {
		return totalAlojamiento;
	}

	public void setTotalAlojamiento(Double totalAlojamiento) {
		this.totalAlojamiento = totalAlojamiento;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
	
	
}
