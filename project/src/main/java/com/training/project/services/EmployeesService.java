package com.training.project.services;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.training.exceptions.ElementNotFoundException;
import com.training.project.model.Employees;
import com.training.project.repo.EmployeesRepositoryImpl;

public class EmployeesService {
	public static final Logger logger =LogManager.getRootLogger();
	List<Employees> empList;
	EmployeesRepositoryImpl dao=null;
	public EmployeesService() {
		logger.info("Employee Service Constructer is called");
		this.dao=new EmployeesRepositoryImpl();
		empList=dao.findAll();
	}
	
	/*1*/
	public String addEmployee(Employees emp) {
		boolean rowAdded=this.dao.save(emp);
		empList.add(emp);
		if(!rowAdded) {
			logger.error("Employee Added : "+rowAdded);
			return "Enter Correct Employee Details";
		}
		else {
			logger.info("Employee Added : "+rowAdded);
			return rowAdded+"  ---one row Added";
		}
	}
	
	/*2nd*/
	public void findByFirstName(String firstName) throws ElementNotFoundException {
		List<Employees> list= this.empList.stream().filter(e->e.getFirstName().equals(firstName)).collect(toList());	
		if(list.size()==0) {
			throw new ElementNotFoundException("ERR-102","No employee with first Name:"+firstName);
		}
		else {
			list.forEach(e->logger.info(e));
		}
	}
	/*3rd*/
	public void findAllWithFirstNameAndPhoneNumber() throws ElementNotFoundException {
		Map<String, String> map=this.empList.stream()
				.collect(Collectors.toMap(Employees::getPhoneNumber,Employees::getFirstName ));
		Collection<String> list=new ArrayList<>();
		 map.forEach((x,y)->list.add("FirstName:"+y+" PhoneNumber:"+x));
		if(map.size()==0) {
    		throw new ElementNotFoundException("ERR-102","No employees Exist");
    	}
    	else {
    		list.forEach(e->logger.info(e));
    	}
	}
	
	/*4th*/
	public String updateEmailAndPhoneNumberByEmployeeId(int employeeId, String emailAddress, String phoneNumber) throws ElementNotFoundException {
		boolean rowUpdated=this.dao.updateEmailAndPhoneNumberByEmployeeId(employeeId, emailAddress, phoneNumber);
		empList=dao.findAll();
		if(!rowUpdated) {
			logger.error("Employee Updated : "+rowUpdated);
			throw new ElementNotFoundException("ERR-102","No employee with employeeId"+employeeId);	
		}
		else {
			logger.info("Employee Updated : "+rowUpdated);
			return rowUpdated+"   ---row updated";
		}
	}
	
	/*5th*/
	public String deleteByFirstName(String firstName) throws ElementNotFoundException {
		boolean rowDeleted=this.dao.deleteByFirstName(firstName);
		empList=dao.findAll();
		if(!rowDeleted) {
			logger.error("Employee Updated : "+rowDeleted);
			throw new ElementNotFoundException("ERR-102","No employee with first name"+firstName);	
		}
		else {
			logger.info("Employee Updated : "+rowDeleted);
			return rowDeleted+"   ---row updated";
		}
	}
	
	/*6*/
	public void getEmployeesByDateOfBirth(LocalDate dateOfBirth) throws ElementNotFoundException{
		Map<String,String> map= this.empList.stream()
				.filter(e->e.getDateOfBirth()
				.equals(dateOfBirth))
				.collect(toMap(Employees::getPhoneNumber,Employees::getFirstName));
		if(map.size()==0) {
    		throw new ElementNotFoundException("ERR-102","No employee with date of Birth "+dateOfBirth);
    	}
    	else {
    		map.forEach((phonenumber,firstname)-> System.out.println(firstname + "," + phonenumber));
    	}
	}
	
	/*7*/
	public void getEmployeesByWeddingDate(LocalDate weddingDate) throws ElementNotFoundException{
		Map<String,String> map= this.empList.stream()
				.filter(e->e.getWeddingDate()
				.equals(weddingDate))
				.collect(toMap(Employees::getPhoneNumber,Employees::getFirstName));
		if(map.size()==0) {
    		throw new ElementNotFoundException("ERR-102","No employee with wedding date "+weddingDate);
    	}
    	else {
    		map.forEach((phonenumber,firstname)-> System.out.println(firstname + "," + phonenumber));
    	}
	}
}





