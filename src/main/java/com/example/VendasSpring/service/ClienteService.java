package com.example.VendasSpring.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.example.VendasSpring.dao.ClienteDAO;
import com.example.VendasSpring.model.Cliente;

public class ClienteService {
	
	public Cliente buscarPeloId(int id) throws SQLException {
		ClienteDAO clienteDAO = new ClienteDAO();
		return clienteDAO.buscarPeloId(id);
	}

	public ArrayList<Cliente> listarClientes() throws Exception{
		ClienteDAO clienteDAO = new ClienteDAO();
		ArrayList<Cliente> clientes = clienteDAO.listarClientes();
		return clientes;
	}
	
	public static void main(String args[]) {
		
		ClienteService clienteService = new ClienteService();
		try {
		Cliente cliente = clienteService.buscarPeloId(1);
		System.out.print(cliente.getNome());
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		/*
		ClienteService clienteService = new ClienteService();
		try {
		ArrayList<Cliente> clientes = clienteService.listarClientes();
		
		for (Cliente cliente : clientes) {
			System.out.println(cliente.getIdCliente());
		}

		}catch (Exception e) {
			// TODO: handle exception
		}*/
	}

}
