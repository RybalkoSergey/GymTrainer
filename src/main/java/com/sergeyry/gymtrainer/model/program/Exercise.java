package com.sergeyry.gymtrainer.model.program;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EXERCISES")
public class Exercise {

    @Id
    private int id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "AMOUNT_OF_SET", nullable = false)
    private int amountOfSet;

    @Column(name = "AMOUNT_OF_ITERATION", nullable = false)
    private int amountOfIteration;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmountOfSet() {
        return amountOfSet;
    }

    public void setAmountOfSet(int amountOfSet) {
        this.amountOfSet = amountOfSet;
    }

    public int getAmountOfIteration() {
        return amountOfIteration;
    }

    public void setAmountOfIteration(int amountOfIteration) {
        this.amountOfIteration = amountOfIteration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Exercise exercise = (Exercise) o;

        if (id != exercise.id) return false;
        if (amountOfSet != exercise.amountOfSet) return false;
        if (amountOfIteration != exercise.amountOfIteration) return false;
        if (name != null ? !name.equals(exercise.name) : exercise.name != null) return false;
        return !(description != null ? !description.equals(exercise.description) : exercise.description != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + amountOfSet;
        result = 31 * result + amountOfIteration;
        return result;
    }
}
