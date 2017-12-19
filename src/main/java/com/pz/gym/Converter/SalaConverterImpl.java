package com.pz.gym.Converter;

import com.pz.gym.Database.Sala;
import com.pz.gym.Dto.SalaDto;
import org.springframework.stereotype.Component;

@Component
public class SalaConverterImpl implements SalaConverter {
    @Override
    public Sala convertToEntity(SalaDto salaDto){
        return Sala.builder()
                .nazwa(salaDto.getNazwa())
                .opis(salaDto.getOpis())
                .idSilownia(salaDto.getIdSilownia())
                .build();
    }
    @Override
    public SalaDto convertToDto(Sala sala){

        return SalaDto.builder()
                .nazwa(sala.getNazwa())
                .opis(sala.getOpis())
                .idSilownia(sala.getIdSilownia())
                .build();
    }
}
