package com.app01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app01.domain.Endereco;
@Repository
public interface EnderecoRepository  extends JpaRepository<Endereco, Integer>{

}
