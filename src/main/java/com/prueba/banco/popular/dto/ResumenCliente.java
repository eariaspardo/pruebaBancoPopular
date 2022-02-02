package com.prueba.banco.popular.dto;

import java.util.Date;
import java.util.List;

public class ResumenCliente {
	
	private Integer documento;
	
	private String nombre;
	
	private Date fechaIngreso;
	
	private Integer totalAcompanantes;
	
	private List<InfoAcompanantes> acompanates;
	
	public ResumenCliente() {
	}
	
	public ResumenCliente(Integer documento, String nombre, Date fechaIngreso, Integer totalAcompanantes,
			List<InfoAcompanantes> acompanates) {
		this.documento = documento;
		this.nombre = nombre;
		this.fechaIngreso = fechaIngreso;
		this.totalAcompanantes = totalAcompanantes;
		this.acompanates = acompanates;
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

	public Integer getTotalAcompanantes() {
		return totalAcompanantes;
	}

	public void setTotalAcompanantes(Integer totalAcompanantes) {
		this.totalAcompanantes = totalAcompanantes;
	}

	public List<InfoAcompanantes> getAcompanates() {
		return acompanates;
	}

	public void setAcompanates(List<InfoAcompanantes> acompanates) {
		this.acompanates = acompanates;
	}
	
	

}
