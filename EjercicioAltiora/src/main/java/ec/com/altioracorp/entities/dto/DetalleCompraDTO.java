package ec.com.altioracorp.entities.dto;

//import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class DetalleCompraDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
	@SequenceGenerator(name = "sequence", sequenceName = "ALT_SEQ_DETALLE_COMPRA", allocationSize = 1)
	private long iddetalle;
	// cantidad

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idarticulo")
	private ArticuloDTO articulo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idorden")
	private OrdenDTO orden;

	public DetalleCompraDTO() {
	}

	public long getIddetalle() {
		return iddetalle;
	}

	public void setIddetalle(long iddetalle) {
		this.iddetalle = iddetalle;
	}

	public ArticuloDTO getArticulo() {
		return articulo;
	}

	public void setArticulo(ArticuloDTO articulo) {
		this.articulo = articulo;
	}

	public OrdenDTO getOrden() {
		return orden;
	}

	public void setOrden(OrdenDTO orden) {
		this.orden = orden;
	}

}
