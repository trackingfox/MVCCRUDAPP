package com.abc.factory;

import com.abc.dao.StudentDao;
import com.abc.dao.StudentDaoImpl;

public class StudentDaoFactory {

	private static StudentDao studentDao;

	static {

		studentDao = new StudentDaoImpl();

	}

	public static StudentDao getStudentDao() {
		return studentDao;
	}
}
