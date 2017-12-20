package com.pz.gym;

import com.pz.gym.Database.DBMenager;
import com.pz.gym.Dto.SilowniaDto;
import de.felixroske.jfxsupport.FXMLController;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;

@FXMLController
public class GymViewController {
   @FXML
    private MenuItem menuItem = new MenuItem("test");
   @FXML
   private MenuButton menuButton;



    public void onmouseclicked(MouseEvent mouseEvent) {

        menuButton.getItems().addAll(menuItem);

    }

    public void oncontextmenurequested(ContextMenuEvent contextMenuEvent) {
        menuButton.getItems().addAll(menuItem);
    }
}
