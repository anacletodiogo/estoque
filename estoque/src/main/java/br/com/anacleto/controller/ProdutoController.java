package br.com.anacleto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.anacleto.model.Fornecedor;
import br.com.anacleto.model.Produto;
import br.com.anacleto.repository.FornecedorRepository;
import br.com.anacleto.repository.ProdutoRepository;

@Controller
public class ProdutoController {
	
	    @Autowired FornecedorRepository fornecedorRepository;
	    @Autowired ProdutoRepository produtoRepository; 
	    
	    // serviço para inserção de exemplares
	    
	    @PostMapping(path = "/inserirProduto/{idFornecedor}")
	    public @ResponseBody String cadastrarProduto( 
	    		@PathVariable(name = "idFornecedor") Long idFornecedor,
	            @RequestBody Produto produto) {
	    	
	    	Fornecedor fornecedor = fornecedorRepository.findOne(idFornecedor);
	        if (fornecedor == null) {
	            return "Fornecedor não encontrado. ";
	        }
	        
	        produto.setFornecedor(fornecedor);   

	        produtoRepository.save(produto);
	        
	        return "Produto inserido";
	    }

	}
