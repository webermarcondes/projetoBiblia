package br.com.projetobiblia.bo;

import java.math.BigInteger;
import java.util.List;

import br.com.projetobiblia.vo.LivroVO;

public interface ILivroBO {
	
	public abstract LivroVO buscarLivroPorID(BigInteger id);
	
	public abstract List<String> listarEscritores();
	
	public abstract LivroVO buscarLivroPorEscritor(String escritor);

}
