package br.com.alura.spring.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.spring.data.orm.RoleEntity;
import br.com.alura.spring.data.repository.RoleRepository;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	@Autowired
	private RoleRepository roleRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		roleRepository.save(new RoleEntity("Developer"));
		
	}

}
