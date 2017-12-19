package com.pz.gym.Database;

import lombok.*;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Sala {
   @Id
   @GeneratedValue( strategy = GenerationType.AUTO)
   private long id;

   private String nazwa;
   private String opis;
   private long idSilownia;


}
