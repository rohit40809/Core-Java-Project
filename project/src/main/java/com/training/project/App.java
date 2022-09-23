package com.training.project;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.training.exceptions.ElementNotFoundException;
import com.training.project.model.Employees;
import com.training.project.services.EmployeesService;
/**
 * Hello world!
 *
 */
public class App 
{
	
	
    public static void main( String[] args )
    {
    	int choice;
    	int employeeId;
    	String firstName;
    	String lastName;
    	String address;
    	String emailAddress;
    	String phoneNumber;
    	DateTimeFormatter DateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    	LocalDate dateOfBirth;
    	LocalDate weddingDate;
    	Scanner scan=new Scanner(System.in);
    	
    	EmployeesService service=new EmployeesService();
    	
    	while(true) {
            System.out.println("Press 1 for Adding Employee");
            System.out.println("Press 2 for Getting the List of employees by their firstName.");
            System.out.println("Press 3 for Getting the List of employees with FirstName and Phone Number");
            System.out.println("Press 4 for Updating the email and phoneNumber of a particular employee.");
            System.out.println("Press 5 for Delete Details of a Particular employee by firstName.");
            System.out.println("Press 6 for Getting a list of employees with their firstName and emailAddress  whose Birthday falls on the given date.");
            System.out.println("Press 7 for Gettting the list of employees with their firstName and phone Number whose Wedding Anniversary falls on the given date.");
            System.out.println("Press 8 to Quit");
            
            //Asking user to make choice
            System.out.print("Make your choice:");
            choice = Integer.parseInt(scan.nextLine());
            switch (choice) {
            
            case 1:
            	System.out.print("Enter Employee Id:");
            	employeeId=Integer.parseInt(scan.nextLine());
            	System.out.print("Enter First Name:");
            	firstName=scan.nextLine();
            	System.out.print("Enter Last Name:");
            	lastName=scan.nextLine();
            	System.out.print("Enter Address:");
            	address=scan.nextLine();
            	System.out.print("Enter Email Address:");
            	emailAddress=scan.nextLine();
            	System.out.print("Enter Phone Number:");
            	phoneNumber=scan.nextLine();
            	System.out.print("Enter Date Of Birth in format dd/mm/yyyy:");
                dateOfBirth= LocalDate.parse(scan.nextLine(), DateFormatter);
            	System.out.print("Enter Wedding Date in format dd/mm/yyyy:");
            	weddingDate= LocalDate.parse(scan.nextLine(), DateFormatter);
                System.out.println(service.addEmployee(new Employees(employeeId,firstName,lastName,address,emailAddress,phoneNumber,dateOfBirth,weddingDate)));
                break;
            /*from service*/
            case 2:
            	System.out.println("Enter Employees Name:");
            	firstName=scan.nextLine();
            	try {
					service.findByFirstName(firstName);
				} catch (ElementNotFoundException e) {
					e.printStackTrace();
				}
            	break;
            case 3:
            	try {
					service.findAllWithFirstNameAndPhoneNumber();
				} catch (ElementNotFoundException e) {
					e.printStackTrace();
				}
            	break;
            case 4:
            	System.out.println("Enter Employee Id:");
            	employeeId=Integer.parseInt(scan.nextLine());
            	System.out.println("Enter Email Address:");
            	emailAddress=scan.nextLine();
            	System.out.println("Enter Phone Number");
            	phoneNumber=scan.nextLine();
            	try {
					System.out.println(service.updateEmailAndPhoneNumberByEmployeeId(employeeId,emailAddress,phoneNumber));
				} catch (ElementNotFoundException e1) {
					e1.printStackTrace();
				}
            	break;
            case 5:
            	System.out.println("Enter First Name:");
            	firstName=scan.next();
            	try {
					System.out.println(service.deleteByFirstName(firstName));
				} catch (ElementNotFoundException e1) {
					e1.printStackTrace();
				}
            	break;
            case 6:
            	System.out.println("Enter Date Of Birth in format dd/mm/yyyy:");
                dateOfBirth= LocalDate.parse(scan.nextLine(), DateFormatter);
                try {
					service.getEmployeesByDateOfBirth(dateOfBirth);
				} catch (ElementNotFoundException e) {
					e.printStackTrace();
				}
            	break;
            case 7:
            	System.out.println("Enter Wedding Anniversary in format dd/mm/yyyy:");
                weddingDate= LocalDate.parse(scan.nextLine(), DateFormatter);
                try {
					service.getEmployeesByWeddingDate(weddingDate);
				} catch (ElementNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	break;
            case 8:
            	System.exit(0);
            default:
                System.out.println("Invalid choice!!! Please make a valid choice.");
            }
        }
    }
}






