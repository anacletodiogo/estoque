package br.com.anacleto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.anacleto.model.Fornecedor;
import br.com.anacleto.repository.FornecedorRepository;

@Controller
public class FornecedorController {
	
	    @Autowired FornecedorRepository fornecedorRepository;
	    
	    @PostMapping(path = "/inserirFornecedor")
	    public @ResponseBody String cadastrarProduto( 
	            @RequestBody Fornecedor fornecedor) {
	    	
	        fornecedorRepository.save(fornecedor);
	        
	        return "Fornecedor inserido";
	    }
	    
	}
