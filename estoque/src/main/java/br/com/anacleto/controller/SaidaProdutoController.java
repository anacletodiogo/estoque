package br.com.anacleto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.anacleto.model.Cliente;
import br.com.anacleto.model.Funcionario;
import br.com.anacleto.model.Produto;
import br.com.anacleto.model.SaidaProduto;
import br.com.anacleto.repository.ClienteRepository;
import br.com.anacleto.repository.FuncionarioRepository;
import br.com.anacleto.repository.ProdutoRepository;
import br.com.anacleto.repository.SaidaProdutoRepository;

@Controller
public class SaidaProdutoController {
	
	    @Autowired SaidaProdutoRepository saidaProdutoRepository;
	    @Autowired ProdutoRepository produtoRepository; 
	    @Autowired FuncionarioRepository funcionarioRepository; 
	    @Autowired ClienteRepository clienteRepository; 
	    
	    @PostMapping(path = "/saidaProduto/{idCliente}/{idFuncionario}/{idProduto}")
	    public @ResponseBody String saidaProduto( 
	    		@PathVariable(name = "idCliente") Long idCliente,
	    		@PathVariable(name = "idFuncionario") Long idFuncionario,
	    		@PathVariable(name = "idProduto") Long idProduto,
	            @RequestBody SaidaProduto saidaProduto) {
	    	
	    	Cliente cliente = clienteRepository.findOne(idCliente);
	    	if (cliente == null) {
	    		return "Cliente não encontrado.";
			} else {
				saidaProduto.setCliente(cliente);
			}
	    	
	    	Funcionario funcionario = funcionarioRepository.findOne(idFuncionario);
	    	if (funcionario == null) {
	    		return "Funcionário não encontrado.";				
			} else {
				saidaProduto.setFuncionario(funcionario);
			}
	    	
	    	Produto produto = produtoRepository.findOne(idProduto);
	        if (produto == null) {
	            return "Produto não encontrado. ";
	        }
	        
	        int resultado = produto.getQuantidade()-saidaProduto.getQuantidade();
	        
	        if (resultado >= 0){
	        	produto.setQuantidade(resultado);
		        saidaProduto.setProduto(produto);   
	
		        saidaProdutoRepository.save(saidaProduto);
		        
		        return "Saida de estoque efetuada com sucesso.";
	        } else {
	        	return "Estoque insuficiente.";
	        }
	    }
	    
	}