package com.sergeyry.gymtrainer.service;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

import com.sergeyry.gymtrainer.dao.user.UserDao;
import com.sergeyry.gymtrainer.model.user.User;
import com.sergeyry.gymtrainer.service.user.UserServiceImpl;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserServiceImplTest {

	@Mock
	UserDao dao;
	
	@InjectMocks
	UserServiceImpl userService;
	
	@Spy
	List<User> users = new ArrayList<User>();
	
	@BeforeClass
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		users = getUserList();
	}

	@Test
	public void findById(){
		User emp = users.get(0);
		when(dao.findById(anyInt())).thenReturn(emp);
		Assert.assertEquals(userService.findById(emp.getId()),emp);
	}

	@Test
	public void saveUser(){
		doNothing().when(dao).save(any(User.class));
		userService.save(any(User.class));
        verify(dao, atLeastOnce()).save(any(User.class));
    }
	
	@Test
	public void updateUser(){
        User user = users.get(0);
		when(dao.findById(anyInt())).thenReturn(user);
		userService.update(user);
		verify(dao, atLeastOnce()).findById(anyInt());
	}

	@Test
	public void deleteUserByLogin(){
		doNothing().when(dao).deleteByLogin(anyString());
		userService.deleteByLogin(anyString());
		verify(dao, atLeastOnce()).deleteByLogin(anyString());
	}
	
	@Test
	public void findAllUsers(){
		when(dao.findAll()).thenReturn(users);
		Assert.assertEquals(userService.findAll(), users);
	}
	
	@Test
	public void findUserByLogin(){
		User user = users.get(0);
		when(dao.findByLogin(anyString())).thenReturn(user);
		Assert.assertEquals(userService.findByLogin(anyString()), user);
	}

	@Test
	public void isUserLoginUnique(){
		User user = users.get(0);
		when(dao.findByLogin(anyString())).thenReturn(user);
		Assert.assertEquals(userService.isUserLoginUnique(user.getLogin()), false);
	}
	
	public List<User> getUserList(){
        User user = new User();
		user.setId(1);
		user.setLogin("SergeyRy");
		user.setFirstName("Sergey");
		user.setLastName("Rybalko");
		user.setEmail("Sergey@gmail.com");
		user.setPassword("111");

        User user1 = new User();
		user1.setId(2);
        user.setLogin("DmitryBu");
        user.setFirstName("Dmitry");
        user.setLastName("Burkalov");
        user.setEmail("Dmitry@gmail.com");
        user.setPassword("222");
		
		users.add(user);
		users.add(user1);
		return users;
	}
	
}
