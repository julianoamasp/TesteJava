package com.example.VendasSpring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.VendasSpring.model.Produto;

public class ProdutoDAO {

	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet res = null;
	
	public Produto buscarPeloId(int id) throws SQLException {
		String sql = "select * from produto where idproduto = "+id+";";
		conn = ConnectionFactoy.conectar();
		pstm = conn.prepareStatement(sql);
		res = pstm.executeQuery();
		
		Produto produto = new Produto();
		produto.setId(-1);
		
		while(res.next()) {
			produto.setId(res.getInt("idproduto"));
			produto.setNome(res.getString("nome"));
			produto.setValor(res.getDouble("valor"));
		}
		return produto;
	}

	public ArrayList<Produto> listarProdutos() throws Exception{
		String sql = "select * from produto;";
		conn = ConnectionFactoy.conectar();
		pstm = conn.prepareStatement(sql);
		res = pstm.executeQuery();
		
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		
		while(res.next()) {
			produtos.add(new Produto(
					res.getInt("idproduto"),
					res.getString("nome"),
					res.getDouble("valor")
					));
		}
		return produtos;
	}
	
	public static void main(String args[]) {

		ProdutoDAO produtoDAO = new ProdutoDAO();
		try {
		ArrayList<Produto> produtos = produtoDAO.listarProdutos();
		for (Produto produto : produtos) {
			System.out.println(produto.getNome()+" "+produto.getValor());
		}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
