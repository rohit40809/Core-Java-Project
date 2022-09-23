package com.training.project.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.training.project.ifaces.EmployeesRepository;
import com.training.project.model.Employees;
import com.training.project.utils.ConnectionFactory;

public class EmployeesRepositoryImpl implements EmployeesRepository<Employees> {

private Connection con=ConnectionFactory.getMySqlConnection();
public static final Logger logger =LogManager.getRootLogger();
	public EmployeesRepositoryImpl() {
		super();
		logger.info("EmployeesRepositoryImpl Constructer is called");
	}
	@Override
	public boolean save(Employees obj) {
		String sql="insert into lumen_employees values(?,?,?,?,?,?,?,?)";
		int rowUpdated=0;
		
		try {
			PreparedStatement pstmt=con.prepareStatement(sql);	
			pstmt.setInt(1,obj.getEmployeeId());
			pstmt.setString(2,obj.getFirstName());
			pstmt.setString(3,obj.getLastName());
			pstmt.setString(4,obj.getAddress());
			pstmt.setString(5,obj.getEmailAddress());
			pstmt.setString(6,obj.getPhoneNumber());
			java.sql.Date date=java.sql.Date.valueOf(obj.getDateOfBirth());
			pstmt.setDate(7, date);
			java.sql.Date date1=java.sql.Date.valueOf(obj.getWeddingDate());
			pstmt.setDate(8, date1);
			rowUpdated=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowUpdated==1?true:false;
		
	}
	
	@Override
	public List<Employees> findAll() {
		String sql="select * from lumen_employees";
		List<Employees> list = new ArrayList<>();
		LocalDate date = null;
		try {
			PreparedStatement pstmt=con.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				Employees emp=new Employees();
				emp.setEmployeeId(rs.getInt(1));
				emp.setFirstName(rs.getString(2));
				emp.setLastName(rs.getString(3));
		    	emp.setAddress(rs.getString(4));
		    	emp.setEmailAddress(rs.getString(5));
		    	emp.setPhoneNumber(rs.getString(6));
		    	date=rs.getDate(7).toLocalDate();
		    	emp.setDateOfBirth(date);
		    	date=rs.getDate(8).toLocalDate();
		    	emp.setWeddingDate(date);
		    	list.add(emp);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	@Override
	public boolean deleteByFirstName(String firstName) {
		String sql="delete from lumen_employees where first_name=?";
		int rowDeleted=0;
		try {
			PreparedStatement pstmt=con.prepareStatement(sql);		
			pstmt.setString(1, firstName);
			rowDeleted=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowDeleted==1?true:false;
	}
	
	@Override
	public boolean updateEmailAndPhoneNumberByEmployeeId(int employeeId, String emailAddress, String phoneNumber) {
		String sql="update lumen_employees set email_address=?,phone_number=? where employee_id=?";
		int rowUpdated=0;
		try {
			PreparedStatement pstmt=con.prepareStatement(sql);		
			pstmt.setString(1, emailAddress);
			pstmt.setString(2, phoneNumber);
			pstmt.setInt(3,employeeId);
			rowUpdated=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return rowUpdated==1?true:false;
	}
}




