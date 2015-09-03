package com.service.impl;

import junit.framework.Assert;

import org.junit.Test;

import com.entity.Users;
import com.service.UsersDAO;

public class UsersDAOImplTest {
	
	@Test
	public void testUsersLogin(){
		Users u = new Users(1,"hah","123");
		UsersDAO udao = new UsersDAOImpl();
		Assert.assertEquals(true, udao.usersLogin(u));
		
	}

}
