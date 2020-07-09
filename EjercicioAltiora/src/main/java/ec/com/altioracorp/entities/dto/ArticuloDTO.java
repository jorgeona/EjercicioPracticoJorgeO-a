package ec.com.altioracorp.entities.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class ArticuloDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
	@SequenceGenerator(name = "sequence", sequenceName = "ALT_SEQ_ARTICULO", allocationSize = 1)
	private long idarticulo;
	private String codigo;
	private String nombre;
	private Double precio;
	private Double cantidad;

	@OneToMany(mappedBy = "iddetalle")
	private List<DetalleCompraDTO> detallearticulo;

	public ArticuloDTO() {
	}

	public long getIdarticulo() {
		return idarticulo;
	}

	public void setIdarticulo(long idarticulo) {
		this.idarticulo = idarticulo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public List<DetalleCompraDTO> getDetallearticulo() {
		return detallearticulo;
	}

	public void setDetallearticulo(List<DetalleCompraDTO> detallearticulo) {
		this.detallearticulo = detallearticulo;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}
}
