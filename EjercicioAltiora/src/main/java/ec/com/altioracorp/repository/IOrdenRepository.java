package ec.com.altioracorp.repository;

//import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ec.com.altioracorp.entities.dto.OrdenDTO;


@Repository
public interface IOrdenRepository extends CrudRepository<OrdenDTO, Long> {

}