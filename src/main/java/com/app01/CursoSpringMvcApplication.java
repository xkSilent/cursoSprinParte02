package com.app01;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app01.domain.Categoria;
import com.app01.repositories.CategoriaRepository;

@SpringBootApplication
public class CursoSpringMvcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursoSpringMvcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria();
	    cat1.setNome("Informatica");
		Categoria cat2 = new Categoria();
		cat2.setNome("Escritório");
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		
	}



}
