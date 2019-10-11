package com.example.VendasSpring.model;

public class Cliente {

	public int idcliente;
	private String nome;
	private String cpf;
	private String datanascimento;
	private String sexo;

	public Cliente(int idcliente, String nome, String cpf, String datanascimento, String sexo) {
		super();
		this.idcliente = idcliente;
		this.nome = nome;
		this.cpf = cpf;
		this.datanascimento = datanascimento;
		this.sexo = sexo;
	}
	public Cliente() {}
	
	public int getIdCliente() {
		return idcliente;
	}
	public void setIdCliente(int idcliente) {
		this.idcliente = idcliente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getDatanascimento() {
		return datanascimento;
	}
	public void setDatanascimento(String datanascimento) {
		this.datanascimento = datanascimento;
	}

}
