package com.prueba.banco.popular.impl;

import java.util.List;

import com.prueba.banco.popular.dto.ResumenCliente;
import com.prueba.banco.popular.dto.ServiciosCliente;
import com.prueba.banco.popular.dto.ValorTotalCliente;
import com.prueba.banco.popular.entity.Cliente;

public interface ClienteServiceImp {
	
	public List<Cliente> informacion();
	
	public List<ResumenCliente> ingresoAcompanates();
	
	public List<ServiciosCliente> serviciosConsumidos();
	
	public ValorTotalCliente valorTotal(Integer documento);

}
