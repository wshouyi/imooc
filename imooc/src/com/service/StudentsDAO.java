package com.service;

import java.util.List;

import com.entity.Students;

public interface StudentsDAO {

	//查询所有学生
	public List<Students> queryAllStudents();
	
	//查询单个学生
	public Students queryStudentsBySid(String sid);
	
	//增加学生
	public boolean addStudents(Students s);
	//删除指定学生
	public boolean deleteStudents(String sid);
	
	//更改学生信息
	public boolean updateStudents(Students s);
}
