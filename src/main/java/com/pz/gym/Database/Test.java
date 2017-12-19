package com.pz.gym.Database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Test {

    private SalaRepository salaRepository;
    private SilowniaRepository silowniaRepository;
    private Sl_MiastaRepository sl_miastaRepository;
    private Sl_SprzetuRepository sl_sprzetuRepository;
    private Sprzet_SalaRepository sprzet_salaRepository;

    @Autowired
    public Test(SalaRepository salatabela, SilowniaRepository silowniaTabela, Sl_MiastaRepository sl_miastaTabela, Sl_SprzetuRepository sl_sprzetuTabela, Sprzet_SalaRepository sprzet_salaTabela) {
        this.salaRepository = salatabela;
        this.silowniaRepository = silowniaTabela;
        this.sl_miastaRepository = sl_miastaTabela;
        this.sl_sprzetuRepository = sl_sprzetuTabela;
        this.sprzet_salaRepository = sprzet_salaTabela;
    }


    public void loadData(){
        this.salaRepository.deleteAll();
        this.silowniaRepository.deleteAll();
        this.sl_miastaRepository.deleteAll();
        this.sl_sprzetuRepository.deleteAll();
        this.sprzet_salaRepository.deleteAll();


        this.sl_miastaRepository.save(Sl_Miasta.builder().nazwa("Warszawa").build());
        this.sl_miastaRepository.save(Sl_Miasta.builder().nazwa("Poznan").build());

        this.sl_sprzetuRepository.save(Sl_Sprzetu.builder().nazwasprzetu("lawka").build());
        this.sl_sprzetuRepository.save(Sl_Sprzetu.builder().nazwasprzetu("drazek").build());



        this.silowniaRepository.save(Silownia.builder().nazwa("SilowniaFit")._idMiasto(sl_miastaRepository.findSl_MiastaByNazwa("Warszawa").getId()).opis("test").liczbasal(5).build());
        this.silowniaRepository.save(Silownia.builder().nazwa("Silownia")._idMiasto(sl_miastaRepository.findSl_MiastaByNazwa("Poznan").getId()).opis("test").liczbasal(5).build());

        this.salaRepository.save(Sala.builder().nazwa("Fit").opis("test").idSilownia(silowniaRepository.findSilowniaByNazwa("SilowniaFit").getId()).build());
        this.salaRepository.save(Sala.builder().nazwa("Tif").opis("test").idSilownia(silowniaRepository.findSilowniaByNazwa("Silownia").getId()).build());

        this.sprzet_salaRepository.save(Sprzet_Sala.builder().idSala(salaRepository.findSalaByNazwa("Fit").getId()).idSprzet(sl_sprzetuRepository.findSl_SprzetuByNazwasprzetu("lawka").getId()).build());
        this.sprzet_salaRepository.save(Sprzet_Sala.builder().idSala(salaRepository.findSalaByNazwa("Tif").getId()).idSprzet(sl_sprzetuRepository.findSl_SprzetuByNazwasprzetu("drazek").getId()).build());


    }


    public void printTestData(){

        System.out.println("Sala");
        System.out.println("-----------");
        for (Sala sala : this.salaRepository.findAll()){
            System.out.println(sala.getNazwa());
        }

        System.out.println("Silownia");
        System.out.println("-----------");
        for (Silownia silownia : this.silowniaRepository.findAll()){
            System.out.println(silownia);
        }

        System.out.println("Sl Miasta");
        System.out.println("-----------");
        for (Sl_Miasta sl_miasta : this.sl_miastaRepository.findAll()){
            System.out.println(sl_miasta);
        }

        System.out.println("Sl Sprzetu ");
        System.out.println("-----------");
        for (Sl_Sprzetu sl_sprzetu : this.sl_sprzetuRepository.findAll()){
            System.out.println(sl_sprzetu);
        }
        System.out.println("Sprzet sala");
        System.out.println("-----------");
        for (Sprzet_Sala sprzet_sala : this.sprzet_salaRepository.findAll()){
            System.out.println(sprzet_sala);
        }

    }


}
