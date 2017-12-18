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

public class Sl_Sprzetu {
@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nazwasprzetu;

    public Sl_Sprzetu(String nazwasprzetu){
        this.nazwasprzetu = nazwasprzetu;
    }

    public Sl_Sprzetu(){};

    public long getId(){
        return id;
    }

}
