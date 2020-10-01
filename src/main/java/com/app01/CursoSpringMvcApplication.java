package com.app01;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app01.domain.Categoria;
import com.app01.domain.Cidade;
import com.app01.domain.Cliente;
import com.app01.domain.Endereco;
import com.app01.domain.Estado;
import com.app01.domain.PagamentoComBoleto;
import com.app01.domain.PagamentoComCartao;
import com.app01.domain.Pedido;
import com.app01.domain.Produto;
import com.app01.domain.enums.EstadoPagamento;
import com.app01.domain.enums.TipoCliente;
import com.app01.repositories.CategoriaRepository;
import com.app01.repositories.CidadeRepository;
import com.app01.repositories.ClienteRepository;
import com.app01.repositories.EnderecoRepository;
import com.app01.repositories.EstadoRepository;
import com.app01.repositories.PagamentoRepository;
import com.app01.repositories.PedidoRepository;
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
	
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;

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
		
		//associando as cidades aos estados
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		// instanciando um cliente
		Cliente cli1 = new Cliente();
		cli1.setNome("Maria Silva");
		cli1.setEmail("maria@gmail.com");
		cli1.setCpfOuCnpj("123456789-00");
		cli1.setTipo(TipoCliente.PESSOAFISICA);
		//associando os telefone ao cliente
		cli1.getTelefones().addAll(Arrays.asList("12 12345678", "12 98876543"));
		
		//instanciando os enderecos
		Endereco e1 = new Endereco();
		e1.setLogadouro("Rua Flores");
		e1.setNumero("300");
		e1.setComplemento("Apto 303");
		e1.setBairro("Jardim");
		e1.setCep("12345678");
		e1.setCliente(cli1);
		e1.setCidade(c1);
		
		Endereco e2 = new Endereco();
		e2.setLogadouro("Avenida Matos");
		e2.setNumero("105");
		e2.setComplemento("sal 303");
		e2.setBairro("Centro");
		e2.setCep("87654321");
		e2.setCliente(cli1);
		e2.setCidade(c2);
		
		//Associando os enderecos ao cliente
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		//salvando as categorias no Banco de dados
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		//salvando os produtos no banco de dados
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		//salvando os estado no banco de dados
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		//salvando as cidades no banco de dados
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		//Salvando Clientes e Endereços n obanco de dados
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
		//Criando formatação de data
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		// instanciando os pedidos 1 e 2;
		Pedido ped1 = new Pedido();
		ped1.setInstante(sdf.parse("30/09/2017 10:32"));
		ped1.setCliente(cli1);
		ped1.setEnderecoDeEntrega(e1);
		Pedido ped2 = new Pedido();
		ped2.setInstante(sdf.parse("10/12/2017 10:32"));
		ped2.setCliente(cli1);
		ped2.setEnderecoDeEntrega(e2);
		
		//Instanciando os pagamentos
		PagamentoComCartao pagto1 = new PagamentoComCartao();
		pagto1.setEstadoPagamento(EstadoPagamento.QUITADO);
		pagto1.setPedido(ped1);
		pagto1.setNumeroDeParcelas(6);
		
		ped1.setPagamento(pagto1);
		
		PagamentoComBoleto pagto2 = new PagamentoComBoleto();
		pagto2.setEstadoPagamento(EstadoPagamento.PENDENTE);
		pagto2.setPedido(ped2);
		pagto2.setDataVencimento(sdf.parse("20/10/20017 00:00"));
		pagto2.setDataPagamento(null);
		
		ped2.setPagamento(pagto2);
		
		//Associando o pedido ao cliente
		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
		
		// salvando os pedidos e pagamentos no Banco de Dados
		pedidoRepository.saveAll(Arrays.asList(ped1,ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1,pagto2));
	}	

}
