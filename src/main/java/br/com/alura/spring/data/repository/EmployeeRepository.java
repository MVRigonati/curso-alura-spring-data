package br.com.alura.spring.data.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.alura.spring.data.orm.EmployeeEntity;

public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Long> {
	
	public List<EmployeeEntity> findByNameLike(String name);
	
	@Query("SELECT e FROM EmployeeEntity e WHERE e.name = :name AND e.salary >= :salary AND e.hiringDate = :hiringDate")
	public List<EmployeeEntity> findBy(@Param(value = "name") String name,
			@Param(value = "salary") Double salary,
			@Param(value = "hiringDate") Date hiringDate);
	
	/* For native queries
	@Query(value = "SELECT ...", nativeQuery = true)
	*/
}
