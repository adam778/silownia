package com.pz.gym.Database;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Sprzet_Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long idSala;
    private long idSprzet;

}
