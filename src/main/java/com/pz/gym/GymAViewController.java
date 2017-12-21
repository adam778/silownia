package com.pz.gym;

import com.pz.gym.Database.Silownia;
import com.pz.gym.Database.SilowniaRepository;
import de.felixroske.jfxsupport.FXMLController;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

@FXMLController
public class GymAViewController {



    private SilowniaRepository silowniaRepository;


    GymAViewController(SilowniaRepository silowniaRepository){

        this.silowniaRepository= silowniaRepository;

    }
    @FXML
    private MenuButton menuButton;
    @FXML
    private MenuItem menuItem = new MenuItem("test");

    @FXML
    private TextField nazwaField;
    @FXML
    private TextField miastoField;
    @FXML
    private TextField liczbasalField;
    @FXML
    private TextArea opisField;

    private ArrayList<MenuItem> menuItems = new ArrayList<>();



    public void onmouseclicked(MouseEvent mouseEvent) {
        for(Silownia silownia : this.silowniaRepository.findAll()){
            menuItems.add( menuItem = new MenuItem(silownia.getNazwa()));

        }
        menuButton.getItems().addAll(menuItems);
        nazwaField.setText(silowniaRepository.findSilowniaByNazwa("SilowniaFit").getNazwa());
       miastoField.setText(Long.toString(silowniaRepository.findSilowniaByNazwa("SilowniaFit").get_idMiasto()));
        liczbasalField.setText(Integer.toString(silowniaRepository.findSilowniaByNazwa("SilowniaFit").getLiczbasal()));
      opisField.setText(silowniaRepository.findSilowniaByNazwa("SilowniaFit").getOpis());


    }

    public void onmouseclicked1(MouseEvent mouseEvent) {



    }
}
