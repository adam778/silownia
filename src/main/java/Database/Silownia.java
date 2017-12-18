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
    private long id;

    private String nazwa;
    private long _idMiasto;
    private String opis;
    private int liczbasal;

    Silownia (String nazwa, long idMiasto, String opis, long liczbasal){
        this.nazwa = nazwa;
        this._idMiasto = idMiasto;
        this.opis = opis;
    }

    public long getId(){
        return id;
    }
   // protected Silownia(){};


}
