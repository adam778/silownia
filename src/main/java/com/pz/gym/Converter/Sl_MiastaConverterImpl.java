package com.pz.gym.Converter;

import com.pz.gym.Database.Sl_Miasta;
import com.pz.gym.Dto.Sl_MiastaDto;
import org.springframework.stereotype.Component;

@Component
public class Sl_MiastaConverterImpl implements Sl_MiastaConverter {
    @Override
    public Sl_Miasta convertToEntity(Sl_MiastaDto sl_miastaDto){

        return Sl_Miasta.builder()
                .nazwa(sl_miastaDto.getNazwa())
                .build();
    }

    public Sl_MiastaDto convertToDto(Sl_Miasta sl_miasta){

        return Sl_MiastaDto.builder()
                .nazwa(sl_miasta.getNazwa())
                .build();
    }


}
