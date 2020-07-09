/**
 * 
 */
package ec.com.altioracorp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ec.com.altioracorp.entities.dto.DetalleCompraDTO;
import ec.com.altioracorp.entities.dto.OrdenDTO;
import ec.com.altioracorp.repository.IDetalleCompraRepository;
import ec.com.altioracorp.repository.IOrdenRepository;
import ec.com.altioracorp.service.IOrdenCompraServicio;

/**
 * @author JAGGER-PC
 *
 */
@Service
@Transactional(readOnly = true)
public class OrdenCompraServicio implements IOrdenCompraServicio {

	@Autowired
	private IOrdenRepository ordenRepositorio;
	@Autowired
	private IDetalleCompraRepository detalleCompraRepository;

	@Override
	@Transactional(readOnly = false)
	public void guardarOrdenCompra(OrdenDTO ordenDto) {
		ordenRepositorio.save(ordenDto);
		for (DetalleCompraDTO detalle : ordenDto.getDetalleorden()) {
			detalle.setOrden(ordenDto);
			detalleCompraRepository.save(detalle);
		}
	}

	@Override
	public List<OrdenDTO> obtenerTodos() {
		return (List<OrdenDTO>) ordenRepositorio.findAll();
	}

	@Override
	public List<DetalleCompraDTO> buscarDetallesPorOrdenCompra(OrdenDTO ordenDto) {
		return detalleCompraRepository.findByOrden(ordenDto);
	}

}
