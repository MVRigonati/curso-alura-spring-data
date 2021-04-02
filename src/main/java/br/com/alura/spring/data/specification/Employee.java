package br.com.alura.spring.data.specification;

import java.util.Date;

import org.springframework.data.jpa.domain.Specification;

import br.com.alura.spring.data.orm.EmployeeEntity;

public class Employee {
	
	public static Specification<EmployeeEntity> nameLike(final String name) {
		return (root, criteriaQuery, criteriaBuilder) ->
			criteriaBuilder.like(root.get("name"), "%" + name + "%");
	}
	
	public static Specification<EmployeeEntity> salaryGreaterThan(final Double salary) {
		return (root, criteriaQuery, criteriaBuilder) ->
			criteriaBuilder.greaterThan(root.get("salary"), salary);
	}
	
	public static Specification<EmployeeEntity> cpf(final String cpf) {
		return (root, criteriaQuery, criteriaBuilder) ->
			criteriaBuilder.equal(root.get("cpf"), cpf);
	}
	
	public static Specification<EmployeeEntity> hiringDateGreaterThan(final Date date) {
		return (root, criteriaQuery, criteriaBuilder) ->
			criteriaBuilder.greaterThan(root.get("hiringDate"), date);
	}

}
