package com.hb.client;

import com.hb.dao.StudentDAO;
import com.hb.dao.StudentDAOImpl;
import com.hb.entity.Student;

public class StudentTest {
	
	public static void main(String[] args) {
		
		StudentDAO dao = new StudentDAOImpl();
		
		Student s1 = new Student();
		s1.setsId(1);
		s1.setsName("Rahul");
		s1.setsGender("M");
		s1.setsMarks(97);
		
		dao.saveStudents(s1);
		
//		Student s2 = new Student();
////		s2.setsId(2);
//		s2.setsName("Mahesh");
//		s2.setsGender("M");
//		s2.setsMarks(92);
//		
//		dao.saveStudents(s2);
//		
//		Student s3 = new Student();
////		s3.setsId(3);
//		s3.setsName("Ganesh");
//		s3.setsGender("M");
//		s3.setsMarks(95);
//		
//		dao.saveStudents(s3);
	}

}
