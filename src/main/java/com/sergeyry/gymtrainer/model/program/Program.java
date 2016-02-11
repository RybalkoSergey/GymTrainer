package com.sergeyry.gymtrainer.model.program;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


@Entity
@Table(name="PROGRAMS")
public class Program {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min=5, max=45)
    @NotEmpty
    @Column(name = "NAME", nullable = false)
    private String name;

    @Size(min=5, max=45)
    @NotEmpty
    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @OneToOne
    @JoinColumn(name="COMPLEXITY_TYPE_ID")
    private ComplexityType complexityType;

    @JoinTable(name = "PROGRAM_DAYS_EXERCISES",
            joinColumns = @JoinColumn(name = "PROGRAM_ID"),
            inverseJoinColumns = @JoinColumn(name = "EXERCISE_ID"))
    @MapKeyJoinColumn(name = "DAY_ID")
    @ElementCollection
    private Map<Day, Exercise> exercises = new HashMap<Day, Exercise>();

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

    public ComplexityType getComplexityType() {
        return complexityType;
    }

    public void setComplexityType(ComplexityType complexityType) {
        this.complexityType = complexityType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Program program = (Program) o;

        if (id != program.id) return false;
        if (!name.equals(program.name)) return false;
        if (!description.equals(program.description)) return false;
        return complexityType.equals(program.complexityType);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }
}
