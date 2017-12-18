package com.pz.gym.Database;

import org.springframework.data.repository.CrudRepository;

public interface SilowniaRepository extends CrudRepository<Silownia, Long> {
    Silownia findSilowniaByNazwa(String nazwa);
}
