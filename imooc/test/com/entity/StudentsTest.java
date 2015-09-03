package com.entity;


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
}
