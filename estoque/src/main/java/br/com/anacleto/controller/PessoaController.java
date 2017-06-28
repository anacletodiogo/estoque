package br.com.anacleto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.anacleto.model.Pessoa;
import br.com.anacleto.repository.PessoaRepository;

@Controller
public class PessoaController {
	
	    @Autowired PessoaRepository pessoaRepository;
	    
	    @PostMapping(path = "/inserirPessoa")
	    public @ResponseBody String cadastrarPessoa( 
	            @RequestBody Pessoa pessoa) {
	    	
	        pessoaRepository.save(pessoa);
	        
	        return "Pessoa inserido";
	    }

	}
