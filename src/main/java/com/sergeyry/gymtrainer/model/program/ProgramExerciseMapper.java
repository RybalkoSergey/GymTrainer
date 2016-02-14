package com.sergeyry.gymtrainer.model.program;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="PROGRAM_EXERCISES")
public class ProgramExerciseMapper implements Serializable {

    @Id
    @OneToOne
    @JoinColumn(name="PROGRAM_ID")
    private Program program;

    @Id
    @OneToOne
    @JoinColumn(name="DAY_ID")
    private Day day;

    @Id
    @OneToOne
    @JoinColumn(name="EXERCISE_ID")
    private Exercise exercise;

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }
}
