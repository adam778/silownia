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
    private int _id;
    private int idSala;
    private int idSprzet;

    Sprzet_Sala(int idSala, int idSprzet){
        this.idSala = idSala;
        this.idSprzet = idSprzet;
    }
   // Sprzet_Sala(){};

}
