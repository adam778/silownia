package Database;

import org.springframework.data.repository.CrudRepository;

public interface SalaRepository  extends CrudRepository<Sala, Long>{
    Sala findSalaByNazwa(String nazwa);


}
