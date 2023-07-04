package br.com.projetobiblia.vo;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="livros")
public class LivroVO {
	
	@Id
	@Column(name="livro", nullable=false)
	private BigInteger livro;
	
	@Column(name="escritor", nullable=false)
	private String escritor;
	
	@Column(name="sigla")
	private String sigla;
	
	@Column(name="qtd_capitulos", nullable=false)
	private BigInteger qtdCapitulos;

	public BigInteger getLivro() {
		return livro;
	}

	public void setLivro(BigInteger livro) {
		this.livro = livro;
	}

	public String getEscritor() {
		return escritor;
	}

	public void setEscritor(String escritor) {
		this.escritor = escritor;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public BigInteger getQtdCapitulos() {
		return qtdCapitulos;
	}

	public void setQtdCapitulos(BigInteger qtdCapitulos) {
		this.qtdCapitulos = qtdCapitulos;
	}

	@Override
	public String toString() {
		return escritor;
	}
	
	
	
	
	
}
