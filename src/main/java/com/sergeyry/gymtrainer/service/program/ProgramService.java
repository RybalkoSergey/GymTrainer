package com.sergeyry.gymtrainer.service.program;

import com.sergeyry.gymtrainer.model.program.Program;

import java.util.List;

public interface ProgramService {
    Program findById(int id);

    List<Program> findByUserId(int id);

    List<Program> findByComplexityType(int id);
}
