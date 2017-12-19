package com.pz.gym.Database;

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
@Builder

public class Sala {
   @Id
   @GeneratedValue( strategy = GenerationType.AUTO)
   private long id;

   private String nazwa;
   private String opis;
   private long idSilownia;


}
