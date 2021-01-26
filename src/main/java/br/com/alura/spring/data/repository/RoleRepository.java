package br.com.alura.spring.data.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.alura.spring.data.orm.RoleEntity;

public interface RoleRepository extends CrudRepository<RoleEntity, Long> {

}
