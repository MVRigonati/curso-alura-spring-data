package br.com.alura.spring.data.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.alura.spring.data.orm.WorkUnityEntity;

public interface WorkUnityRepository extends CrudRepository<WorkUnityEntity, Long> {
	
}
