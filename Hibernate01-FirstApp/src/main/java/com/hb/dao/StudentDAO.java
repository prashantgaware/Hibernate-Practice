package com.hb.dao;

import com.hb.entity.Student;

public interface StudentDAO {
	
	void saveStudents(Student student);

	Student loadStudents(int id);
	
	Student updateStudent(int id, int marks);
	
	void deleteStudent(int id);
}
