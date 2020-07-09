package ec.com.altioracorp.sales.system.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ec.com.altioracorp.EjercicioAltioraApplication;
import ec.com.altioracorp.entities.dto.ArticuloDTO;
import ec.com.altioracorp.entities.dto.DetalleCompraDTO;
import ec.com.altioracorp.entities.dto.ClienteDTO;
import ec.com.altioracorp.entities.dto.OrdenDTO;
import ec.com.altioracorp.repository.IArticuloRepository;
import ec.com.altioracorp.service.IClienteServicio;
import ec.com.altioracorp.service.impl.OrdenCompraServicio;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EjercicioAltioraApplication.class)
public class TestServices {
	
	private final Log LOGGER = LogFactory.getLog(TestServices.class);
	
	@Autowired
	private IClienteServicio clienteService;
//	@Autowired
//	private OrdenCrud orderService;
	@Autowired
	private IArticuloRepository itemService;
	@Autowired
	private OrdenCompraServicio orderCompraService;
	
	@Test
	@Ignore
	public void findAllClientsTest() {
		List<ClienteDTO> clientListResult = clienteService.obtenerClientes();
		for (ClienteDTO cliente : clientListResult) {
			LOGGER.info(String.format("Client id: %s, name: %s", cliente.getIdcliente(), cliente.getNombre()));
		}
		
	}
	
	@Test
//	@Ignore
	public void testSalesOrder() {
		List<ArticuloDTO> articulos = (List<ArticuloDTO>) itemService.findAll();
		//Colas * 5
		DetalleCompraDTO articuloOrden = new DetalleCompraDTO();
		//articulos.get(1) ==>>> Articulo Selecionado por el cliente
		articuloOrden.setArticulo(articulos.get(1)); //Cola id
//		articuloOrden.setCantidad(..) 5
//		articuloOrden.setPrecioUnitario(articulos.get(1).getPrecioUnitario()) $2.00
//		articuloOrden.setTotal(articuloOrden.getPrecioUnitario().multiply(articuloOrden.getCantidad())) cantidad * precio unitario
		
		//huevos * 2
		DetalleCompraDTO articuloOrden1 = new DetalleCompraDTO();
		articuloOrden1.setArticulo(articulos.get(0)); //Cola id
//		articuloOrden.setCantidad(..) 5
//		articuloOrden.setPrecioUnitario(..) $2.00
//		articuloOrden.setTotal(articuloOrden.getPrecioUnitario().multiply(articuloOrden.getCantidad())) cantidad * precio unitario
		Set<DetalleCompraDTO> articulOrden = new HashSet<>();// Set == List
		articulOrden.add(articuloOrden);// colas
		articulOrden.add(articuloOrden1);// huevos
		
		List<ClienteDTO> clientListResult = clienteService.obtenerClientes();

		List<OrdenDTO> ordenesActuales = (List<OrdenDTO>) orderCompraService.obtenerTodos();
		LOGGER.info(String.format("Cantidad de ordenes: %s", ordenesActuales.size()));
		
		OrdenDTO orden = new OrdenDTO("test", "test", clientListResult.get(0), articulOrden);
		orderCompraService.guardarOrdenCompra(orden);
		List<OrdenDTO> ordenes = (List<OrdenDTO>) orderCompraService.obtenerTodos();
		LOGGER.info(String.format("Cantidad de ordenes: %s", ordenes.size()));
		LOGGER.info(String.format("OrdenId: %s", ordenes.get(0).getIdorden()));
		LOGGER.info(String.format("OrdenArticuloId: %s", orderCompraService.buscarDetallesPorOrdenCompra(orden).get(0).getArticulo().getNombre()));
		
	}

}
