package br.com.mercadoapi.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.mercadoapi.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	List<Produto> findByNome(String nome);
	
	List<Produto> findByNomeContaining(String nome);
	
	List<Produto> findByPrecoBetween(BigDecimal precoInicio, BigDecimal precoFim);
	
	List<Produto> findByNomeContainingAndCategoriaId(String nome, Long categoria);
	
	boolean existsByNome(String nome);
	
	Integer countByCategoriaId(Long categoria);
	
	Page<Produto> findByPrecoBetween(BigDecimal precoInicio, BigDecimal precoFim, Pageable paginacao);
	
	@Query("from Produto p where p.nome like %:nome% and p.categoria.id = :categoriaId")
	List<Produto> pesquisaPorNomeECategoriaJPQL(String nome, Long categoriaId);
	
}
