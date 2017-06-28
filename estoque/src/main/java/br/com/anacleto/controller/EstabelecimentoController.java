package br.com.anacleto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.anacleto.model.Estabelecimento;
import br.com.anacleto.repository.EstabelecimentoRepository;

@Controller
public class EstabelecimentoController {
	
	    @Autowired EstabelecimentoRepository estabelecimentoRepository;
	    
	    @PostMapping(path = "/inserirEstabelecimento")
	    public @ResponseBody String cadastrarEstabelecimento( 
	            @RequestBody Estabelecimento estabelecimento) {
	    	
	        estabelecimentoRepository.save(estabelecimento);
	        
	        return "Estabelecimento inserido";
	    }
	}
