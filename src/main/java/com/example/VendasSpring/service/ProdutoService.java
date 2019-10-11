package com.example.VendasSpring.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.example.VendasSpring.dao.ProdutoDAO;
import com.example.VendasSpring.model.Produto;

public class ProdutoService {

	public Produto buscarPeloId(int id) throws SQLException {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		return produtoDAO.buscarPeloId(id);
	}

	public ArrayList<Produto> listarProdutos() throws Exception{
		ProdutoDAO produtoDAO = new ProdutoDAO();
		ArrayList<Produto> produtos = produtoDAO.listarProdutos();
		return produtos;
	}
	
	public static void main(String args[]) {
		ProdutoService produtoService = new ProdutoService();
		try {
		Produto produto = produtoService.buscarPeloId(1);
		System.out.print(produto.getNome());
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}
