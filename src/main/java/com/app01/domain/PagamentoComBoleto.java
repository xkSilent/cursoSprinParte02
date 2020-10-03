package com.app01.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.app01.domain.enums.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class PagamentoComBoleto extends Pagamento{
	private static final long serialVersionUID = 1L;
	@JsonFormat(pattern = "dd/MM/yyy")
	private Date dataVencimento;
	@JsonFormat(pattern = "dd/MM/yyy")
	private Date dataPagamento;
	
	public PagamentoComBoleto() {}

	

	public PagamentoComBoleto(int id, EstadoPagamento estado, Pedido pedido, Date dataPagamento, Date dataVencimento) {
		super(id, estado, pedido);
		this.dataPagamento = dataPagamento;
		this.dataVencimento = dataVencimento;
	}
	
	public PagamentoComBoleto(Date dataPagamento, Date dataVencimento) {
		
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
	

}
