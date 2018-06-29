package com.pz.gym;


import com.google.common.hash.Hashing;
import com.pz.gym.Database.Test;
import com.pz.gym.Exceptions.WrongPasswordorUserException;
import de.felixroske.jfxsupport.FXMLController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.logging.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;


@FXMLController

public class GymMainscreenViewController {
    private Test test;


    @Autowired
    private GymMainscreenView gymMainscreenView;

    @Autowired
    private  GymDetailsscreenView gymDetailsscreenView;

    @Autowired
    private GymAddscreenView gymAddscreenView;

    @Autowired
    public GymMainscreenViewController(Test test){
            this.test = test;

    }
    private final static Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);


    @FXML
    private TextField textfield_login;

    @FXML
    private PasswordField passwordfield_haslo;

    @FXML
    private Label label_yahoo;




    private String login ="4194d1706ed1f408d5e02d672777019f4d5385c766a8c6ca8acba3167d36a7b9";
    private String haslo ="4194d1706ed1f408d5e02d672777019f4d5385c766a8c6ca8acba3167d36a7b9";


    private String hlogin;
    private String hhaslo;

    @FXML
    public void logintoapp() {
        hhaslo = Hashing.sha256().hashString(passwordfield_haslo.getText(), StandardCharsets.UTF_8).toString();

        hlogin = Hashing.sha256().hashString(textfield_login.getText(), StandardCharsets.UTF_8).toString();

        try {
            verifyuser(hhaslo, hlogin);
        }
        catch (WrongPasswordorUserException e){

                System.out.println(1);
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Błedny login lub hasło");
           alert.setHeaderText("Wprowadź poprawne dane");
           alert.show();
           log.severe("Wprowadzono złe dane do logowania");


        }
    }


    public void verifyuser(String hhaslo, String hlogin) throws  WrongPasswordorUserException {

        if (hlogin.equals(login) && (hhaslo.equals(haslo)))
        {
            this.test.loadData();
            this.test.printTestData();

            textfield_login.clear();
            passwordfield_haslo.clear();

            GymApplication.showView(GymDetailsscreenView.class);
            log.info("Pomyślnie zalogowano użytkownika");

        }
       else throw new WrongPasswordorUserException();

    }


    @FXML
    public void changestylered () {
        String skorka = "";
        try {
            skorka = Paths.get("src/main/resources/com/pz/gym/red.css").toUri().toURL().toExternalForm();
        } catch (MalformedURLException e) {

        }
        gymMainscreenView.getView().getStylesheets().clear();
        gymMainscreenView.getView().getStylesheets().add(skorka);
        gymDetailsscreenView.getView().getStylesheets().clear();
        gymDetailsscreenView.getView().getStylesheets().add(skorka);
        gymAddscreenView.getView().getStylesheets().clear();
        gymAddscreenView.getView().getStylesheets().add(skorka);
        try {
            time_from_yahoo();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

    };
    @FXML
    public void changestyleyellow (){
        String skorka = "";
        try {
            skorka = Paths.get("src/main/resources/com/pz/gym/yellow.css").toUri().toURL().toExternalForm();
        } catch (MalformedURLException e) {

        }
        gymMainscreenView.getView().getStylesheets().clear();
        gymMainscreenView.getView().getStylesheets().add(skorka);
        gymDetailsscreenView.getView().getStylesheets().clear();
        gymDetailsscreenView.getView().getStylesheets().add(skorka);
        gymAddscreenView.getView().getStylesheets().clear();
        gymAddscreenView.getView().getStylesheets().add(skorka);

    }
    @FXML
    public void changestylegreen (){
        String skorka = "";
        try {
           skorka = Paths.get("src/main/resources/com/pz/gym/green.css").toUri().toURL().toExternalForm();
        } catch (MalformedURLException e) {

        }
        gymMainscreenView.getView().getStylesheets().clear();
        gymMainscreenView.getView().getStylesheets().add(skorka);
        gymDetailsscreenView.getView().getStylesheets().clear();
        gymDetailsscreenView.getView().getStylesheets().add(skorka);
        gymAddscreenView.getView().getStylesheets().clear();
        gymAddscreenView.getView().getStylesheets().add(skorka);


    }
    private void time_from_yahoo() throws ParserConfigurationException, SAXException {
        String url = "https://query.yahooapis.com/v1/public/yql?q=select%20item.condition%20from%20weather.forecast%20where%20woeid%20%3D%20523920&format=xml&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder db =  documentBuilderFactory.newDocumentBuilder();
        Document doc = null;
        try {
            doc = db.parse(url);
        } catch (IOException e) {
            log.severe("Zapytanie Yahoo nie działa" + e);
        }
        NodeList meteo = doc.getElementsByTagName("yweather:condition");
        label_yahoo.setText( meteo.item(0)
                .getAttributes().getNamedItem("date").getNodeValue()+ ", " + meteo.item(0)
                .getAttributes().getNamedItem("temp").getNodeValue() +"F");

    }






}
