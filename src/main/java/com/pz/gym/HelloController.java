package com.pz.gym;

import com.pz.gym.Database.Test;
import javafx.fxml.FXML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloController {
    private Test test;

    @Autowired
    public HelloController(Test test){
        this.test = test;

    }
    @FXML
    public void handleButtonAction(){
        this.test.loadData();
        this.test.printTestData();

    }
}
