package Database;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaRepository  extends CrudRepository<Sala, Long>{
    Sala findSalaByNazwa(String nazwa);


}
