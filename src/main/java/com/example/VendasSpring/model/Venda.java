package com.example.VendasSpring.model;

public class Venda {

	public int id;
	public int idcliente;
	public int idproduto;
	public double valortotal;
	private Cliente cliente;
	private Produto produto;
	
	public Venda() {}
	
	public Venda(int id, int idcliente, int idproduto, double valortotal) {
		this.id = id;
		this.idcliente = idcliente;
		this.idproduto = idproduto;
		this.valortotal = valortotal;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdcliente() {
		return idcliente;
	}
	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}
	public int getIdproduto() {
		return idproduto;
	}
	public void setIdproduto(int idproduto) {
		this.idproduto = idproduto;
	}
	public double getValortotal() {
		return valortotal;
	}
	public void setValortotal(double valortotal) {
		this.valortotal = valortotal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	
	

}
