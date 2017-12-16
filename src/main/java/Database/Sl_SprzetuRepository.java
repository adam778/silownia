package Database;

import org.springframework.data.repository.CrudRepository;

public interface Sl_SprzetuRepository extends CrudRepository<Sl_Sprzetu, Long> {
    Sl_Sprzetu findSl_SprzetuByNazwasprzetu(String nazwa);
}
