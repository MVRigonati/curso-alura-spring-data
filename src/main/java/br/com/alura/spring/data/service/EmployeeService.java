package br.com.alura.spring.data.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.EmployeeEntity;
import br.com.alura.spring.data.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
	public void userCreateEmployee(final Scanner scan) {
		System.out.println("Type the name: ");
		final String name = scan.next();
		System.out.println("Type the CPF: ");
		final String cpf = scan.next();
		System.out.println("Type the salary: ");
		final String salary = scan.next();
		final Date hiringDate = readDate("Type the hiringDate (dd/mm/yyyy): ", scan);
		System.out.println("Type the role ID for this employee: ");
		final Integer roleId = scan.nextInt();

		EmployeeEntity newEmployee = new EmployeeEntity(name, cpf, Double.parseDouble(salary), hiringDate, Integer.toUnsignedLong(roleId));
		
		addWorkUnities(scan, newEmployee);
		
		repository.save(newEmployee);
		System.out.println();
	}

	private static void addWorkUnities(final Scanner scan, final EmployeeEntity newEmployee) {
		Integer unityId = 1;
		while (unityId != 0) {
			System.out.println("Type the unity ID to add to this employee (type 0 to finish): ");
			unityId = scan.nextInt();
			if (unityId != 0) newEmployee.addWorkUnity(Integer.toUnsignedLong(unityId));
		}
	}

	private Date readDate(final String firstMessage, final Scanner scan) {
		Date hiringDate = null;
		
		boolean isValidDate = false;
		while (!isValidDate) {
			System.out.println(firstMessage);
			final String hiringDateString = scan.next();
			
			try {
				hiringDate = new SimpleDateFormat("dd/MM/yyyy").parse(hiringDateString);
				isValidDate = true;
			} catch (Exception ex) {
				System.out.println("This isn't a valid date, example 21/12/2020.");
				isValidDate = false;
			}
		}
		
		return hiringDate; 
	}
	
	public void userUpdateEmployee(final Scanner scan) {
		System.out.println("Type the ID: ");
		final Long id = Integer.toUnsignedLong(scan.nextInt());
		
		System.out.println("Type the new name: ");
		final String name = scan.next();
		System.out.println("Type the new CPF: ");
		final String cpf = scan.next();
		System.out.println("Type the new salary: ");
		final String salary = scan.next();
		final Date hiringDate = readDate("Type the new hiringDate (dd/mm/yyyy): ", scan);
		System.out.println("Type the new role ID for this employee: ");
		final Integer roleId = scan.nextInt();
		
		EmployeeEntity updatedEmployee = new EmployeeEntity(id, name, cpf, Double.parseDouble(salary), hiringDate, Integer.toUnsignedLong(roleId));
		
		addWorkUnities(scan, updatedEmployee);
		
		repository.save(updatedEmployee);
		System.out.println();
	}
	
	public void userDeleteEmployee(final Scanner scan) {
		System.out.println("Type the ID: ");
		final Long id = Integer.toUnsignedLong(scan.nextInt());
		
		repository.deleteById(id);
		System.out.println();
	}
	
	public void userListEmployees() {
		Iterable<EmployeeEntity> allEmployees = repository.findAll();
		
		System.out.println();
		allEmployees.forEach(employee -> System.out.println(employee));
		System.out.println();
	}
	
}
