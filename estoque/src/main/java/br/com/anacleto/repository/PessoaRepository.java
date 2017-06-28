package br.com.anacleto.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.anacleto.model.Pessoa;

public interface PessoaRepository extends CrudRepository<Pessoa, Long>{

}
