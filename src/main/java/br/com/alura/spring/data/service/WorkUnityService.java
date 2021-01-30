package br.com.alura.spring.data.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.WorkUnityEntity;
import br.com.alura.spring.data.repository.WorkUnityRepository;

@Service
public class WorkUnityService {

	@Autowired
	private WorkUnityRepository repository;
	
	public void userCreateWorkUnity(final Scanner scan) {
		System.out.println("Type the description: ");
		final String description = scan.next();
		System.out.println("Type the address: ");
		final String address = scan.next();
		
		repository.save(new WorkUnityEntity(description, address));
		System.out.println();
	}
	
	public void userUpdateWorkUnity(final Scanner scan) {
		System.out.println("Type the ID: ");
		final Long id = Integer.toUnsignedLong(scan.nextInt());
		
		System.out.println("Type the new description: ");
		final String description = scan.next();
		System.out.println("Type the new address: ");
		final String adress = scan.next();
		
		repository.save(new WorkUnityEntity(id, description, adress));
		System.out.println();
	}
	
	public void userDeleteWorkUnity(final Scanner scan) {
		System.out.println("Type the ID: ");
		final Long id = Integer.toUnsignedLong(scan.nextInt());
		
		repository.deleteById(id);
		System.out.println();
	}
	
	public void userListWorkUnities() {
		Iterable<WorkUnityEntity> allWorkUnities = repository.findAll();
		
		System.out.println();
		allWorkUnities.forEach(workUnity -> System.out.println(workUnity));
		System.out.println();
	}
	
}
