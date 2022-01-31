package br.com.mercadoapi.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mercadoapi.model.Produto;
import br.com.mercadoapi.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository repository;
	
	@GetMapping("/todos")
	public List<Produto> pesquisar(){
		repository.findAll().forEach(p -> System.out.println(p));
		return repository.findAll();
	}
	
	@GetMapping("/porNome")
	public List<Produto> pesquisaPorNome(String nome){
		System.out.println(repository.findByNome(nome));
		return repository.findByNome(nome);
	}
	
	@GetMapping("/porNomeContendo")
	public List<Produto> pesquisaPorNomeContendo(String nome){
		System.out.println(repository.findByNomeContaining(nome));
		return repository.findByNomeContaining(nome);
	}
	
	@GetMapping("/porPreco")
	public List<Produto> pesquisaPorPreco(BigDecimal precoInicio, BigDecimal precoFim){
		System.out.println(repository.findByPrecoBetween(precoInicio, precoFim));
		return repository.findByPrecoBetween(precoInicio, precoFim);
	}
	
	@GetMapping("/porNomeECategoria")
	public List<Produto> pesquisaPorNomeECategoria(String nome, Long categoriaId){
		System.out.println(repository.findByNomeContainingAndCategoriaId(nome, categoriaId));
		return repository.findByNomeContainingAndCategoriaId(nome, categoriaId);
	}
	
	@GetMapping("/existeProduto")
	public boolean existeProduto(String nome){
		System.out.println(repository.existsByNome(nome));
		return repository.existsByNome(nome);
	}
	
	@GetMapping("/porCategoriaId")
	public Integer pesquisaPorCategoriaId(Long categoriaId){
		System.out.println(repository.countByCategoriaId(categoriaId));
		return repository.countByCategoriaId(categoriaId);
	}
	
	@GetMapping("/porPrecoPaginado")
	public Page<Produto> pesquisaPorPrecoPaginado(BigDecimal precoInicio, BigDecimal precoFim, @PageableDefault(2) Pageable paginacao){
		System.out.println(repository.findByPrecoBetween(precoInicio, precoFim, paginacao));
		return repository.findByPrecoBetween(precoInicio, precoFim, paginacao);
	}
	
	@GetMapping("/porNomeCategoriaJPQL")
	public List<Produto> pesquisaPorNomeECategoriaJPQL(String nome, Long categoriaId){
		System.out.println(repository.pesquisaPorNomeECategoriaJPQL(nome, categoriaId));
		return repository.pesquisaPorNomeECategoriaJPQL(nome, categoriaId);
	}
	
}
