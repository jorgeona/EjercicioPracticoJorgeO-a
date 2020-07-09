/**
 * 
 */
package ec.com.altioracorp.service;

import java.util.List;

import ec.com.altioracorp.entities.dto.DetalleCompraDTO;
import ec.com.altioracorp.entities.dto.OrdenDTO;

/**
 * @author JAGGER-PC
 *
 */
public interface IOrdenCompraServicio {
	
	/**
	 * Servicio encargado de persistir en base de datos entidad de tipo OrdenDTO.
	 * @param ordenDto Objeto de tipo OrdenDTO.
	 */
	void guardarOrdenCompra(OrdenDTO ordenDto);
	
	/**
	 * Servicio encargado de obtener todos las ordenes de compra
	 * @return Listado de objetos de tipo OrdenDTO.
	 */
	List<OrdenDTO> obtenerTodos();
	
	List<DetalleCompraDTO> buscarDetallesPorOrdenCompra(OrdenDTO ordenDto);

}
