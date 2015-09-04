package com.entity;


import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class StudentsTest {

	@Test
	public void testSchemaExport(){
		Configuration config = new Configuration().configure();
		ServiceRegistry serviceRigistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		SchemaExport schemaExport = new SchemaExport(config);
		schemaExport.create(true, true);
	}
	
	@Test
	public void testSaveStudents(){
		Configuration config = new Configuration().configure();//生成配置对象
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();//生成服务注册对象
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);//生成session工厂对象
		Session session = sessionFactory.getCurrentSession();//生成session对象
		
		Transaction tx = session.beginTransaction();
		Students s1 = new Students("S0000001","张三丰","男",new Date(),"武当山");
		Students s2 = new Students("S0000002","郭靖","男",new Date(),"桃花岛");
		Students s3 = new Students("S0000003","黄蓉","女",new Date(),"桃花岛");
		session.save(s1);
		session.save(s2);
		session.save(s3);
		tx.commit();
		sessionFactory.close();
		
	}
	
	
	
}
