package Database;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Getter
@Setter
//@Builder

public class Sala {
   @Id
   @GeneratedValue( strategy = GenerationType.AUTO)
   private int _id;
   private String nazwa;
   private String opis;
   private int _idSilownia;

   Sala (String nazwa, String opis, int idSilownia ){
       this.nazwa = nazwa;
       this.opis = opis;
       this._idSilownia = idSilownia;

   }

  // protected  Sala(){};



}
