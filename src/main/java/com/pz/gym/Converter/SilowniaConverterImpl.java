package com.pz.gym.Converter;

import com.pz.gym.Database.Silownia;
import com.pz.gym.Dto.SilowniaDto;

public class SilowniaConverterImpl implements SilowniaConverter {
    @Override
    public Silownia convertToEntity(SilowniaDto silowniaDto){
        return Silownia.builder()
                .nazwa(silowniaDto.getNazwa())
                ._idMiasto((silowniaDto.get_idMiasto()))
                .opis(silowniaDto.getOpis())
                .liczbasal(silowniaDto.getLiczbasal())
                .build();
    }

    @Override
    public SilowniaDto convertToDto(Silownia silownia){
        return SilowniaDto.builder()
                .nazwa(silownia.getNazwa())
                ._idMiasto(silownia.get_idMiasto())
                .opis(silownia.getOpis())
                .liczbasal(silownia.getLiczbasal())
                .build();
    }
}
