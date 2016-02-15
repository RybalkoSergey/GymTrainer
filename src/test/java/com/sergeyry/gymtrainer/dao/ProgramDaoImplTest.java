package com.sergeyry.gymtrainer.dao;

import com.sergeyry.gymtrainer.dao.program.ProgramDao;
import com.sergeyry.gymtrainer.model.program.Program;
import org.dbunit.dataset.CompositeDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by sergeyry on 2/14/16.
 */
public class ProgramDaoImplTest extends EntityDaoImplTest {

    @Autowired
    ProgramDao programDao;

    @Override
    protected IDataSet getDataSet() throws Exception {
      IDataSet[] datasets = new IDataSet[] {
              new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("programs.xml")),
              new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("users.xml")),
              new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("user_programs.xml"))

      };
      return new CompositeDataSet(datasets);
    }

    @Test
    public void findById(){
        Assert.assertNotNull(programDao.findById(1));
        Assert.assertNull(programDao.findById(4));
    }

    @Test
    public void findByUserId(){
        List<Program> programList1 = programDao.findByUserId(1);
        List<Program> programList2 = programDao.findByUserId(2);

        Assert.assertEquals(programList1.size(), 2);
        Assert.assertEquals(programList2.size(), 1);
    }

    @Test
    public void findByComplexityType(){
        List<Program> programList1 = programDao.findByComplexityType(1);
        List<Program> programList2 = programDao.findByUserId(2);

        Assert.assertEquals(programList1.size(), 3);
        Assert.assertEquals(programList2.size(), 0);
    }
}
