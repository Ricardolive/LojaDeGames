package br.com.generation.lojaDeGames.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.generation.lojaDeGames.model.Produto;


public interface ProdutoRepository extends JpaRepository<Produto,Long>{
	
	public Produto findOneByDescricaoContainingIgnoreCase(String descricao);

}
