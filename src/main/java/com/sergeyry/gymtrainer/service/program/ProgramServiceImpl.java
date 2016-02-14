package com.sergeyry.gymtrainer.service.program;


import com.sergeyry.gymtrainer.dao.program.ProgramDao;
import com.sergeyry.gymtrainer.model.program.Program;
import com.sergeyry.gymtrainer.model.program.ProgramExerciseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("programService")
@Transactional
public class ProgramServiceImpl implements ProgramService{

    @Autowired
    private ProgramDao programDao;

    public List<Program> findAll() {
        return programDao.findAll();
    }

    public Program findById(int id) {
        return programDao.findById(id);
    }

    public List<Program> findByUserId(int id) {
        return programDao.findByUserId(id);
    }

    public List<Program> findByComplexityType(int id) {
        return programDao.findByComplexityType(id);
    }

    public List<ProgramExerciseMapper> findExersicesByProgramId(int id) {
        return programDao.findExersicesByProgramId(id);
    }
}
