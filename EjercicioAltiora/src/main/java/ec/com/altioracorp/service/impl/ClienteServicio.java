/**
 * 
 */
package ec.com.altioracorp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.com.altioracorp.entities.dto.ClienteDTO;
import ec.com.altioracorp.repository.IClienteRepository;
import ec.com.altioracorp.service.IClienteServicio;

/**
 * @author JAGGER-PC
 *
 */

@Service
public class ClienteServicio implements IClienteServicio {
	@Autowired
	private IClienteRepository clienteCrud;
	

	@Override
	public List<ClienteDTO> obtenerClientes() {
		
		return (List<ClienteDTO>) clienteCrud.findAll();
	}	

}
