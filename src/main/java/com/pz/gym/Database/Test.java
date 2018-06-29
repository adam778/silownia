package com.pz.gym.Database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Test {

    private SilowniaRepository silowniaRepository;
    private Sl_MiastaRepository sl_miastaRepository;

    @Autowired
    public Test( SilowniaRepository silowniaTabela, Sl_MiastaRepository sl_miastaTabela) {
        this.silowniaRepository = silowniaTabela;
        this.sl_miastaRepository = sl_miastaTabela;
    }


    public void loadData(){
        this.silowniaRepository.deleteAll();
        this.sl_miastaRepository.deleteAll();


        this.sl_miastaRepository.save(Sl_Miasta.builder().nazwa("Warszawa").build());
        this.sl_miastaRepository.save(Sl_Miasta.builder().nazwa("Poznan").build());
        this.sl_miastaRepository.save(Sl_Miasta.builder().nazwa("Gdansk").build());
        this.sl_miastaRepository.save(Sl_Miasta.builder().nazwa("Lublin").build());
        this.sl_miastaRepository.save(Sl_Miasta.builder().nazwa("Zakopane").build());
        this.sl_miastaRepository.save(Sl_Miasta.builder().nazwa("Bydgoszcz").build());


        this.silowniaRepository.save(Silownia.builder().nazwa("SilowniaFit")._idMiasto(sl_miastaRepository.findSl_MiastaByNazwa("Warszawa").getId()).opis("Każda z sal To raj dla wszystkich tych, którzy preferują podstawowe, wolne ćwiczenia i duże ciężary. Klubowicze znajdą tu: bramę, 4 ławeczki - regulowany skos, 1 ławeczka płaska, ławkę skośną do brzucha, ławeczkę rzymską, ławkę skośną z regulowanym skosem, suwnicę Smitha, sztangę olimpijską, 2 sztangi łamane, 2 sztangi proste, modlitewnik, wyciskanie łydkami siedząc, drążek do podciągania, poręcze do pompek, talerze 1,25 kg; 2,5 kg; 5 kg; 10 kg; 15 kg; 20 kg; 25 kg. Ponadto posiadamy hantle w przedziale od 0,5 do 40 kg.").liczbasal(5).urlMapy("http://www.rocznikjozefowski.pl/images/mapa-Jozefow.jpg").build());
        this.silowniaRepository.save(Silownia.builder().nazwa("Silownia")._idMiasto(sl_miastaRepository.findSl_MiastaByNazwa("Poznan").getId()).opis("To miejsce dla wszystkich tych, którzy preferują, ćwiczenia z wolnymi ciężarami.  Znajduje się tu m.in. ławeczki do wyciskania: pozioma,  regulowana skośna dodatnia, regulowana skośna ujemna, oraz stojaki wysokie i niskie a do tego ławeczka pozioma i regulowana skośna, ławki do ćwiczenia mięśni brzucha: rzymska niska i wysoka, sztangi olimpijskie proste i łamane,  obciążenia olimpijskie, modlitewnik na biceps, hantle od 1-20 kg, oraz sztangielki od 22-40 kg.").liczbasal(8).urlMapy("http://www.junoszyno.pl/galeriafoto/lightbox/dojazd_mapaDomek2.jpg").build());




    }


    public void printTestData(){



        System.out.println("Silownia");
        System.out.println("-----------");
        for (Silownia silownia : this.silowniaRepository.findAll()){
            System.out.println(silownia.getNazwa());
        }

        System.out.println("Sl Miasta");
        System.out.println("-----------");
        for (Sl_Miasta sl_miasta : this.sl_miastaRepository.findAll()){
            System.out.println(sl_miasta);
        }



    }


}
