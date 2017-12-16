package Database;

import org.springframework.beans.factory.annotation.Autowired;

public class Test {
    @Autowired
    private SalaRepository salaTabela;
    private SilowniaRepository silowniaTabela;
    private Sl_MiastaRepository sl_miastaTabela;
    private Sl_SprzetuRepository sl_sprzetuTabela;
    private Sprzet_SalaRepository sprzet_salaTabela;

    public void loadData(){
        this.salaTabela.deleteAll();
        this.silowniaTabela.deleteAll();
        this.sl_miastaTabela.deleteAll();
        this.sl_sprzetuTabela.deleteAll();
        this.sprzet_salaTabela.deleteAll();


        this.sl_miastaTabela.save(new Sl_Miasta("Warszawa"));
        this.sl_miastaTabela.save(new Sl_Miasta("Poznan"));

        this.sl_sprzetuTabela.save(new Sl_Sprzetu("lawka"));
        this.sl_sprzetuTabela.save(new Sl_Sprzetu("drazek"));

        this.salaTabela.save(new Sala("Fit", "test",silowniaTabela.findSilowniaByNazwa("SilowniaFit").get_id()));
        this.salaTabela.save(new Sala("Tif", "test",silowniaTabela.findSilowniaByNazwa("Silownia").get_id()));

        this.silowniaTabela.save(new Silownia("SilowniaFit",sl_miastaTabela.findSl_MiastaByNazwa("Warszawa").get_id(),"test",5));
        this.silowniaTabela.save(new Silownia("Silownia",sl_miastaTabela.findSl_MiastaByNazwa("Poznan").get_id(),"test",5));

        this.sprzet_salaTabela.save(new Sprzet_Sala(salaTabela.findSalaByNazwa("Fit").get_id(),sl_sprzetuTabela.findSl_SprzetuByNazwasprzetu("lawka").get_id()));
        this.sprzet_salaTabela.save(new Sprzet_Sala(salaTabela.findSalaByNazwa("Tif").get_id(),sl_sprzetuTabela.findSl_SprzetuByNazwasprzetu("drazek").get_id()));
    }


}
