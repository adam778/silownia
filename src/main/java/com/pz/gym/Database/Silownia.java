package com.pz.gym.Database;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Silownia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nazwa;
    private long _idMiasto;
    @Column (columnDefinition = "VARCHAR(10000)")
    private  String opis;
    private int liczbasal;
    private String urlMapy;

}
