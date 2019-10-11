package com.example.VendasSpring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.example.VendasSpring.model.Cliente;

public class ClienteDAO {
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet res = null;
	
	public Cliente buscarPeloId(int id) throws SQLException {
		String sql = "select * from cliente where idcliente = "+id+";";
		conn = ConnectionFactoy.conectar();
		pstm = conn.prepareStatement(sql);
		res = pstm.executeQuery();
		
		Cliente cliente = new Cliente();
		cliente.setIdCliente(-1);
		
		while(res.next()) {
			cliente.setIdCliente(res.getInt("idcliente"));
			cliente.setNome(res.getString("nome"));
			cliente.setCpf(res.getString("cpf"));
			cliente.setDatanascimento(res.getString("datanascimento"));
			cliente.setSexo(res.getString("sexo"));
		}
		return cliente;
	}

	public ArrayList<Cliente> listarClientes() throws Exception{
		String sql = "select * from cliente;";
		conn = ConnectionFactoy.conectar();
		pstm = conn.prepareStatement(sql);
		res = pstm.executeQuery();
		
		ArrayList<Cliente> contatos = new ArrayList<Cliente>();
		
		while(res.next()) {
			contatos.add(new Cliente(
					res.getInt("idcliente"),
					res.getString("nome"),
					res.getString("cpf"),
					res.getString("datanascimento"),
					res.getString("sexo")
					));
		}
		return contatos;
	}
	
	public static void main(String args[]) {
		
		ClienteDAO clienteDAo = new ClienteDAO();
		try {
		Cliente cliente = clienteDAo.buscarPeloId(1);
		System.out.println(cliente.getNome());
		}catch (Exception e) {
			// TODO: handle exception
		}
		/*
		ClienteDAO clienteDAO = new ClienteDAO();
		try {
		ArrayList<Cliente> clientes = clienteDAO.listarClientes();
		for (Cliente cliente : clientes) {
			System.out.println(cliente.getNome());
		}
		}catch (Exception e) {
			// TODO: handle exception
		}*/
		
	}
}
