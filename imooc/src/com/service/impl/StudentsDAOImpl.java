package com.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.db.MyHibernateSessionFactory;
import com.entity.Students;
import com.service.StudentsDAO;

public class StudentsDAOImpl implements StudentsDAO {

	public List<Students> queryAllStudents() {

		Transaction tx = null;
		String hql = "";
		List<Students> list = null;
		
		Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
		tx = session.beginTransaction();
		hql = "from Students";
		Query query = session.createQuery(hql);
		list = query.list();
		tx.commit();
		
		return list;

		
	}

	public Students queryStudentsBySid(String sid) {
		Transaction tx = null;
		Students s = null;
		
		Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
		tx = session.beginTransaction();
		s = (Students)session.get(Students.class,sid);
		tx.commit();
		
		return s;
	}

	public boolean addStudents(Students s) {

		s.setSid(getNewSid());//设置学生学号
		Transaction tx = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.save(s);
			tx.commit();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
		
	}

	public boolean deleteStudents(String sid) {

		Transaction tx = null;
		try{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			Students s = (Students)session.get(Students.class, sid);
			session.delete(s);
			tx.commit();
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}

	public boolean updateStudents(Students s) {
		Transaction tx = null;
		try{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.update(s);
			tx.commit();
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}
	
	public String getNewSid(){
		
		Transaction tx = null;
		String hql="";
		String sid = null;
		try{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "select max(sid) from Students";
			Query query = session.createQuery(hql);
			sid = (String) query.uniqueResult();
			tx.commit();
			if(sid==null||"".equals(sid)){
				return "S0000001";
			}else{
				String temp;
				temp = sid.substring(1);
				int i = Integer.parseInt(temp);
				i++;
				temp = i+"";
				
				int len = temp.length();
				for(int j=0;j<7-len;j++){
					temp = "0"+temp;
				}
				sid = "S"+temp;
				return sid;
			}
			
			
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}

}
