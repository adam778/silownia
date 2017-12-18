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

public class Sl_Miasta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nazwa;

    Sl_Miasta(String nazwa){
        this.nazwa = nazwa;
    }
   // protected Sl_Miasta(){}

    public long getId(){
        return id;
    }

}
