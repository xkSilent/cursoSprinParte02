package com.app01.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app01.domain.Categoria;
import com.app01.repositories.CategoriaRepository;
import com.app01.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objet não encontrado ! id:" +id+
				"Tipo: " + Categoria.class.getName()));
	}
	
	public Categoria insert(Categoria obj) {
	
		return repo.save(obj);
	}

}
