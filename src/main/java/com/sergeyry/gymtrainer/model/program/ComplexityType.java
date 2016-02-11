package com.sergeyry.gymtrainer.model.program;

import javax.persistence.*;


@Entity
@Table(name="COMPLEXITY_TYPES")
public class ComplexityType {

    @Id
    private int id;

    @Column(name = "NAME")
    private String name;
}
