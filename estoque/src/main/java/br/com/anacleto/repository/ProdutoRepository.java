package br.com.anacleto.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.anacleto.model.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long>{
//
//    @Query("SELECT p FROM Produto p WHERE p.id = :pro ")
//    public Produto retornarPublicacaoPeloNumTombo(
//            @Param("pro") String pro);
}
