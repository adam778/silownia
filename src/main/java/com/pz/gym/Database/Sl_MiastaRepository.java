package com.pz.gym.Database;

import org.springframework.data.repository.CrudRepository;

public interface Sl_MiastaRepository extends CrudRepository<Sl_Miasta, Long> {
    Sl_Miasta findSl_MiastaByNazwa(String nazwa);

}
