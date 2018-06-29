package com.pz.gym;

import com.pz.gym.Database.DBMenager;
import com.pz.gym.Database.Silownia;
import com.pz.gym.Database.SilowniaRepository;
import com.pz.gym.Exceptions.EmptyFieldException;
import com.pz.gym.Exceptions.NotGymChoseException;
import com.pz.gym.Exceptions.NotNumberException;
import com.pz.gym.Exceptions.WrongMiastoException;
import de.felixroske.jfxsupport.FXMLController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.logging.Logger;

@FXMLController
public class GymDetailsscreenViewController {

    @Autowired
    private DBMenager dbMenager = DBMenager.getInstance();

    private ObservableList<String> gyms = FXCollections.observableArrayList();

    private String urlMap;

    private SilowniaRepository silowniaRepository;


    @FXML
    private TextArea textarea_gymname;

    @FXML
    private ListView list_gymlist;

    @FXML
    private TextArea textarea_gymequipment;

    @FXML
    private TextArea textarea_gymaddres;

    @FXML
    private ImageView imageview_gymmap;

    @FXML
    private TextArea textarea_gymroomsnr;

    @FXML
    private Button button_gymadd;

    @FXML
    private Button button_gymedit;

    @FXML
    private Button button_gymsave;

    @FXML
    private Button button_gymdelete;




    private final static Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);


    @Autowired
    public GymDetailsscreenView gymDetailsscreenView(SilowniaRepository silowniaRepository) {


        this.silowniaRepository = silowniaRepository;

        return null;
    }

    private String gym;

    @FXML
    public void loadgym() {

        list_gymlist.setItems(null);
        gyms = dbMenager.loadgyms();
        list_gymlist.setItems(gyms);
        log.info("załadowano siłownie");


    }

    @FXML
    public void selectGym() {

         gym = list_gymlist.getSelectionModel().getSelectedItem().toString();
           textarea_gymaddres.setText(dbMenager.getMiasto(gym));
        System.out.println(dbMenager.getMiasto(gym));
        textarea_gymname.setText(dbMenager.getNazwaSilowni(gym));
        textarea_gymroomsnr.setText(dbMenager.getliczbaSal(gym));
        textarea_gymequipment.setText(dbMenager.getOpis(gym));
        Image map = new Image(dbMenager.getMap(gym));
        imageview_gymmap.setImage(map);
        log.info("Wybrano siłownie");

    }

    @FXML
    public void addgym() {
        GymApplication.showView(GymAddscreenView.class);
        textarea_gymequipment.clear();
        textarea_gymroomsnr.clear();
        textarea_gymname.clear();
        textarea_gymaddres.clear();
        list_gymlist.setItems(null);
        imageview_gymmap.setImage(null);

    }

    @FXML
    public void editgym() throws NotGymChoseException{


        try{
           list_gymlist.getSelectionModel().getSelectedItem().toString();

            textarea_gymname.setEditable(true);
            textarea_gymaddres.setEditable(true);
            textarea_gymroomsnr.setEditable(true);
            textarea_gymequipment.setEditable(true);
            button_gymsave.setVisible(true);
            list_gymlist.setItems(null);
            gyms = dbMenager.loadgyms();
            list_gymlist.setItems(gyms);
        }
        catch (NullPointerException ex) {
            try {
                throw new NotGymChoseException();

            }

                catch(NotGymChoseException e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Błedny wybór");
                alert.setHeaderText("Wybierz Siłownie");
                alert.show();
                log.severe("nie wybrano silowni");

            }

        }




    }


    @FXML
    public void savegym() throws EmptyFieldException, NotNumberException, WrongMiastoException {

        try{
            if (gym.isEmpty()||textarea_gymequipment.getText().isEmpty()||textarea_gymname.getText().isEmpty()||textarea_gymaddres.getText().isEmpty()||textarea_gymroomsnr.getText().isEmpty()){
                throw new EmptyFieldException();
            }
            if (!dbMenager.getAllMiasta().contains(textarea_gymaddres.getText())) throw new WrongMiastoException();

            if (textarea_gymroomsnr.getText().matches("[0-9]*")){

                    dbMenager.editGym(gym, textarea_gymname.getText(), textarea_gymaddres.getText(), textarea_gymequipment.getText(), Integer.parseInt(textarea_gymroomsnr.getText()));
                    list_gymlist.setItems(null);
                    gyms = dbMenager.loadgyms();
                    list_gymlist.setItems(gyms);
                    button_gymsave.setVisible(false);
                textarea_gymname.setEditable(false);
                textarea_gymaddres.setEditable(false);
                textarea_gymroomsnr.setEditable(false);
                textarea_gymequipment.setEditable(false);
                button_gymsave.setVisible(false);
                log.info("Dodano siłownie");

            }
            else throw new NotNumberException();

        }
        catch (EmptyFieldException ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Puste pola");
            alert.setHeaderText("Uzupełnij puste pola");
            alert.show();
            log.severe("Puste pola");
        }
        catch (NotNumberException ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd danych");
            alert.setHeaderText("W polu liczba sal nie znajduje się liczba");
            alert.show();
            textarea_gymroomsnr.clear();
            log.severe("Wpole liczba sal nie wpisano liczby");

        }
        catch (WrongMiastoException ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd danych");
            alert.setHeaderText("Zła nazwa miasta" );
            alert.show();
            log.severe("Wprowadzono złą nazwe miasta");

        }



    }

    @FXML
    public void deletegym(){
      dbMenager.deleteGym(list_gymlist.getSelectionModel().getSelectedItem().toString());
      list_gymlist.setItems(null);
        gyms = dbMenager.loadgyms();
        list_gymlist.setItems(gyms);
        textarea_gymequipment.clear();
        textarea_gymroomsnr.clear();
        textarea_gymname.clear();
        textarea_gymaddres.clear();
        list_gymlist.setItems(null);
        imageview_gymmap.setImage(null);
        log.severe("Usunieto siłownie");

    }
    @FXML
    public void logout(){
        textarea_gymequipment.clear();
        textarea_gymroomsnr.clear();
        textarea_gymname.clear();
        textarea_gymaddres.clear();
        list_gymlist.setItems(null);
        imageview_gymmap.setImage(null);
        GymApplication.showView(GymMainscreenView.class);
        log.info("Pomyslnie wylogowano uzytkownika");

    }

}
