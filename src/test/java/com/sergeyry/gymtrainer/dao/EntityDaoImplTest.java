package com.sergeyry.gymtrainer.dao;

import javax.sql.DataSource;

import com.sergeyry.gymtrainer.configuration.DataTypeFactory;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseDataSourceConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;

import com.sergeyry.gymtrainer.configuration.HibernateTestConfiguration;


@ContextConfiguration(classes = { HibernateTestConfiguration.class })
public abstract class EntityDaoImplTest extends AbstractTransactionalTestNGSpringContextTests {

	@Autowired
	DataSource dataSource;

	@BeforeMethod
	public void setUp() throws Exception {
		IDatabaseConnection dbConn = new DatabaseDataSourceConnection(
				dataSource);

		DatabaseConfig config = dbConn.getConfig();
		config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY,
				new DataTypeFactory());

		DatabaseOperation.CLEAN_INSERT.execute(dbConn, getDataSet());
	}
	
	protected abstract IDataSet getDataSet() throws Exception;

}