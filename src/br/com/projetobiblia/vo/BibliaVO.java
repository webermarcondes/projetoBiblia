package br.com.projetobiblia.vo;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="biblia")
public class BibliaVO implements Serializable{
	
	
	private static final long serialVersionUID = 9203542938489838235L;
	
	
	@Id
	@Column(name="sequencia", nullable=false)
	private BigInteger sequencia;
	
	@Column(name="capitulo", nullable=false)
	private BigInteger capitulo;
	
	@Column(name="versiculo", nullable=false)
	private BigInteger versiculo;
	
	@Column(name="texto", nullable=false)
	private String texto;
	
	@JoinColumn(name = "livro", referencedColumnName = "livro", nullable = false)
	@OneToOne(optional=false, fetch = FetchType.LAZY)
	private LivroVO livro;
	
	
	public BigInteger getSequencia() {
		return sequencia;
	}

	public void setSequencia(BigInteger sequencia) {
		this.sequencia = sequencia;
	}

	public BigInteger getCapitulo() {
		return capitulo;
	}

	public void setCapitulo(BigInteger capitulo) {
		this.capitulo = capitulo;
	}

	public BigInteger getVersiculo() {
		return versiculo;
	}

	public void setVersiculo(BigInteger versiculo) {
		this.versiculo = versiculo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LivroVO getLivro() {
		return livro;
	}

	public void setLivro(LivroVO livro) {
		this.livro = livro;
	}

	@Override
	public String toString() {
		return "BibliaVO [sequencia=" + sequencia + ", capitulo=" + capitulo + ", versiculo=" + versiculo + ", texto="
				+ texto + ", livro=" + livro + "]";
	}
	
	

	
	
	
	
	
	
	
	
	

}
