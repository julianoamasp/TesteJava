package com.example.VendasSpring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.VendasSpring.model.Venda;

public class VendaDAO {

	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet res = null;
	
	public void gerarVenda(Venda venda) throws SQLException {
		String sql = "INSERT INTO `vendas`.`venda`(`idvenda`,`idproduto`,`idcliente`,`valortotal`)VALUES("+venda.getId()+","+venda.getIdproduto()+","+venda.getIdcliente()+","+venda.getValortotal()+");";
		conn = ConnectionFactoy.conectar();
		pstm = conn.prepareStatement(sql);
		pstm.execute();
	}

	
	public ArrayList<Venda> listarVendas() throws Exception{
		String sql = "select * from venda;";
		conn = ConnectionFactoy.conectar();
		pstm = conn.prepareStatement(sql);
		res = pstm.executeQuery();
		
		ArrayList<Venda> vendas = new ArrayList<Venda>();
		
		while(res.next()) {
			vendas.add(new Venda(
					res.getInt("idvenda"),
					res.getInt("idcliente"),
					res.getInt("idproduto"),
					res.getDouble("valortotal")
					));
		}
		return vendas;
	}
	
	public static void main(String args[]) {

		VendaDAO venDAO = new VendaDAO();
		Venda venda = new Venda(0,2,1,2.2);
		try {
			System.out.println("id cli" + venda.getIdcliente()+" idprod"+venda.getIdproduto());
			venDAO.gerarVenda(venda);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		try {
		ArrayList<Venda> vendas = venDAO.listarVendas();
		for (Venda venda : vendas) {
			System.out.println(venda.getValortotal());
		}
		}catch (Exception e) {
			// TODO: handle exception
		}*/
		
	}
}
