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

	@Override
	public Student loadStudents(int id) {
		Session session = factory.openSession();
		
//		Student student = session.get(Student.class, id);
		Student student = session.load(Student.class, id);
		
//		session.close();
		return student;
		
	}
	
	@Override
	public Student updateStudent(int id, int marks) {

		Session session =factory.openSession();
		Student s = session.get(Student.class, id);
		Transaction t = session.beginTransaction();
		
		try {
			s.setsMarks(marks);
			session.update(s);
			t.commit();
			System.out.println("Object is updated");
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Object is failed to update");
		} finally {
			session.close();
		}
		
		return s;
	}
	
	@Override
	public void deleteStudent(int id) {
		Session session =factory.openSession();
		Student s = session.get(Student.class, id);
		Transaction t = session.beginTransaction();
		
		try {
			session.delete(s);
			t.commit();
			System.out.println("Object is deleted");
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Object is failed to delete");
		} finally {
			session.close();
		}
	}

}
