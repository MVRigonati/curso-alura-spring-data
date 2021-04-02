package br.com.alura.spring.data.service;

import static br.com.alura.spring.data.specification.Employee.nameLike;
import static br.com.alura.spring.data.specification.Employee.cpf;
import static org.springframework.data.jpa.domain.Specification.where;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.EmployeeEntity;
import br.com.alura.spring.data.orm.MainEmployeeAttributesProjection;
import br.com.alura.spring.data.repository.EmployeeRepository;
import br.com.alura.spring.data.util.DateUtil;

@Service
public class ReportsService {
	
	@Autowired EmployeeRepository employeeRepository;
	
	public void findEmployeeByName(final Scanner scan) {
		System.out.println("Enter the Employee name to search: ");
		final String nameToSearch = scan.next();
		final List<EmployeeEntity> employees = employeeRepository.findByNameLike("%" + nameToSearch + "%");
		
		System.out.println();
		System.out.println(employees.toString());
		System.out.println();
	}
	
	public void findEmployeeByNameAndSalaryAndHiringDate(final Scanner scan) {
		System.out.println("Enter the Employee name to search: ");
		final String nameToSearch = scan.next();
		System.out.println("Enter the minimum salary to search: ");
		final String salary = scan.next();
		final Date hiringDate = DateUtil.readDate("Enter the hiringDate to search (dd/mm/yyyy): ", scan);
		
		final List<EmployeeEntity> employees = employeeRepository.findBy(nameToSearch,
				Double.parseDouble(salary), hiringDate);
		
		System.out.println();
		System.out.println(employees.toString());
		System.out.println();
	}
	
	public void findNameAndCpfAndSalaryFromEmployee() {
		final List<MainEmployeeAttributesProjection> employees = employeeRepository.findAllNameAndCpfAndSalary();
		
		System.out.println();
		employees.forEach(e -> {
			System.out.println("Name: " + e.getName() + " - CPF: " + e.getCpf() + " - Salary: " + e.getSalary());
		});
		System.out.println();
	}
	
	public void findByNameDynamic(final Scanner scan) {
		
		System.out.println("Enter the name to search");
		String nameToSearch = scan.next();
		
		System.out.println("Enter the CPF to search");
		String cpfToSearch = scan.next();
		
		final List<EmployeeEntity> result = employeeRepository.findAll(where(
				nameLike(nameToSearch)
				.or(cpf(cpfToSearch))
			));
		
		System.out.println();
		result.forEach(System.out::println);
		System.out.println();
		
	}

}
