package com.kopranych.userservice;

import com.kopranych.userservice.model.User;
import com.kopranych.userservice.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserserviceApplicationTests {

	@Autowired
    private UserService userService;

	@Test
	public void testAddUser(){
		User user = new User("Name", "MName", LocalDate.now(), "user@email.com", "123456");
		User testUser = userService.addNewUser(user);
		Assert.assertEquals(user, testUser);
	}

	@Test
	public void testGetUser(){
		User user = new User("Name", "MName", LocalDate.now(), "test@email.com", "123456");
        userService.addNewUser(user);
		User userTest = userService.getUserByEmail("test@email.com");
		Assert.assertEquals(user.getFirstName(), userTest.getFirstName());
	}

	@Test
	public void testGetAll(){
		List<User> userList;
		for (int i = 0; i < 10; i++) {
            userService.addNewUser(new User("Name", "MName", LocalDate.now(), i + "user@email.com", "123456"));
		}

		userList = (List<User>) userService.getAllUser();
		Assert.assertEquals(12, userList.size());
	}

	@Test
	public void testDelUser(){
		List<User> userList;
		User user = new User("Name", "MName", LocalDate.now(), "name@email.com", "123456");
		User testUser = userService.addNewUser(user);
        userService.deleteUser(testUser.getId());
		userList = (List<User>) userService.getAllUser();
		Assert.assertEquals(2, userList.size());
	}

}
