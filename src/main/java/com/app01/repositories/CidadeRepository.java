package com.app01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app01.domain.Cidade;
@Repository
public interface CidadeRepository  extends JpaRepository<Cidade, Integer>{

}
