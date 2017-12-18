package Database;

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


        this.sl_miastaRepository.save(new Sl_Miasta("Warszawa"));
        this.sl_miastaRepository.save(new Sl_Miasta("Poznan"));

        this.sl_sprzetuRepository.save(new Sl_Sprzetu("lawka"));
        this.sl_sprzetuRepository.save(new Sl_Sprzetu("drazek"));

        this.salaRepository.save(new Sala("Fit", "test",silowniaRepository.findSilowniaByNazwa("SilowniaFit").getId()));
        this.salaRepository.save(new Sala("Tif", "test",silowniaRepository.findSilowniaByNazwa("Silownia").getId()));

        this.silowniaRepository.save(new Silownia("SilowniaFit",sl_miastaRepository.findSl_MiastaByNazwa("Warszawa").getId(),"test",5));
        this.silowniaRepository.save(new Silownia("Silownia",sl_miastaRepository.findSl_MiastaByNazwa("Poznan").getId(),"test",5));


        this.sprzet_salaRepository.save(new Sprzet_Sala(salaRepository.findSalaByNazwa("Fit").getId(),sl_sprzetuRepository.findSl_SprzetuByNazwasprzetu("lawka").getId()));
        this.sprzet_salaRepository.save(new Sprzet_Sala(salaRepository.findSalaByNazwa("Tif").getId(),sl_sprzetuRepository.findSl_SprzetuByNazwasprzetu("drazek").getId()));


    }


    public void printTestData(){

        System.out.println("Sala");
        System.out.println("-----------");
        for (Sala sala : this.salaRepository.findAll()){
            System.out.println(sala);
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
