package com.pz.gym;

import com.pz.gym.Database.DBMenager;
import com.pz.gym.Exceptions.EmptyFieldException;
import com.pz.gym.Exceptions.NotNumberException;
import de.felixroske.jfxsupport.FXMLController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.logging.Logger;

@FXMLController
public class GymAddscreenViewController {

    private GymDetailsscreenView gymDetailsscreenView;
    @FXML
    private TextField textfield_gymname;

    @FXML
    private ListView list_gymaddres;

    @FXML
    private TextField textfield_gymroomsnr;

    @FXML
    private TextArea textarea_gymequipment;

    @FXML
    private TextField textfield_gymmapurl;


    @Autowired
    private DBMenager dbMenager = DBMenager.getInstance();

    private ObservableList<String> miasta = FXCollections.observableArrayList();

    private final static Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);


    @FXML
    public void gymadd(){
        try {

            if (textfield_gymname.getText().isEmpty()||textarea_gymequipment.getText().isEmpty()||textfield_gymroomsnr.getText().isEmpty()||textfield_gymmapurl.getText().isEmpty())
            {
                throw new EmptyFieldException();
            }
            if (textfield_gymroomsnr.getText().matches("[0-9]*"))
            {
                dbMenager.saveGym(textfield_gymname.getText(), list_gymaddres.getSelectionModel().getSelectedItem().toString(), textarea_gymequipment.getText(), Integer.parseInt(textfield_gymroomsnr.getText()),textfield_gymmapurl.getText());
                System.out.println(textfield_gymmapurl.getText());
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Sukces");
                alert.setHeaderText("Silownia dodana");
                alert.show();
                textfield_gymroomsnr.clear();
                textarea_gymequipment.clear();
                textfield_gymname.clear();
                goback();
                log.info("Silownie dodano");
            }else {

                textfield_gymroomsnr.clear();
                throw new NotNumberException();
            }
        }
        catch (EmptyFieldException ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Puste pola");
            alert.setHeaderText("Uzupełnij puste pola");
            alert.show();
            log.severe("Wystapily puste pola");
        }
        catch (NotNumberException ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd danych");
            alert.setHeaderText("W polu liczba sal nie znajduje się liczba");
            alert.show();
            textfield_gymroomsnr.clear();
            log.severe("W polu liczba sali nie znajduje się liczba");
        }
    }

    @FXML
    public void clearall(){
        textfield_gymname.clear();
        textarea_gymequipment.clear();
        textfield_gymroomsnr.clear();
        list_gymaddres.refresh();
        list_gymaddres.setItems(dbMenager.getAllMiasta());
    }

    @FXML
    public void goback(){

        GymApplication.showView(GymDetailsscreenView.class);
        textfield_gymname.clear();
        textarea_gymequipment.clear();
        textfield_gymroomsnr.clear();
        list_gymaddres.refresh();
        list_gymaddres.setItems(null);
    }
    @FXML
    public void loadgymaddres (){

        list_gymaddres.setItems(null);
        miasta = dbMenager.getAllMiasta();
        list_gymaddres.setItems(miasta);
        log.info("Załadowano miasta");

    }


}
