package com.training.project.model;

import java.time.LocalDate;

public class Employees {
	private String firstName;
	private String lastName;
	private String address;
	private String emailAddress;
	private String phoneNumber;
	private LocalDate dateOfBirth;
	private LocalDate weddingDate;
	private int employeeId;
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public Employees() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Employees(int employeeId,String firstName, String lastName, String address, String emailAddress, String phoneNumber,
			LocalDate dateOfBirth, LocalDate weddingDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.dateOfBirth = dateOfBirth;
		this.weddingDate = weddingDate;
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public LocalDate getWeddingDate() {
		return weddingDate;
	}
	public void setWeddingDate(LocalDate weddingDate) {
		this.weddingDate = weddingDate;
	}
	@Override
	public String toString() {
		return "Employees [employeeId=" + employeeId + ",firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", emailAddress=" + emailAddress + ", phoneNumber=" + phoneNumber + ", dateOfBirth=" + dateOfBirth
				+ ", weddingDate=" + weddingDate + "]";
	}
	
	
}
