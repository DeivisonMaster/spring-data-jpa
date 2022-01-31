package br.com.mercadoapi.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private BigDecimal preco;
	
	@Column(name = "quantidade_estoque", nullable = false)
	private Integer quantidadeEstoque;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id", nullable = false) 
	private Categoria categoria;
	
	@Override
	public String toString() {
		return "Nome: " + this.nome + " Preco: " + this.preco + "\n";
	}
}
