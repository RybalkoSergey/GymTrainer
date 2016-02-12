package com.sergeyry.gymtrainer.dao.program;

import com.sergeyry.gymtrainer.model.program.Program;

import java.util.List;


public interface ProgramDao {
    Program findById(int id);

    List<Program> findByUserId(int id);

    List<Program> findByComplexityType(int id);
}
