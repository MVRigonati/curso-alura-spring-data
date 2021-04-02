package br.com.alura.spring.data.orm;

/**
 * 	This interface has only the methods to be use in a
 * Projection query from Employees table.
 * 	The name "Name", "Cpf" and "Salary" must match the
 * field names of class EmployeeEntity.
 * 	This could be done with a class too, it should implement
 * a constructor receiving the attributes in the same order
 * used in the query, and also have the attributes and the
 * getters and setters.
 *
 */
public interface MainEmployeeAttributesProjection {
	
	public String getName();
	public String getCpf();
	public Double getSalary();

}
