package com.sergeyry.gymtrainer.model.program;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DAYS")
public class Day {
    @Id
    private int id;

    @Column(name = "NAME")
    private String name;
}
