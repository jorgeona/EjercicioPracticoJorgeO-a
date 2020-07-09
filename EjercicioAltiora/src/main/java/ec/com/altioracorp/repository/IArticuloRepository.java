package ec.com.altioracorp.repository;

//import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ec.com.altioracorp.entities.dto.ArticuloDTO;


@Repository
public interface IArticuloRepository extends CrudRepository<ArticuloDTO, Long> {

	//List<Articulo> FindByName(String articulo_codigo);

}