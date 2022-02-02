package com.prueba.banco.popular;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.prueba.banco.popular.entity.Acompanantes;
import com.prueba.banco.popular.entity.Cliente;
import com.prueba.banco.popular.entity.Servicios;
import com.prueba.banco.popular.repository.ClienteRepository;
import com.prueba.banco.popular.service.ClienteService;

@SpringBootTest
class PruebaPopularApplicationTests {
	
	@InjectMocks
	private ClienteService clienteService;
	
	@Mock
	private ClienteRepository clienteRepository;
	
	private List<Cliente> cliente;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		
		cliente = new ArrayList<>();
	}
	
	@After
	public void tearDown() {
		MockitoAnnotations.initMocks(this);
		
		cliente = null;
		
	}

	@Test
	void ingresoAcompanantesTest() {
		cliente = new ArrayList<>();
		cliente.add(objetoCliente());
		Mockito.when(clienteRepository.findAll()).thenReturn(cliente);
		
		assertNotNull(clienteService.ingresoAcompanates());
	}
	
	@Test
	void serviciosConsumidosTest() {
		cliente = new ArrayList<>();
		cliente.add(objetoCliente());
		Mockito.when(clienteRepository.findAll()).thenReturn(cliente);
		
		assertNotNull(clienteService.serviciosConsumidos());
	}
	
	@Test
	void serviciosConsumidosTodoIncluidoTest() {
		
		Cliente clienteT = objetoCliente();
		clienteT.getServicios().add(objetoServicios());
		
		cliente = new ArrayList<>();
		cliente.add(clienteT);
		Mockito.when(clienteRepository.findAll()).thenReturn(cliente);
		
		assertNotNull(clienteService.serviciosConsumidos());
	}
	
	@Test
	void valorTotalTest() {
		Integer documento = 123546;
		
		Cliente clienteT = objetoCliente();
		clienteT.setFechaIngreso(new Date(120, 1, 1, 1, 1));
		clienteT.setFechaSalida(new Date(120, 2, 1, 1, 1));
		
		Mockito.when(clienteRepository.findByDocumento(documento)).thenReturn(clienteT);
		
		assertNotNull(clienteService.valorTotal(documento));
	}
	
	Servicios objetoServicios() {
		Servicios objeto = new Servicios();
		objeto.setId(1);
		objeto.setDescripcion("Plan Todo incluido");
		objeto.setPrecio(90000.0);
		return objeto;
	}
	
	Cliente objetoCliente() {
		Cliente objeto = new Cliente();
		objeto.setDocumento(123546);
		objeto.setNombre("Edilson");
		objeto.setId(1);
		objeto.setAcompanantes(new ArrayList<>());
		objeto.getAcompanantes().add(new Acompanantes(1, 123, "Luz"));
		objeto.setServicios(new ArrayList<>());
		objeto.getServicios().add(new Servicios(1, "Restaurante", 30000.0));
		return objeto;
	}

}
