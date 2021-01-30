package br.com.alura.spring.data.orm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEES")
public class EmployeeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String cpf;
	private Double salary;
	private Date hiringDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private RoleEntity role;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "employee_unity")
	private List<WorkUnityEntity> unities;
	
	public EmployeeEntity() {
		
	}
	
	public EmployeeEntity(Long id, String name, String cpf, Double salary, Date hiringDate, Long roleId) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.salary = salary;
		this.hiringDate = hiringDate;
		this.role = new RoleEntity(roleId);
	}
	
	public EmployeeEntity(String name, String cpf, Double salary, Date hiringDate, Long roleId) {
		this.name = name;
		this.cpf = cpf;
		this.salary = salary;
		this.hiringDate = hiringDate;
		this.role = new RoleEntity(roleId);
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Date getHiringDate() {
		return hiringDate;
	}

	public void setHiringDate(Date hiringDate) {
		this.hiringDate = hiringDate;
	}
	
	public RoleEntity getRole() {
		return role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}

	public List<WorkUnityEntity> getUnities() {
		return Collections.unmodifiableList(unities);
	}

	public void setUnities(List<WorkUnityEntity> unities) {
		this.unities = unities;
	}
	
	public void addWorkUnity(Long unityId) {
		if (this.unities == null) {
			this.unities = new ArrayList<>();
		}
		this.unities.add(new WorkUnityEntity(unityId));
	}

	@Override
	public String toString() {
		return "EmployeeEntity [id=" + id + ", name=" + name + ", cpf=" + cpf + ", salary=" + salary + ", hiringDate="
				+ hiringDate + ", role=" + role.getDescription() + ", unities=" + unities.toString() + "]";
	}

}
