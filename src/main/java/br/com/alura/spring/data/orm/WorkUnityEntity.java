package br.com.alura.spring.data.orm;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "WORK_UNITIES")
public class WorkUnityEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;
	private String address;
	
	@ManyToMany(mappedBy = "unities")
	private List<EmployeeEntity> employees;
	
	public WorkUnityEntity() {
		
	}
	
	public WorkUnityEntity(Long id) {
		this.id = id;
	}

	public WorkUnityEntity(Long id, String description, String address) {
		this.id = id;
		this.description = description;
		this.address = address;
	}
	
	public WorkUnityEntity(String description, String address) {
		this.description = description;
		this.address = address;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public List<EmployeeEntity> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeEntity> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "WorkUnityEntity [id=" + id + ", description=" + description + ", address=" + address + "]";
	}

}
