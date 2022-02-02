package com.prueba.banco.popular.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.banco.popular.dto.InfoAcompanantes;
import com.prueba.banco.popular.dto.ResumenCliente;
import com.prueba.banco.popular.dto.ServiciosCliente;
import com.prueba.banco.popular.dto.ServiciosConsumidos;
import com.prueba.banco.popular.dto.ValorTotalCliente;
import com.prueba.banco.popular.entity.Acompanantes;
import com.prueba.banco.popular.entity.Cliente;
import com.prueba.banco.popular.entity.Servicios;
import com.prueba.banco.popular.impl.ClienteServiceImp;
import com.prueba.banco.popular.repository.ClienteRepository;

@Service
public class ClienteService implements ClienteServiceImp{
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> informacion() {
		return clienteRepository.findAll();
	}
	
	/**
	 * Consulta los acompañantes y fecha de ingreso por cliente
	 * @return
	 */
	public List<ResumenCliente> ingresoAcompanates() {
		
		List<Cliente> listaCliente = clienteRepository.findAll();
		
		List<ResumenCliente> resumen = new ArrayList<>();
		
		if (!listaCliente.isEmpty()) {
			for(Cliente datoC : listaCliente) {
				List<InfoAcompanantes> infoAcompa = new LinkedList();
				for(Acompanantes listaA : datoC.getAcompanantes()) {
					infoAcompa.add(new InfoAcompanantes(listaA.getDocumento(), listaA.getNombre()));
				}
				resumen.add(
						new ResumenCliente(datoC.getDocumento(), datoC.getNombre(), datoC.getFechaIngreso(), 
								datoC.getAcompanantes().size(), infoAcompa));
			}
		}
		
		return resumen;
	}
	
	/**
	 * Consulta de los servicios Adquiridos por el cliente
	 */
	public List<ServiciosCliente> serviciosConsumidos() {
		List<Cliente> listaCliente = clienteRepository.findAll();
		
		List<ServiciosCliente> resumen = new ArrayList<>();
		
		for(Cliente datoC : listaCliente) {
			List<ServiciosConsumidos> infoServicios = new LinkedList();
			for(Servicios listaS : datoC.getServicios()) {
				// Si tiene el plan todo incluido, elimina el cobro de los demas servicios
				if(listaS.getDescripcion().equals("Plan Todo incluido")) {
					infoServicios = new LinkedList();
					infoServicios.add(new ServiciosConsumidos(listaS.getDescripcion(), listaS.getPrecio()));
					break;
				}
				infoServicios.add(new ServiciosConsumidos(listaS.getDescripcion(), listaS.getPrecio()));
			}
			resumen.add(new ServiciosCliente(datoC.getDocumento(), datoC.getNombre(), infoServicios));
		}
		return resumen;
	}
	
	/**
	 * Total de los servicios adquiridos por cliente
	 */
	public ValorTotalCliente valorTotal(Integer documento) {
		Cliente clienteResumen = clienteRepository.findByDocumento(documento);
		
		if(clienteResumen == null) {
			return new ValorTotalCliente();
		}
		
		ValorTotalCliente total = new ValorTotalCliente();
		
		total.setDocumento(clienteResumen.getDocumento());
		total.setNombre(clienteResumen.getNombre());
		
		Double totalServicio = 0.0;
		for(Servicios servicio : clienteResumen.getServicios()) {
			totalServicio += servicio.getPrecio();
		}
		
		total.setTotalServicios(totalServicio);
		total.setTotalAlojamiento(valorFechas(clienteResumen.getFechaIngreso(), clienteResumen.getFechaSalida()));
		total.setTotal(total.getTotalAlojamiento() + total.getTotalServicios());
		
		return total;
	}
	
	/**
	 * Conocer los dias de alojamiento y el valor de los dias
	 * @param fechaIngreso
	 * @param fechaSalida
	 * @return
	 */
	private Double valorFechas(Date fechaIngreso, Date fechaSalida) {
		
		// Contar los dias entre fechas
		long startTime = fechaIngreso.getTime();
	    long endTime = fechaSalida.getTime();
	    long diffTime = endTime - startTime;
	    long diffDays = diffTime / (1000 * 60 * 60 * 24);
	    int dias = (int)diffDays;
	    double diasValor = dias * 50000;
	    
		// Contar los fines de semana 
	    for(int i=0 ; i < 9 ; i++) {
	    	// corresponde al dia de la semana 0=domingo , 6=sabado
	    	if(fechaIngreso.getDay() == 0 || fechaIngreso.getDay() == 6 ) {
	    		diasValor += 30000; // suma la diferencia de los dias feriados faltantes
	    	}
	    	Calendar calendar = Calendar.getInstance();
	    	calendar.setTime(fechaIngreso);
	    	calendar.add(Calendar.DAY_OF_YEAR, dias);
	    	fechaIngreso = calendar.getTime();
	    }
		
		return diasValor;
	}

}
