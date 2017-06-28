package br.com.anacleto.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.anacleto.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long>{

}
