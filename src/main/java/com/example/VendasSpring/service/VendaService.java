package com.example.VendasSpring.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.example.VendasSpring.dao.VendaDAO;
import com.example.VendasSpring.model.Cliente;
import com.example.VendasSpring.model.Produto;
import com.example.VendasSpring.model.Venda;

public class VendaService {
	
	public void listarVendas() {
		VendaDAO vendaDAO = new VendaDAO();
		
		try {
		ArrayList<Venda> vendas = vendaDAO.listarVendas();
		
		for (Venda venda : vendas) {
			ClienteService clienteServ = new ClienteService();
			Cliente cliente = clienteServ.buscarPeloId(venda.getIdcliente());
			venda.setCliente(cliente);
			
			ProdutoService produtoServ = new ProdutoService();
			Produto produto = produtoServ.buscarPeloId(venda.getIdproduto());
			venda.setProduto(produto);
			
			System.out.println("id da venda:"+venda.getId() + " Cliente:"+venda.getCliente().getNome() + "nome "+venda.getProduto().getNome()+" "+venda.getValortotal());	
		}
		
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void gerarVenda(Venda venda) throws SQLException {
		VendaDAO vendaDao = new VendaDAO();
		
		vendaDao.gerarVenda(venda);
	}
	
	public static void main(String args[]) {
		
		VendaService vendaService = new VendaService();
		vendaService.listarVendas();
		
		/*
		VendaService venSer = new VendaService();
		Venda venda = new Venda(0,5,5,50.50);
		try {
			venSer.gerarVenda(venda);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}
