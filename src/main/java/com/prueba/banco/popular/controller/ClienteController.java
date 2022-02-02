package com.prueba.banco.popular.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.banco.popular.dto.ResumenCliente;
import com.prueba.banco.popular.dto.ServiciosCliente;
import com.prueba.banco.popular.dto.ValorTotalCliente;
import com.prueba.banco.popular.entity.Cliente;
import com.prueba.banco.popular.impl.ClienteServiceImp;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/myhotel")
public class ClienteController {
	
	@Autowired
	private ClienteServiceImp clienteServiceImp;
	
	@ApiOperation(value = "Informacion cliente",notes = "Informacion genereal del cliente en el hotel servicios y acompañantes")
	@GetMapping("/informacion")
	public List<Cliente> informacion() {
		return clienteServiceImp.informacion();
	}
	
	@ApiOperation(value = "Fechas de Ingreso y acompañantes",notes = "Consulta la fecha de Ingreso del clientes y cantidad de Acompañantes")
	@GetMapping("/ingresoAcompanantes")
	public List<ResumenCliente> ingresoAcompanantes() {
		
		return clienteServiceImp.ingresoAcompanates();
	}
	
	@ApiOperation(value = "servicios consumidos del cliente",notes = "Cosulta los servicios consumidos por el cliente y totales")
	@GetMapping("/serviciosConsumidos")
	public List<ServiciosCliente> servicios() {
		
		return clienteServiceImp.serviciosConsumidos();
	}
	
	@ApiOperation(value = "valor Total checkout", notes = "Consulta el valor total consumido por el cliente")
	@GetMapping("/valorTotal/{documento}")
	public ValorTotalCliente valorTotal(@PathVariable Integer documento) {
		
		return clienteServiceImp.valorTotal(documento);
	}

}
