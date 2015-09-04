package com.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.entity.Students;
import com.service.StudentsDAO;
import com.service.impl.StudentsDAOImpl;

public class StudentsAction extends SuperAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//查询学生动作
	public String query(){
		StudentsDAO sdao = new StudentsDAOImpl();
		List<Students> list = sdao.queryAllStudents();
		if(list!=null&&list.size()>0){
			session.setAttribute("students_list", list);
		}
		return "query_success";
	}
	
	//删除学生动作
	public String delete(){
		StudentsDAO sdao = new StudentsDAOImpl();
		String sid = request.getParameter("sid");
		if(sdao.deleteStudents(sid)){
			return "delete_success";
		}else{
			return "delete_failure";
		}
	}
	
	//添加学生动作
	public String add() throws Exception{
		StudentsDAO sdao = new StudentsDAOImpl();
		Students s = new Students();
		s.setSname(request.getParameter("sname"));
		s.setGender(request.getParameter("gender"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		s.setBirthday(sdf.parse(request.getParameter("birthday")));
		s.setAddress(request.getParameter("address"));
		if(sdao.addStudents(s)){
			return "add_success";
		}else{
			return "add_failure";
		}
	}
	
	//修改学生动作
	public String modify(){
		String sid = request.getParameter("sid");
		StudentsDAO sdao = new StudentsDAOImpl();
		Students s = sdao.queryStudentsBySid(sid);
		//放入会话中
		session.setAttribute("modify_students",s);
		return "modify_success";
		
	}
	
	//保存修改后的学生资料动作
	public String save() throws Exception{
		StudentsDAO sdao = new StudentsDAOImpl();
		Students s = new Students();
		s.setSid(request.getParameter("sid"));
		s.setSname(request.getParameter("sname"));
		s.setGender(request.getParameter("gender"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		s.setBirthday(sdf.parse(request.getParameter("birthday")));
		s.setAddress(request.getParameter("address"));
		if(sdao.updateStudents(s)){
			return "save_success";
		}else{
			return "save_failure";
		}
	}
	
	
}
