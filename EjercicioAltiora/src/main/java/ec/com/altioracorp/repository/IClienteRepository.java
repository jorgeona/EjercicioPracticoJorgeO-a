package ec.com.altioracorp.repository;

//import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ec.com.altioracorp.entities.dto.ClienteDTO;


@Repository
public interface IClienteRepository extends CrudRepository<ClienteDTO, Long> {

	//List<Cliente> findBy<"C"liente_nombre>And<AttributeName>(String cliente_nombre);

}