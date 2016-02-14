package com.sergeyry.gymtrainer.controller;

import com.sergeyry.gymtrainer.model.program.Program;
import com.sergeyry.gymtrainer.model.program.ProgramExerciseMapper;
import com.sergeyry.gymtrainer.service.program.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/")
public class ProgramController {

    @Autowired
    ProgramService programService;

    @RequestMapping(value = "/program", method = RequestMethod.GET)
    public ResponseEntity<List<Program>> getAllPrograms() {
        List<Program> programs = programService.findAll();
        if(programs.isEmpty()){
            return new ResponseEntity<List<Program>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Program>>(programs, HttpStatus.OK);
    }

    @RequestMapping(value = "/program/{id}/exercises", method = RequestMethod.GET)
    public ResponseEntity<List<ProgramExerciseMapper>> getExercisesByProgramId(@PathVariable int id) {
        List<ProgramExerciseMapper> exercises = programService.findExersicesByProgramId(id);

        if(exercises.isEmpty()){
            return new ResponseEntity<List<ProgramExerciseMapper>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<ProgramExerciseMapper>>(exercises, HttpStatus.OK);
    }


}
