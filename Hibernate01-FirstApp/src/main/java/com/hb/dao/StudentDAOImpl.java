package com.hb.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.hb.entity.Student;

public class StudentDAOImpl implements StudentDAO {
	
	SessionFactory factory;
	
	public StudentDAOImpl() {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
        
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		  
		factory = meta.getSessionFactoryBuilder().build();  
	}

	@Override
	public void saveStudents(Student student) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(student);
			System.out.println("Student is persisted in DB.");
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println("Issues in persisting Student in DB.");
			System.out.println(e);
		} finally {
			session.close();
			factory.close();
		}
	}

}
