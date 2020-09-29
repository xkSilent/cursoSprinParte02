package com.app01;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app01.domain.Categoria;
import com.app01.domain.Produto;
import com.app01.repositories.CategoriaRepository;
import com.app01.repositories.ProdutoRepository;

@SpringBootApplication
public class CursoSpringMvcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursoSpringMvcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria();
	    cat1.setNome("Informatica");
		Categoria cat2 = new Categoria();
		cat2.setNome("Escritório");
		
		Produto p1 = new Produto();
		p1.setNome("Computador");
		p1.setPreco(2000.00);
		Produto p2 = new Produto();
		p2.setNome("Impressora");
		p2.setPreco(800.00);
		Produto p3 = new Produto();
		p3.setNome("Mouse");
		p3.setPreco(80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
	}



}
