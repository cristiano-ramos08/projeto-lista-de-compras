package com.capgemini.model;


import java.math.BigDecimal;
import java.util.Date;

public class Compra {
	
	private Integer id;
	private String nome, descricao;
	private String prioridade;
	private BigDecimal preco;
	private byte quantidade;
	private Date dataLimite;
	
	public Compra(Integer id, String nome, String descricao, String prioridade, BigDecimal preco, byte quantidade, Date dataLimite) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.prioridade = prioridade;
		this.preco = preco;
		this.quantidade = quantidade;
		this.dataLimite = dataLimite;
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


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getPrioridade() {
		return prioridade;
	}


	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}


	public BigDecimal getPreco() {
		return preco;
	}


	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}


	public byte getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(byte quantidade) {
		this.quantidade = quantidade;
	}


	public Date getDataLimite() {
		return dataLimite;
	}


	public void setDataLimite(Date dataLimite) {
		this.dataLimite = dataLimite;
	}


	public String toString() {
		return "Compra [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", prioridade=" + prioridade
				+ ", preco=" + preco + ", quantidade=" + quantidade + ", dataLimite=" + dataLimite + "]";
	}


}