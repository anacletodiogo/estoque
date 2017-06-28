package br.com.anacleto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.anacleto.model.Estabelecimento;
import br.com.anacleto.model.Funcionario;
import br.com.anacleto.model.Pessoa;
import br.com.anacleto.repository.EstabelecimentoRepository;
import br.com.anacleto.repository.FuncionarioRepository;
import br.com.anacleto.repository.PessoaRepository;

@Controller
public class FuncionarioController {
	
	    @Autowired FuncionarioRepository funcionarioRepository;
	    @Autowired PessoaRepository pessoaRepository;
	    @Autowired EstabelecimentoRepository estabelecimentoRepository;
	    
	    @PostMapping(path = "/inserirFuncionario/{idPessoa}/{idEstabelecimento}")
	    public @ResponseBody String cadastrarFuncionario( 
	    		@PathVariable(name = "idEstabelecimento") Long idEstabelecimento,
	    		@PathVariable(name = "idPessoa") Long idPessoa,
	            @RequestBody Funcionario funcionario) {
	    	
	    	Estabelecimento estabelecimento = estabelecimentoRepository.findOne(idEstabelecimento);
	        if (estabelecimento == null) {
	            return "Estabelecimento não encontrado. ";
	        }
	        
	        Pessoa pessoa = pessoaRepository.findOne(idPessoa);
	        if (pessoa == null) {
	        	return "Pessoa não encontrada. ";
	        }
	        
	        funcionario.setEstabelecimento(estabelecimento);
	        
	        funcionarioRepository.save(funcionario);
	        
	        return "Funcionario inserido";
	    }


	    
	}
