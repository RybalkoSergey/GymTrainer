package com.sergeyry.gymtrainer.dao.program;

import com.sergeyry.gymtrainer.dao.AbstractDao;
import com.sergeyry.gymtrainer.model.program.Exercise;
import com.sergeyry.gymtrainer.model.program.Program;
import com.sergeyry.gymtrainer.model.program.ProgramExerciseMapper;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("programDao")
public class ProgramDaoImpl extends AbstractDao<Program> implements ProgramDao {

    public List<Program> findAll() {
        Query query = getSession().createQuery("from Program p where p.isArchive = 0");
        return query.list();
    }

    public Program findById(int id) {
        return getByKey(id);
    }

    public List<Program> findByUserId(int id) {
        SQLQuery query = getSession().createSQLQuery(
                "SELECT program.* " +
                        "FROM PROGRAMS program " +
                        "  LEFT JOIN USER_PROGRAMS user_program ON user_program.PROGRAM_ID = program.ID " +
                        "WHERE user_program.USER_ID = :userId "
        );

        query.addEntity(Program.class);
        query.setLong("userId", id);

        return (List<Program>) query.list();
    }

    public List<Program> findByComplexityType(int id) {
        Query query = getSession()
                .createQuery("from Program p left join p.complexityType t where t.id = :id")
                .setInteger("id", id);
        return query.list();
    }

    public List<ProgramExerciseMapper> findExersicesByProgramId(int id) {
        Query query = getSession()
                .createQuery("from ProgramExerciseMapper ex left outer join ex.program p where p.id = :id")
                .setInteger("id", id);
        return query.list();
    }
}
