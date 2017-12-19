package com.pz.gym.Converter;

import com.pz.gym.Database.Sl_Sprzetu;
import com.pz.gym.Dto.Sl_SprzetuDto;
import org.springframework.stereotype.Component;

@Component
public class Sl_SprzetuConverterImpl implements Sl_SprzetuConverter {
    @Override
    public Sl_Sprzetu convertToEntity(Sl_SprzetuDto sl_sprzetuDto){
        return Sl_Sprzetu.builder()
                .nazwasprzetu(sl_sprzetuDto.getNazwasprzetu())
                .build();
    }

    @Override
    public Sl_SprzetuDto convertToDto(Sl_Sprzetu sl_sprzetu) {
        return Sl_SprzetuDto.builder()
                .nazwasprzetu((sl_sprzetu.getNazwasprzetu()))
                .build();
    }
}
