package Database;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
//@Builder

public class Sl_Sprzetu {
@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int _id;

    private String nazwasprzetu;

    Sl_Sprzetu(String nazwasprzetu){
        this.nazwasprzetu = nazwasprzetu;
    }

    protected Sl_Sprzetu(){};

}
