package com.sergeyry.gymtrainer.dao;

import com.sergeyry.gymtrainer.dao.user.UserDao;
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
		userDao.save(getUser());
		Assert.assertEquals(userDao.findAll().size(), 3);
	}
	
	@Test
	public void deleteUserByLogin(){
		userDao.deleteByLogin("Alex");
		Assert.assertEquals(userDao.findAll().size(), 2);
		Assert.assertNull(userDao.findByLogin("Alex"));

	}
	
	@Test
	public void deleteUserByInvalidLogin(){
		userDao.deleteByLogin("Vitia");
		Assert.assertEquals(userDao.findAll().size(), 2);
	}

	@Test
	public void findAllUsers(){
		Assert.assertEquals(userDao.findAll().size(), 2);
	}
	
	@Test
	public void findUserByLogin(){
		Assert.assertNotNull(userDao.findByLogin("Sergey"));
		Assert.assertNull(userDao.findByLogin("SergeyRybalko"));
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
