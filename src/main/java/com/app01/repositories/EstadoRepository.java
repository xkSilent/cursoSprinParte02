package com.app01.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app01.domain.Estado;
@Repository
public interface EstadoRepository  extends JpaRepository<Estado, Integer>{
	
	@Transactional
	public List<Estado> findAllByOrderByNome();

}
