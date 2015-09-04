package com.service.impl;

import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.entity.Students;
import com.service.StudentsDAO;

public class StudentsDAOImplTest {
	
	@Test
	public void testQueryAllStudents(){
		StudentsDAO sdao = new StudentsDAOImpl();
		List<Students> list = sdao.queryAllStudents();
		java.util.Iterator<Students> iterator = list.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
	
	@Test
	public void testGetNewSid(){
		StudentsDAOImpl sdaoi = new StudentsDAOImpl();
		System.out.println(sdaoi.getNewSid());
	}
	
	@Test
	public void testAddStudents(){
		Students s = new Students();
		s.setSname("郭靖");
		s.setGender("男");
		s.setBirthday(new Date());
		s.setAddress("桃花岛");
		StudentsDAO sdao = new StudentsDAOImpl();
		Assert.assertEquals(true, sdao.addStudents(s));
		
	}
}
