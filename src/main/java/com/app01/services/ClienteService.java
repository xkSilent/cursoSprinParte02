package com.app01.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app01.domain.Cidade;
import com.app01.domain.Cliente;
import com.app01.domain.Endereco;
import com.app01.domain.enums.TipoCliente;
import com.app01.dto.ClienteDTO;
import com.app01.dto.ClienteNewDTO;
import com.app01.repositories.ClienteRepository;
import com.app01.repositories.EnderecoRepository;
import com.app01.services.exceptions.DataIntegrityException;
import com.app01.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repo;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado ! id:" +id+
				"Tipo: " + Cliente.class.getName()));
	}
	
	@Transactional
	public Cliente insert(Cliente obj) {
		obj = repo.save(obj);
		enderecoRepository.saveAll(obj.getEnderecos());
		return obj;
	}
	
	public Cliente update(Cliente obj) {
		Cliente newObj =find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
		repo.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível realizar essa ação");
		}
	}
	
	public List<Cliente> findAll(){
		return repo.findAll();
	}
	
	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy) ;
		
		return repo.findAll(pageRequest);
	}
	
	public Cliente fromDTO(ClienteDTO objDto) {
		Cliente cli = new Cliente();
		cli.setNome(objDto.getNome());
		cli.setEmail(objDto.getEmail());
		cli.setSenha(null);
		return cli;
	}
	
	public void updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}
	
	public Cliente fromDTO(ClienteNewDTO objDto) {
		Cliente cli = new Cliente();
		cli.setNome(objDto.getNome());
		cli.setEmail(objDto.getEmail());
		cli.setCpfOuCnpj(objDto.getCpfOuCnpj());
		cli.setTipo(TipoCliente.toEnum(objDto.getTipo()));
		cli.setSenha(pe.encode(objDto.getSenha()));
		
		Cidade cid = new Cidade(objDto.getCidadeId(),null,null);
		Endereco end = new Endereco();
		end.setLogadouro(objDto.getLogadouro());
		end.setNumero(objDto.getNumero());
		end.setComplemento(objDto.getComplemento());
		end.setBairro(objDto.getBairro());
		end.setCep(objDto.getCep());
		end.setCliente(cli);
		end.setCidade(cid);
		
		cli.getEnderecos().add(end);
		
		cli.getTelefones().add(objDto.getTelefone1());
		if(objDto.getTelefone2() != null) {
			cli.getTelefones().add(objDto.getTelefone2());
		}
		if(objDto.getTelefone3() != null) {
			cli.getTelefones().add(objDto.getTelefone3());
		}
		return cli;
	}
}
