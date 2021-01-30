package br.com.alura.spring.data.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.RoleEntity;
import br.com.alura.spring.data.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	public void userCreateRole(final Scanner scan) {
		System.out.println("Type the description: ");
		final String roleDescription = scan.next();
		
		roleRepository.save(new RoleEntity(roleDescription));
		System.out.println();
	}
	
	public void userUpdateRole(final Scanner scan) {
		System.out.println("Type the ID: ");
		final Long roleId = Integer.toUnsignedLong(scan.nextInt());
		
		System.out.println("Type the new description: ");
		final String roleDescription = scan.next();
		
		roleRepository.save(new RoleEntity(roleId, roleDescription));
		System.out.println();
	}
	
	public void userDeleteRole(final Scanner scan) {
		System.out.println("Type the ID: ");
		final Long roleId = Integer.toUnsignedLong(scan.nextInt());
		
		roleRepository.deleteById(roleId);
		System.out.println();
	}
	
	public void userListRoles() {
		Iterable<RoleEntity> allRoles = roleRepository.findAll();
		
		System.out.println();
		allRoles.forEach(role -> System.out.println(role));
		System.out.println();
	}
	
}
