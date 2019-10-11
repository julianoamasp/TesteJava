package com.example.VendasSpring.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.VendasSpring.dao.GravarArquivo;
import com.example.VendasSpring.model.Cliente;
import com.example.VendasSpring.model.Produto;
import com.example.VendasSpring.model.Venda;
import com.example.VendasSpring.service.ClienteService;
import com.example.VendasSpring.service.ProdutoService;
import com.example.VendasSpring.service.VendaService;

@org.springframework.stereotype.Controller
public class Controller {
	
	@GetMapping("/vendas")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("vendas");
		return mv;
	}
	
	//retornar todos os clientes
	@GetMapping("/clientes")
	@ResponseBody
	public List<Cliente> vendas() {
		List<Cliente> clientes = null;
		ClienteService clienteService = new ClienteService();
		try {
			clientes = clienteService.listarClientes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clientes;
	}
	//retornar todos os produtos
	@GetMapping("/produtos")
	@ResponseBody
	public List<Produto> produtos() {
		List<Produto> produtos = null;
		ProdutoService produtoService = new ProdutoService();
		try {
			produtos = produtoService.listarProdutos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return produtos;
	}
	
	//buscar cliente por id
	@RequestMapping(value = "/clientesporid/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Cliente clienteporid(@PathVariable("id") Integer id) {
		Cliente cliente = null;
		ClienteService clienteService = new ClienteService();
		try {
			cliente = clienteService.buscarPeloId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cliente;
	}
	//buscar produto por id
		@RequestMapping(value = "/produto/{id}", method = RequestMethod.GET)
		@ResponseBody
		public Produto produtoporid(@PathVariable("id") Integer id) {
			Produto produto = null;
			ProdutoService produtoServ = new ProdutoService();
			try {
				produto = produtoServ.buscarPeloId(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return produto;
		}
		
		//adicionar
				@RequestMapping(value = "/vendaadicionar", method = RequestMethod.POST)
				@ResponseBody
				public Venda gerarvenda(@RequestBody Venda venda) {
					VendaService vendaService = new VendaService();
					try {
					vendaService.gerarVenda(venda);
					}catch (Exception e) {
						// TODO: handle exception
					}
				
					System.out.println(venda.getValortotal());
					return venda;
				}
				
				
		//gravar arquivo
				//retornar todos os clientes
				@GetMapping("/gerarrelatorio")
				@ResponseBody
				public String gerarrelatorio() {
					GravarArquivo gravar = new GravarArquivo();
					String relatorio ="";
					try {
						relatorio = gravar.gravar();
					} catch (Exception e) {
						e.printStackTrace();
					}
					return relatorio.toString();
				}

}
