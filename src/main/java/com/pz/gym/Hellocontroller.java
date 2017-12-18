package com.pz.gym;

import Database.Test;
import javafx.fxml.FXML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Hellocontroller {
    private Test test;

    @Autowired
    public Hellocontroller(Test test){
        this.test = test;

    }
    @FXML
    public void handleButtonAction(){
        this.test.loadData();
        this.test.printTestData();

    }
}
