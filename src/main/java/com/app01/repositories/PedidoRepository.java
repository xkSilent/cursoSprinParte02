package com.app01.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app01.domain.Cliente;
import com.app01.domain.Pedido;

@Repository
public interface PedidoRepository  extends JpaRepository<Pedido, Integer>{

	Page<Pedido> findByCliente(Cliente cliente, Pageable pageRequest);

}
