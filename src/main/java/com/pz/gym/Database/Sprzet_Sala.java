package com.pz.gym.Database;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
//@Builder
public class Sprzet_Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long idSala;
    private long idSprzet;

    public Sprzet_Sala(long idSala, long idSprzet){
        this.idSala = idSala;
        this.idSprzet = idSprzet;
    }

    public long getId(){
        return id;
    }
    public Sprzet_Sala(){}

}
