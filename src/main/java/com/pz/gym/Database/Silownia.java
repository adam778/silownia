package com.pz.gym.Database;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Setter
@Getter
//@Builder

public class Silownia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nazwa;
    private long _idMiasto;
    private String opis;
    private int liczbasal;

   public Silownia (String nazwa, long idMiasto, String opis, int liczbasal){
        this.nazwa = nazwa;
        this._idMiasto = idMiasto;
        this.opis = opis;
        this.liczbasal = liczbasal;
    }

    public long getId(){
        return id;
    }
   public Silownia(){}


}
