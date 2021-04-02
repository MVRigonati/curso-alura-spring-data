package br.com.alura.spring.data;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.spring.data.service.EmployeeService;
import br.com.alura.spring.data.service.ReportsService;
import br.com.alura.spring.data.service.RoleService;
import br.com.alura.spring.data.service.WorkUnityService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	@Autowired
	private RoleService roleService;
	@Autowired
	private WorkUnityService workUnityService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private ReportsService reportsService;
	
	private static Boolean RUNNING;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		try (Scanner scan = new Scanner(System.in)) {

			RUNNING = true;
			while (RUNNING) {
				System.out.println("Choose your action:");
				System.out.println("00 - Quit");
				System.out.println("01 - Add Role");
				System.out.println("02 - Update Role");
				System.out.println("03 - Delete Role");
				System.out.println("04 - List All Roles");
				
				System.out.println("------------------------");
				System.out.println("11 - Add Employee");
				System.out.println("12 - Update Employee");
				System.out.println("13 - Delete Employee");
				System.out.println("14 - List All Employees");
				System.out.println("15 - List Employees by name");
				System.out.println("16 - List Employees by name, salary and hiring date");
				System.out.println("17 - List Name, CPF and Salary from Employees");
				
				System.out.println("------------------------");
				System.out.println("21 - Add Work Unity");
				System.out.println("22 - Update Work Unity");
				System.out.println("23 - Delete Work Unity");
				System.out.println("24 - List All Work Unities");

				final int action = scan.nextInt();
				if (action == 1) 
					roleService.userCreateRole(scan);
				
				else if (action == 2)
					roleService.userUpdateRole(scan);
				
				else if (action == 3)
					roleService.userDeleteRole(scan);
				
				else if (action == 4)
					roleService.userListRoles();
				
				else if (action == 11) 
					employeeService.userCreateEmployee(scan);
				
				else if (action == 12)
					employeeService.userUpdateEmployee(scan);
				
				else if (action == 13)
					employeeService.userDeleteEmployee(scan);
				
				else if (action == 14)
					employeeService.userListEmployees(scan);
				
				else if (action == 15)
					reportsService.findEmployeeByName(scan);
				
				else if (action == 16)
					reportsService.findEmployeeByNameAndSalaryAndHiringDate(scan);
				
				else if (action == 17)
					reportsService.findNameAndCpfAndSalaryFromEmployee();
				
				else if (action == 21) 
					workUnityService.userCreateWorkUnity(scan);
				
				else if (action == 22)
					workUnityService.userUpdateWorkUnity(scan);
				
				else if (action == 23)
					workUnityService.userDeleteWorkUnity(scan);
				
				else if (action == 24)
					workUnityService.userListWorkUnities();
				
				else
					RUNNING = false;
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		System.exit(0);

	}

}
