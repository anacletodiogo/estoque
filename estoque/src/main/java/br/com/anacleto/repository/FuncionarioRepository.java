package br.com.anacleto.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.anacleto.model.Funcionario;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Long>{

}
