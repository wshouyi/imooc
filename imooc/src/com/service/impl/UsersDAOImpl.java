package com.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.db.MyHibernateSessionFactory;
import com.entity.Users;
import com.service.UsersDAO;

public class UsersDAOImpl implements UsersDAO {

	public boolean usersLogin(Users u) {
		// TODO Auto-generated method stub
		
		Transaction tx = null;
		try{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			String hql = "from Users where username=? and password=? ";
			Query query = session.createQuery(hql);
			query.setParameter(0,u.getUsername());
			query.setParameter(1,u.getPassword());
			List list = query.list();
			tx.commit();
			if(list.size()>0){
				return true;
			}else{
				return false;
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}finally{
			if(tx!=null)
			{
				tx=null;
			}
		}
		
		
	}

}
