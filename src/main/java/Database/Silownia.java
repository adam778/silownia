package Database;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Setter
@Getter
//@Builder

public class Silownia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int _id;

    private String nazwa;
    private int _idMiasto;
    private String opis;
    private int liczbasal;

    Silownia (String nazwa, int idMiasto, String opis, int liczbasal){
        this.nazwa = nazwa;
        this._idMiasto = idMiasto;
        this.opis = opis;
    }
   // protected Silownia(){};


}
