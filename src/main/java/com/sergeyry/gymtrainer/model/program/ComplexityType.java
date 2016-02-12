package com.sergeyry.gymtrainer.model.program;

import javax.persistence.*;


@Entity
@Table(name="COMPLEXITY_TYPES")
public class ComplexityType {

    @Id
    private int id;

    @Column(name = "NAME")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
