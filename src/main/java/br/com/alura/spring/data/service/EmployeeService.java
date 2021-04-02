package br.com.alura.spring.data.service;

import static org.springframework.data.domain.Sort.Direction.ASC;

import java.util.Date;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.EmployeeEntity;
import br.com.alura.spring.data.repository.EmployeeRepository;
import br.com.alura.spring.data.util.DateUtil;

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
		final Date hiringDate = DateUtil.readDate("Type the hiringDate (dd/mm/yyyy): ", scan);
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

	public void userUpdateEmployee(final Scanner scan) {
		System.out.println("Type the ID: ");
		final Long id = Integer.toUnsignedLong(scan.nextInt());
		
		System.out.println("Type the new name: ");
		final String name = scan.next();
		System.out.println("Type the new CPF: ");
		final String cpf = scan.next();
		System.out.println("Type the new salary: ");
		final String salary = scan.next();
		final Date hiringDate = DateUtil.readDate("Type the new hiringDate (dd/mm/yyyy): ", scan);
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
	
	public void userListEmployees(final Scanner scan) {
		
		System.out.println("Enter the page you want to see.");
		final int page = scan.nextInt();
		
		if (page > 0) {

			Pageable pageConfig = PageRequest.of((page - 1), 5, Sort.by(ASC, "name"));
			Page<EmployeeEntity> allEmployeesPage = repository.findAll(pageConfig);

			final int lastShowingIndex = page * allEmployeesPage.getSize();
			final int firstShowingIndex = lastShowingIndex - allEmployeesPage.getSize() + 1;
			System.out.println();
			System.out.println("Showing " + firstShowingIndex + " to " + lastShowingIndex +
					" / Total: " + allEmployeesPage.getTotalElements());
			allEmployeesPage.forEach(employee -> System.out.println(employee));
			System.out.println();

		} else {
			System.out.println();
			System.out.println("Page number must be greater than 0.");
			System.out.println();
		}
		 
	}
	
}
