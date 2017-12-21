package com.pz.gym.Database;

import javafx.scene.control.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DBMenager {
    private static DBMenager ourInstance = new DBMenager();

    public static DBMenager getInstance(){
        return ourInstance;
    }

    private DBMenager(){

    }

    @Autowired
            SilowniaRepository silowniaRepository;


}
