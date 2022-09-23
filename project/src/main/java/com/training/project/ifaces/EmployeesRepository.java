package com.training.project.ifaces;


public interface EmployeesRepository<T> extends CrudRepository<T> {
	public boolean deleteByFirstName(String firstName);
	public boolean updateEmailAndPhoneNumberByEmployeeId(int employeeId,String emailAddress,String phoneNumber);
}
