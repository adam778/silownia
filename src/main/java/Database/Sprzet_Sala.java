package Database;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Getter
@Setter
//@Builder
public class Sprzet_Sala {
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long idSala;
    private long idSprzet;

    Sprzet_Sala(long idSala, long idSprzet){
        this.idSala = idSala;
        this.idSprzet = idSprzet;
    }

    public long getId(){
        return id;
    }
   // Sprzet_Sala(){};

}
