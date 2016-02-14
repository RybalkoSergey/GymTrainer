package com.sergeyry.gymtrainer.dao.program;

import com.sergeyry.gymtrainer.model.program.Exercise;
import com.sergeyry.gymtrainer.model.program.Program;
import com.sergeyry.gymtrainer.model.program.ProgramExerciseMapper;

import java.util.List;


public interface ProgramDao {

    List<Program> findAll();

    Program findById(int id);

    List<Program> findByUserId(int id);

    List<Program> findByComplexityType(int id);

    List<ProgramExerciseMapper> findExersicesByProgramId(int id);
}
