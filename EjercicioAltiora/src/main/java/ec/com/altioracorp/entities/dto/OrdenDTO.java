package ec.com.altioracorp.entities.dto;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class OrdenDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
	@SequenceGenerator(name = "sequence", sequenceName = "ALT_SEQ_ORDEN", allocationSize = 1)
	private long idorden;
	private String fecha;

	@ManyToOne
	@JoinColumn(name = "idcliente")
	private ClienteDTO cliente;

	@OneToMany(mappedBy = "orden", fetch = FetchType.LAZY)
	private Set<DetalleCompraDTO> detalleorden = new HashSet<>();

	public OrdenDTO() {
	}

	public OrdenDTO(String fecha, String articulos, ClienteDTO cliente, Set<DetalleCompraDTO> detalleorden) {
		super();
		this.fecha = fecha;

		this.cliente = cliente;
		this.addItems(detalleorden);
	}

	private void addItems(Set<DetalleCompraDTO> items) {
		this.detalleorden.clear();
		for (DetalleCompraDTO item : items) {
			item.setOrden(this);
			this.detalleorden.add(item);
		}
	}

	public long getIdorden() {
		return idorden;
	}

	public void setIdorden(long idorden) {
		this.idorden = idorden;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	public Set<DetalleCompraDTO> getDetalleorden() {
		return detalleorden;
	}

	public void setDetalleorden(Set<DetalleCompraDTO> detalleorden) {
		this.detalleorden = detalleorden;
	}

}
