package com.example.VendasSpring.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.example.VendasSpring.model.Cliente;
import com.example.VendasSpring.model.Produto;
import com.example.VendasSpring.model.Venda;
import com.example.VendasSpring.service.ClienteService;
import com.example.VendasSpring.service.ProdutoService;

public class GravarArquivo {

	public String gravar() throws IOException {
		
		String arquivo = "src/main/resources/templates/log.txt";
		File file = new File(arquivo);
		
		System.out.println(file.toString());
    FileWriter arq = new FileWriter(file);
    PrintWriter gravarArq = new PrintWriter(arq);
    
    String n = "id venda, cliente id, cliente nome, cliente cpf, data de nascimento, sexo, id produto, nome do produto, valor produto, valor total\n";
    
    
    gravarArq.printf("id venda, cliente id, cliente nome, cliente cpf, data de nascimento, sexo, id produto, nome do produto, valor produto, valor total"
			+ ""
	+ "%n");
    
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
		
		n += venda.getId() +", "+
				venda.getCliente().getIdCliente()+", "+
				venda.getCliente().getNome() + ", "+
				venda.getCliente().getCpf()+", "+
				venda.getCliente().getDatanascimento()+", "+
				venda.getCliente().getSexo()+", "+
				venda.getProduto().getId()+", "+
				venda.getProduto().getNome()+", "+
				venda.getProduto().getValor()+", "+
				venda.getValortotal()+"\n";
		
		gravarArq.println(venda.getId() +", "+
							venda.getCliente().getIdCliente()+", "+
							venda.getCliente().getNome() + ", "+
							venda.getCliente().getCpf()+", "+
							venda.getCliente().getDatanascimento()+", "+
							venda.getCliente().getSexo()+", "+
							venda.getProduto().getId()+", "+
							venda.getProduto().getNome()+", "+
							venda.getProduto().getValor()+", "+
							venda.getValortotal()
							);	
	}
	
	}catch (Exception e) {
		// TODO: handle exception
	}
	
	

 
    arq.close();
    return n.toString();
	}
	
	public static void main(String ar[]) {
		GravarArquivo gravarArquivo = new GravarArquivo();
		
		try {
		System.out.print(gravarArquivo.gravar());
		}catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

}
