package com.abc.service;

import com.abc.dao.StudentDao;
import com.abc.factory.StudentDaoFactory;
import com.abc.model.Student;

public class StudentServiceImpl implements StudentService {

	@Override
	public String save(Student student) {

		StudentDao studentDao = StudentDaoFactory.getStudentDao();
		String status = studentDao.save(student);

		return status;
	}

}
