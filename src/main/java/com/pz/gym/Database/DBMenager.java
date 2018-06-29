package com.pz.gym.Database;

import com.sun.istack.internal.NotNull;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.MenuItem;
import lombok.NonNull;
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

    @Autowired
    Sl_MiastaRepository sl_miastaRepository;


    public ObservableList<String> loadgyms(){

        ObservableList<String> gyms = FXCollections.observableArrayList();
        for(Silownia silownia: this.silowniaRepository.findAll()){
            gyms.add(silownia.getNazwa());
        }


        return gyms;
    }

    public ObservableList<String> getAllMiasta(){

        ObservableList<String> allMiasta = FXCollections.observableArrayList();
        for(Sl_Miasta sl_miasta : this.sl_miastaRepository.findAll()){
            allMiasta.add(sl_miasta.getNazwa());
        }

    return allMiasta;
    }
    public  String getMiasto(String gym){
        try {


            long id = silowniaRepository.findSilowniaByNazwa(gym).get_idMiasto();
            String miasto = this.sl_miastaRepository.findSl_MiastaById(id).getNazwa();
            return miasto;
        }
        catch (NullPointerException e)
        {
            return null;
        }

    }

    public String getNazwaSilowni(String gym){
        String nazwa = silowniaRepository.findSilowniaByNazwa(gym).getNazwa();

        return nazwa;

    }
    public String getliczbaSal (String gym){
        String liczbasal = Integer.toString(silowniaRepository.findSilowniaByNazwa(gym).getLiczbasal());

        return liczbasal;
    }

    public  String getOpis (String gym){

        String opis = silowniaRepository.findSilowniaByNazwa(gym).getOpis();
        return opis;
    }
    public String getMap(String silownia){

        String map = this.silowniaRepository.findSilowniaByNazwa(silownia).getUrlMapy();
        return map;

    }
    public void saveGym(String nazwa, String miasto, String opis, int liczbasal, String urlMapy){


            long idMiasta= this.sl_miastaRepository.findSl_MiastaByNazwa(miasto).getId();
        System.out.println(sl_miastaRepository.findSl_MiastaById(idMiasta));
        this.silowniaRepository.save(Silownia.builder().nazwa(nazwa)._idMiasto(idMiasta).opis(opis).liczbasal(liczbasal).urlMapy(urlMapy).build());

    }

    public void editGym(String oldnazwa, String newnazwa, String miasto, String opis, int liczbasal){
        long idMiasta= this.sl_miastaRepository.findSl_MiastaByNazwa(miasto).getId();
        long id = this.silowniaRepository.findSilowniaByNazwa(oldnazwa).getId();
        String urlMapy = this.silowniaRepository.findSilowniaByNazwa(oldnazwa).getUrlMapy();


         this.silowniaRepository.delete(id);
       this.silowniaRepository.save(Silownia.builder().nazwa(newnazwa)._idMiasto(idMiasta).opis(opis).liczbasal(liczbasal).urlMapy(urlMapy).build());

    }

    public void deleteGym (String nazwa){
        long id = silowniaRepository.findSilowniaByNazwa(nazwa).getId();
        this.silowniaRepository.delete(id);

    }



}
