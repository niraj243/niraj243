package com.app.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.app.bean.StudentBean;
import com.app.bean.StudentBeanAddData;
import com.app.util.DBConnectionUtils;

public class StudentDAO {

//	private static Logger _log = LogManager.getLogManager().getLogger(StudentDAO.class.getName());

	private static final String _INSERT_STUD_SQL = "INSERT into Student (fname,lname,bdate,email,phone,gender,addressLine1,addressLine2,city,country,course) values (?,?,?,?,?,?,?,?,?,?,?)";
	private static final String _SELECT_ALL_STUD_SQL = "Select studentId,fname,lname,bdate,email,phone,gender,addressLine1,addressLine2,city,country,course from Student";
	private static final String _SELECT_STUD_BY_STUD_ID_SQL = "Select studentId,fname,lname,bdate,email,phone,gender,addressLine1,addressLine2,city,country,course from Student where studentId=?";
	private static final String _DELETE_STUD_SQL_ = "DELETE from student where studentId = ?";
	private static final String _UPDATE_STUD_BY_STUD_ID_SQL = "update student set fname=?,lname=?,bdate=?,email=?,phone=?,gender=?,addressLine1=?,addressLine2=?,city=?,country=?,course=? where studentId=?";

	public List<StudentBean> getStudents() {
		List<StudentBean> students = new ArrayList<StudentBean>();
		try (Connection con = DBConnectionUtils.getInstance().getDBConnection()) {
			Statement ps = con.createStatement();
			ResultSet rs = ps.executeQuery(_SELECT_ALL_STUD_SQL);
			while (rs.next()) {
				StudentBean student = new StudentBean(rs.getLong(1), rs.getString(2), rs.getString(3),
						rs.getDate(4).getTime(), rs.getString(5), rs.getLong(6), rs.getInt(7), rs.getString(8),
						rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12));
				students.add(student);
			}
			return students;
//			_log.log(Level.INFO, "StudentDAO.addStudent() is start for execution...");
		} catch (Exception e) {
//			_log.log(Level.ALL, "Error occurred.", e);
		}
		return Collections.EMPTY_LIST;
	}

	public boolean addStudent(StudentBean student) {
//		_log.log(Level.INFO, "StudentDAO.addStudent() is call..." + student);
		try (Connection con = DBConnectionUtils.getInstance().getDBConnection()) {
			PreparedStatement ps = con.prepareStatement(_INSERT_STUD_SQL);

			ps.setString(1, student.getFirstname());
			ps.setString(2, student.getLastname());
			ps.setDate(3, new Date(student.getBdate()));
			ps.setString(4, student.getEmail());
			ps.setLong(5, student.getPhone());
			ps.setInt(6, student.getGender());
			ps.setString(7, student.getAddressLine1());
			ps.setString(8, student.getAddressLine2());
			ps.setString(9, student.getCity());
			ps.setString(10, student.getCountry());
			ps.setString(11, student.getCourse());

//			_log.log(Level.INFO, "StudentDAO.addStudent() is start for execution...");
			return ps.executeUpdate() != 0;
		} catch (Exception e) {
//			_log.log(Level.ALL, "Error occurred.", e);
		}
		return false;
	}

	public StudentBeanAddData getStudentByStudentId(long studentId) {
		StudentBeanAddData student = null;
		try (Connection con = DBConnectionUtils.getInstance().getDBConnection()) {
			PreparedStatement ps = con.prepareStatement(_SELECT_STUD_BY_STUD_ID_SQL);
			ps.setLong(1, studentId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				student = new StudentBeanAddData(rs.getLong(1), rs.getString(2), rs.getString(3),
						rs.getDate(4).getTime(), rs.getString(5), rs.getLong(6), rs.getInt(7), rs.getString(8),
						rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12));
			}
		} catch (Exception e) {
//			_log.log(Level.ALL, "Error occurred.", e);
		}
		return student;
	}

	public boolean updateStudent(StudentBean student) {
		try (Connection con = DBConnectionUtils.getInstance().getDBConnection()) {
			PreparedStatement ps = con.prepareStatement(_UPDATE_STUD_BY_STUD_ID_SQL);

			ps.setString(1, student.getFirstname());
			ps.setString(2, student.getLastname());
			ps.setDate(3, new Date(student.getBdate()));
			ps.setString(4, student.getEmail());
			ps.setLong(5, student.getPhone());
			ps.setInt(6, student.getGender());
			ps.setString(7, student.getAddressLine1());
			ps.setString(8, student.getAddressLine2());
			ps.setString(9, student.getCity());
			ps.setString(10, student.getCountry());
			ps.setString(11, student.getCourse());
			ps.setLong(12, StudentBeanAddData.getStudentId());

			return ps.executeUpdate() != 0;
		} catch (Exception e) {
//			_log.log(Level.ALL, "Error occurred.", e);
		}
		return false;
	}

	public boolean deleteStudent(long student) {

		try (Connection con = DBConnectionUtils.getInstance().getDBConnection()) {
			PreparedStatement ps = con.prepareStatement(_DELETE_STUD_SQL_);
			ps.setLong(1, student);
			ps.executeUpdate();
		} catch (Exception e) {
//				_log.log(Level.ALL, "Error occurred.", e);
		}
		return false;
	}

}
