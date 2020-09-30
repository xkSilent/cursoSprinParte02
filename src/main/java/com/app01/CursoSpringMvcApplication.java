package com.app01;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app01.domain.Categoria;
import com.app01.domain.Cidade;
import com.app01.domain.Estado;
import com.app01.domain.Produto;
import com.app01.repositories.CategoriaRepository;
import com.app01.repositories.CidadeRepository;
import com.app01.repositories.EstadoRepository;
import com.app01.repositories.ProdutoRepository;

@SpringBootApplication
public class CursoSpringMvcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursoSpringMvcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//instanciando categorias
		Categoria cat1 = new Categoria();
	    cat1.setNome("Informatica");
		Categoria cat2 = new Categoria();
		cat2.setNome("Escritório");
		
		//instanciando produtos
		Produto p1 = new Produto();
		p1.setNome("Computador");
		p1.setPreco(2000.00);
		Produto p2 = new Produto();
		p2.setNome("Impressora");
		p2.setPreco(800.00);
		Produto p3 = new Produto();
		p3.setNome("Mouse");
		p3.setPreco(80.00);
		
		//adicionando produtos as respectivas categorias
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		// adicionando categorias aos respectivos produtos
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		//instanciando estados
		Estado est1 = new Estado();
		est1.setNome("Minas Gerais");
		Estado est2 = new Estado();
		est2.setNome("São Paulo");
		
		//instanciando as cidades
		Cidade c1 = new Cidade();
		c1.setNome("Uberlandia");
		c1.setEstado(est1);
		Cidade c2 = new Cidade();
		c2.setNome("São Paulo");
		c2.setEstado(est2);
		Cidade c3 = new Cidade();
		c3.setNome("Campinas");
		c3.setEstado(est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		//salvando as categorias no Banco de dados
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		//salvando os produtos no banco de dados
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		//salvando os estado no banco de dados
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		//salvando as cidades no banco de dados
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
	}

	


}
