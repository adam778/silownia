package com.pz.gym.Dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SilowniaDto {
    private  long id;
    private String nazwa;
    private long _idMiasto;
    private String opis;
    private int liczbasal;
}
