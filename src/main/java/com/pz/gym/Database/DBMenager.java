package com.pz.gym.Database;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;


public class DBMenager {
    private static DBMenager ourInstance = new DBMenager();

    public static DBMenager getInstance(){
        return ourInstance;
    }

    private DBMenager(){
        
    }
    @Autowired
            SilowniaRepository silowniaRepository;

    ArrayList<String> gymNames = new ArrayList<String>();

    public ArrayList<String> getGymNames(){

        for(Silownia silownia : this.silowniaRepository.findAll()){
          gymNames.add(silownia.getNazwa());
        }


     return gymNames;

    }

}
