package com.sergeyry.gymtrainer.service.program;

import com.sergeyry.gymtrainer.model.program.Program;
import com.sergeyry.gymtrainer.model.program.ProgramExerciseMapper;

import java.util.List;

public interface ProgramService {
    List<Program> findAll();

    Program findById(int id);

    List<Program> findByUserId(int id);

    List<Program> findByComplexityType(int id);

    List<ProgramExerciseMapper> findExersicesByProgramId(int id);
}
