/**
 * 
 */
package ec.com.altioracorp.service;

import java.util.List;

import ec.com.altioracorp.entities.dto.ClienteDTO;

/**
 * @author JAGGER-PC
 *
 */
public interface IClienteServicio {

	List<ClienteDTO> obtenerClientes();
	
}
