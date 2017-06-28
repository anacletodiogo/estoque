package br.com.anacleto.controller;

import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.anacleto.model.EntradaProduto;
import br.com.anacleto.model.Produto;
import br.com.anacleto.repository.EntradaProdutoRepository;
import br.com.anacleto.repository.ProdutoRepository;

@Controller
public class EntradaProdutoController {
	
	    @Autowired EntradaProdutoRepository entradaProdutoRepository;
	    @Autowired ProdutoRepository produtoRepository; 
	    
	    @PostMapping(path = "/entradaProduto/{idProduto}")
	    public @ResponseBody String entradaProduto( 
	    		@PathVariable(name = "idProduto") Long idProduto,
	            @RequestBody EntradaProduto entradaProduto) {
	    	
	    	Produto produto = produtoRepository.findOne(idProduto);
	        if (produto == null) {
	            return "Produto não encontrado. ";
	        }
	        
	        produto.setQuantidade(entradaProduto.getQuantidade()+produto.getQuantidade());
	        produtoRepository.save(produto);
	        
	        entradaProduto.setProduto(produto);   
	        entradaProduto.setEntrada(new GregorianCalendar());
	        entradaProdutoRepository.save(entradaProduto);

	        return "Estoque inserido";
	    }
	    
	}
