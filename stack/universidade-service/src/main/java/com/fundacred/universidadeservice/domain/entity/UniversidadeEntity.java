package com.fundacred.universidadeservice.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class UniversidadeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "universidade_sequence")
    @SequenceGenerator(name = "universidade_sequence", sequenceName = "UNIVERSIDADE_SEQ")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "num")
    private Integer numEstudantes;

    public void plusEstudantes() {
        numEstudantes++;
    }
}
