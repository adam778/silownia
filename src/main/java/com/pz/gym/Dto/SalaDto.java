package com.pz.gym.Dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SalaDto {

    private long id;
    private String nazwa;
    private String opis;
    private long idSilownia;

}
