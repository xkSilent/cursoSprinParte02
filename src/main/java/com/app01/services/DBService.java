package com.app01.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.app01.domain.Categoria;
import com.app01.domain.Cidade;
import com.app01.domain.Cliente;
import com.app01.domain.Endereco;
import com.app01.domain.Estado;
import com.app01.domain.ItemPedido;
import com.app01.domain.PagamentoComBoleto;
import com.app01.domain.PagamentoComCartao;
import com.app01.domain.Pedido;
import com.app01.domain.Produto;
import com.app01.domain.enums.EstadoPagamento;
import com.app01.domain.enums.Perfil;
import com.app01.domain.enums.TipoCliente;
import com.app01.repositories.CategoriaRepository;
import com.app01.repositories.CidadeRepository;
import com.app01.repositories.ClienteRepository;
import com.app01.repositories.EnderecoRepository;
import com.app01.repositories.EstadoRepository;
import com.app01.repositories.ItemPedidoRepository;
import com.app01.repositories.PagamentoRepository;
import com.app01.repositories.PedidoRepository;
import com.app01.repositories.ProdutoRepository;

@Service
public class DBService {
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
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	public void instantiateTestDatabase() throws ParseException {
		//instanciando categorias
				Categoria cat1 = new Categoria();
			    cat1.setNome("Informatica");
				Categoria cat2 = new Categoria();
				cat2.setNome("Escritório");
				Categoria cat3 = new Categoria();
				cat3.setNome("Cama mesa e Banho");
				Categoria cat4 = new Categoria();
				cat4.setNome("Acessórios");
				Categoria cat5 = new Categoria();
				cat5.setNome("Computadores");
				Categoria cat6 = new Categoria();
				cat6.setNome("Telefonia");
				Categoria cat7 = new Categoria();
				cat7.setNome("Ferramentas");
				
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
				Produto p4 = new Produto(); 
				p4.setNome("Roteador");
				p4.setPreco(100.00);
				Produto p5 = new Produto();
				p5.setNome("Headset");
				p5.setPreco(90.00);
				Produto p6 = new Produto();
				p6.setNome("Grampeador");
				p6.setPreco(10.00);
				Produto p7 = new Produto();
				p7.setNome("Celular");
				p7.setPreco(1000.00);
				Produto p8 = new Produto();
				p8.setNome("Multimetro");
				p8.setPreco(100.00);
				Produto p12 = new Produto();
				p12.setNome("Produto 12");
				p12.setPreco(10.00);
				Produto p13 = new Produto();
				p13.setNome("Produto 13");
				p13.setPreco(10.00);
				Produto p14 = new Produto();
				p14.setNome("Produto 14");
				p14.setPreco(10.00);
				Produto p15 = new Produto();
				p15.setNome("Produto 15");
				p15.setPreco(10.00);
				Produto p16 = new Produto();
				p16.setNome("Produto 16");
				p16.setPreco(10.00);
				Produto p17 = new Produto();
				p17.setNome("Produto 17");
				p17.setPreco(10.00);
				Produto p18 = new Produto();
				p18.setNome("Produto 18");
				p18.setPreco(10.00);
				Produto p19 = new Produto();
				p19.setNome("Produto 19");
				p19.setPreco(10.00);
				Produto p20 = new Produto();
				p20.setNome("Produto 20");
				p20.setPreco(10.00);
				Produto p21 = new Produto();
				p21.setNome("Produto 21");
				p21.setPreco(10.00);
				Produto p22 = new Produto();
				p22.setNome("Produto 22");
				p22.setPreco(10.00);
				Produto p23 = new Produto();
				p23.setNome("Produto 23");
				p23.setPreco(10.00);
				Produto p24 = new Produto();
				p24.setNome("Produto 24");
				p24.setPreco(10.00);
				Produto p25 = new Produto();
				p25.setNome("Produto 25");
				p25.setPreco(10.00);
				Produto p26 = new Produto();
				p26.setNome("Produto 26");
				p26.setPreco(10.00);
				Produto p27 = new Produto();
				p27.setNome("Produto 27");
				p27.setPreco(10.00);
				Produto p28 = new Produto();
				p28.setNome("Produto 28");
				p28.setPreco(10.00);
				Produto p29 = new Produto();
				p29.setNome("Produto 29");
				p29.setPreco(10.00);
				Produto p30 = new Produto();
				p30.setNome("Produto 30");
				p30.setPreco(10.00);
				Produto p31 = new Produto();
				p31.setNome("Produto 31");
				p31.setPreco(10.00);
				Produto p32 = new Produto();
				p32.setNome("Produto 32");
				p32.setPreco(10.00);
				Produto p33 = new Produto();
				p33.setNome("Produto 33");
				p33.setPreco(10.00);
				Produto p34 = new Produto();
				p34.setNome("Produto 34");
				p34.setPreco(10.00);
				Produto p35 = new Produto();
				p35.setNome("Produto 35");
				p35.setPreco(10.00);
				Produto p36 = new Produto();
				p36.setNome("Produto 36");
				p36.setPreco(10.00);
				Produto p37 = new Produto();
				p37.setNome("Produto 37");
				p37.setPreco(10.00);
				Produto p38 = new Produto();
				p38.setNome("Produto 38");
				p38.setPreco(10.00);
				Produto p39 = new Produto();
				p39.setNome("Produto 39");
				p39.setPreco(10.00);
				Produto p40 = new Produto();
				p40.setNome("Produto 40");
				p40.setPreco(10.00);
				Produto p41 = new Produto();
				p41.setNome("Produto 41");
				p41.setPreco(10.00);
				Produto p42 = new Produto();
				p42.setNome("Produto 42");
				p42.setPreco(10.00);
				Produto p43 = new Produto();
				p43.setNome("Produto 43");
				p43.setPreco(10.00);
				Produto p44 = new Produto();
				p44.setNome("Produto 44");
				p44.setPreco(10.00);
				Produto p45 = new Produto();
				p45.setNome("Produto 45");
				p45.setPreco(10.00);
				Produto p46 = new Produto();
				p46.setNome("Produto 46");
				p46.setPreco(10.00);
				Produto p47 = new Produto();
				p47.setNome("Produto 47");
				p47.setPreco(10.00);
				Produto p48 = new Produto();
				p48.setNome("Produto 48");
				p48.setPreco(10.00);
				Produto p49 = new Produto();
				p49.setNome("Produto 49");
				p49.setPreco(10.00);
				Produto p50 = new Produto();
				p50.setNome("Produto 50");
				p50.setPreco(10.00);

				cat1.getProdutos().addAll(Arrays.asList(p12, p13, p14, p15, p16, p17, p18, p19, p20,
				p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31, p32, p34, p35, p36, p37, p38,
				p39, p40, p41, p42, p43, p44, p45, p46, p47, p48, p49, p50));

				p12.getCategorias().add(cat1);
				p13.getCategorias().add(cat1);
				p14.getCategorias().add(cat1);
				p15.getCategorias().add(cat1);
				p16.getCategorias().add(cat1);
				p17.getCategorias().add(cat1);
				p18.getCategorias().add(cat1);
				p19.getCategorias().add(cat1);
				p20.getCategorias().add(cat1);
				p21.getCategorias().add(cat1);
				p22.getCategorias().add(cat1);
				p23.getCategorias().add(cat1);
				p24.getCategorias().add(cat1);
				p25.getCategorias().add(cat1);
				p26.getCategorias().add(cat1);
				p27.getCategorias().add(cat1);
				p28.getCategorias().add(cat1);
				p29.getCategorias().add(cat1);
				p30.getCategorias().add(cat1);
				p31.getCategorias().add(cat1);
				p32.getCategorias().add(cat1);
				p33.getCategorias().add(cat1);
				p34.getCategorias().add(cat1);
				p35.getCategorias().add(cat1);
				p36.getCategorias().add(cat1);
				p37.getCategorias().add(cat1);
				p38.getCategorias().add(cat1);
				p39.getCategorias().add(cat1);
				p40.getCategorias().add(cat1);
				p41.getCategorias().add(cat1);
				p42.getCategorias().add(cat1);
				p43.getCategorias().add(cat1);
				p44.getCategorias().add(cat1);
				p45.getCategorias().add(cat1);
				p46.getCategorias().add(cat1);
				p47.getCategorias().add(cat1);
				p48.getCategorias().add(cat1);
				p49.getCategorias().add(cat1);
				p50.getCategorias().add(cat1);	
				
				
				//adicionando produtos as respectivas categorias
				cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3,p4,p5));
				cat2.getProdutos().addAll(Arrays.asList(p2,p6));
				cat4.getProdutos().addAll(Arrays.asList(p5,p6));
				cat5.getProdutos().addAll(Arrays.asList(p1));
				cat6.getProdutos().addAll(Arrays.asList(p7));
				cat7.getProdutos().addAll(Arrays.asList(p8));
				
				// adicionando categorias aos respectivos produtos
				p1.getCategorias().addAll(Arrays.asList(cat1, cat5));
				p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
				p3.getCategorias().addAll(Arrays.asList(cat1));
				p4.getCategorias().addAll(Arrays.asList(cat1));
				p5.getCategorias().addAll(Arrays.asList(cat1,cat4));
				p6.getCategorias().addAll(Arrays.asList(cat2, cat4));
				p7.getCategorias().addAll(Arrays.asList(cat6));
				p8.getCategorias().addAll(Arrays.asList(cat7));
				
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
				cli1.setEmail("fsdfelipe_dias@live.com");
				cli1.setCpfOuCnpj("123456789-00");
				cli1.setTipo(TipoCliente.PESSOAFISICA);
				cli1.setSenha(pe.encode("12345"));
				cli1.addPerfil(Perfil.ADMIN);
				// instanciando um cliente
				Cliente cli2 = new Cliente();
				cli2.setNome("Jose Souza");
				cli2.setEmail("felipe_dias@live.com");
				cli2.setCpfOuCnpj("987654321-00");
				cli2.setTipo(TipoCliente.PESSOAFISICA);
				cli2.setSenha(pe.encode("12345"));
				cli2.addPerfil(Perfil.CLIENTE);
				//associando os telefone ao cliente
				cli1.getTelefones().addAll(Arrays.asList("12 12345678", "12 98876543"));
				cli2.getTelefones().addAll(Arrays.asList("13 87654321", "13 88997766"));
				
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
				e2.setCliente(cli2);
				e2.setCidade(c2);
				
				//Associando os enderecos ao cliente
				cli1.getEnderecos().addAll(Arrays.asList(e1));
				cli2.getEnderecos().addAll(Arrays.asList(e2));
				
				//salvando as categorias no Banco de dados
				categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3,cat4,cat5,cat6,cat7));
				//salvando os produtos no banco de dados
				produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8));
				produtoRepository.saveAll(Arrays.asList(p12, p13, p14, p15, p16, p17, p18, p19, p20,
						p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31, p32, p33, p34, p35, p36, p37, p38,
						p39, p40, p41, p42, p43, p44, p45, p46, p47, p48, p49, p50));
				//salvando os estado no banco de dados
				estadoRepository.saveAll(Arrays.asList(est1,est2));
				//salvando as cidades no banco de dados
				cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
				
				//Salvando Clientes e Endereços n obanco de dados
				clienteRepository.saveAll(Arrays.asList(cli1,cli2));
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
				pagto2.setDataVencimento(sdf.parse("20/10/2017 00:00"));
				pagto2.setDataPagamento(null);
				
				ped2.setPagamento(pagto2);
				
				//Associando o pedido ao cliente
				cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
				
				// salvando os pedidos e pagamentos no Banco de Dados
				pedidoRepository.saveAll(Arrays.asList(ped1,ped2));
				pagamentoRepository.saveAll(Arrays.asList(pagto1,pagto2));
				
				//Instanciando os pedidos / Item pedido
				ItemPedido ip1 = new ItemPedido(ped1,p1, 0.00, 1, 2000.00);
				ItemPedido ip2 = new ItemPedido(ped1,p3, 0.00, 2, 80.00);
				ItemPedido ip3 = new ItemPedido(ped2,p2, 0.00, 1, 800.00);
				
				// associando o ItemPedido ao pedido
				ped1.getItens().addAll(Arrays.asList(ip1,ip2));
				ped2.getItens().addAll(Arrays.asList(ip3));
				// associando o ItemPedido ao produto
				p1.getItens().addAll(Arrays.asList(ip1));
				p2.getItens().addAll(Arrays.asList(ip3));
				p3.getItens().addAll(Arrays.asList(ip2));
				
				//Salvando os itens pedidos no banco de dados
				itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2,ip3));
	}

}
