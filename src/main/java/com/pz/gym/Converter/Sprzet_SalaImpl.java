package com.pz.gym.Converter;

import com.pz.gym.Database.Sprzet_Sala;
import com.pz.gym.Dto.Sprzet_SalaDto;
import org.springframework.stereotype.Component;

@Component
public class Sprzet_SalaImpl implements Sprzet_SalaConverter {
    @Override
    public Sprzet_Sala convertToEntity(Sprzet_SalaDto sprzet_salaDto){

        return Sprzet_Sala.builder()
                .idSala(sprzet_salaDto.getIdSala())
                .idSprzet(sprzet_salaDto.getIdSprzet())
                .build();
    }

    @Override
    public Sprzet_SalaDto convertToDto(Sprzet_Sala sprzet_sala) {
        return Sprzet_SalaDto.builder()
                .idSala((sprzet_sala.getIdSala()))
                .idSprzet(sprzet_sala.getIdSala())
                .build();
    }
}
