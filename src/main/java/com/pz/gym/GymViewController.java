package com.pz.gym;


import com.pz.gym.Database.SilowniaRepository;
import com.pz.gym.Database.Test;
import de.felixroske.jfxsupport.FXMLController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.factory.annotation.Autowired;

@FXMLController
public class GymViewController {
    private SilowniaRepository silowniaRepository;
    private Test test;

    @FXML
    MenuItem menuItem = new MenuItem("test");
    @FXML
    MenuButton menuButton;
    @FXML
    Button button;

    @Autowired
    public GymViewController(SilowniaRepository silowniaRepository, Test test){

        this.silowniaRepository = silowniaRepository;
   //    this.test = test;

    }

    public void onmouseclicked(MouseEvent mouseEvent) {

        System.out.println(this.silowniaRepository.findSilowniaByNazwa("SilowniaFit").getLiczbasal());

        button.setText(this.silowniaRepository.findSilowniaByNazwa("SilowniaFit").getOpis());

    }

   public void oncontextmenurequested(ContextMenuEvent contextMenuEvent) {

  }
}
