package ec.com.altioracorp.entities.dto;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class ClienteDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
	@SequenceGenerator(name = "sequence", sequenceName = "ALT_SEQ_CLIENTE", allocationSize = 1)
	private long idcliente;
	private String nombre;
	private String apellido;

	@OneToMany(mappedBy = "idorden")
	private Set<OrdenDTO> ordenes;

	public Set<OrdenDTO> getOrdenes() {
		return ordenes;
	}

	public void setOrdenes(Set<OrdenDTO> ordenes) {
		this.ordenes = ordenes;
	}

	public long getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(long idcliente) {
		this.idcliente = idcliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

}
