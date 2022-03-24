package com.app01.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app01.domain.Cidade;
import com.app01.repositories.CidadeRepository;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository repo;
	
	
	public List<Cidade> findByEstado(Integer estadoId){
		return repo.findCidadesByEstadoId(estadoId) ;
	}

}
