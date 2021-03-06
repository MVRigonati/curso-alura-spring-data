package br.com.alura.spring.data.orm;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ROLES")
public class RoleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	
	@OneToMany
	@JoinColumn(name = "role_id")
	private List<EmployeeEntity> employees;
	
	public RoleEntity() {
		
	}
	
	public RoleEntity(final Long id) {
		this.id= id;
	}
	
	public RoleEntity(final Long id, final String description) {
		this.id= id;
		this.description = description;
	}
	
	public RoleEntity(final String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<EmployeeEntity> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeEntity> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", description=" + description + "]";
	}

}
