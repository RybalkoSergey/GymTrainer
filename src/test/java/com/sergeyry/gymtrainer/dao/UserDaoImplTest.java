package com.sergeyry.gymtrainer.dao;

import com.sergeyry.gymtrainer.model.user.User;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;


public class UserDaoImplTest extends EntityDaoImplTest{

	@Autowired
	UserDao userDao;

	@Override
	protected IDataSet getDataSet() throws Exception{
		IDataSet dataSet = new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("users.xml"));
		return dataSet;
	}

	@Test
	public void findById(){
		Assert.assertNotNull(userDao.findById(1));
		Assert.assertNull(userDao.findById(3));
	}

	
	@Test
	public void saveUser(){
		userDao.saveUser(getUser());
		Assert.assertEquals(userDao.findAllUsers().size(), 3);
	}
	
	@Test
	public void deleteUserByLogin(){
		userDao.deleteUserByLogin("Alex");
		Assert.assertEquals(userDao.findAllUsers().size(), 2);
		Assert.assertNull(userDao.findUserByLogin("Alex"));

	}
	
	@Test
	public void deleteUserByInvalidLogin(){
		userDao.deleteUserByLogin("Vitia");
		Assert.assertEquals(userDao.findAllUsers().size(), 2);
	}

	@Test
	public void findAllEmployees(){
		Assert.assertEquals(userDao.findAllUsers().size(), 2);
	}
	
	@Test
	public void findEmployeeByLogin(){
		Assert.assertNotNull(userDao.findUserByLogin("Sergey"));
		Assert.assertNull(userDao.findUserByLogin("SergeyRybalko"));
	}

	public User getUser(){
		User user = new User();
		user.setLogin("Alex");
		user.setFirstName("Alexander");
		user.setLastName("Baglay");
		user.setPassword("Alexander");
		user.setEmail("Alex@gmail.com");
		return user;
	}

}
