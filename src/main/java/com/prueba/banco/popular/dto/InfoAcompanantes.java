package com.prueba.banco.popular.dto;

public class InfoAcompanantes {
	
	private Integer documento;
	
	private String nombre;

	public InfoAcompanantes() {}
	
	public InfoAcompanantes(Integer documento, String nombre) {
		this.documento = documento;
		this.nombre = nombre;
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
	
	

}
