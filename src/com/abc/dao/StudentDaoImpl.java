package com.abc.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.abc.factory.ConnectionFactory;
import com.abc.model.Student;

public class StudentDaoImpl implements StudentDao {

	@Override
	public String save(Student student) {

		Connection connection = ConnectionFactory.getConnectionObj();
		String status = "";
		if (connection != null) {

			Statement statement;
			try {
				statement = connection.createStatement();
				if (statement != null) {

					String sid = student.getSid();
					String sname = student.getSname();
					String saddr = student.getSaddr();

					sid = "'" + sid + "'";
					sname = "'" + sname + "'";
					saddr = "'" + saddr + "'";

					String sqlInsertQuery = "insert into student(sid,sname,saddress) values (" + sid + "," + sname + ","
							+ saddr + ")";
					int rowAffected = statement.executeUpdate(sqlInsertQuery);

					if (rowAffected == 1) {
						status = "success";
					}

				}

			} catch (SQLException e) {
				if (e.getErrorCode() == 1062) {
					status = "alreadyexisted";
				} else {
					status = "failure";
				}
				e.printStackTrace();
			}

		}

		return status;
	}

}
