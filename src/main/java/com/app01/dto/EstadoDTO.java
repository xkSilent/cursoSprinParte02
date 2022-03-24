package com.app01.dto;

import java.io.Serializable;

import com.app01.domain.Estado;

public class EstadoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	
	public EstadoDTO() {}

	public EstadoDTO(Estado estado) {
		id = estado.getId();
		nome = estado.getNome();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
