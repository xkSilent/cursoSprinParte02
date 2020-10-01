package com.app01.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app01.domain.Cliente;
import com.app01.repositories.ClienteRepository;
import com.app01.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objet não encontrado ! id:" +id+
				"Tipo: " + Cliente.class.getName()));
	}

}
