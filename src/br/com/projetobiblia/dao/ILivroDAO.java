package br.com.projetobiblia.dao;

import java.math.BigInteger;
import java.util.List;

import br.com.projetobiblia.vo.LivroVO;

public interface ILivroDAO {
	
	public abstract LivroVO buscarLivroPorID(BigInteger id);
	
	public abstract List<String> listarEscritores();
	
	public abstract LivroVO buscarLivroPorEscritor(String escritor);

}
