package br.com.projetobiblia.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import br.com.projetobiblia.bo.BibliaBO;
import br.com.projetobiblia.bo.LivroBO;
import br.com.projetobiblia.vo.BibliaVO;
import br.com.projetobiblia.vo.LivroVO;

public class Service {
	
	
	public List<BibliaVO> listarVersiculosDaBiblia(Map<String, Object> filters , LivroVO livro) {
		BibliaBO bibliaBO = new BibliaBO();
		
		return bibliaBO.listarVersiculos(filters , livro);
	}
	
	
	public LivroVO buscarLivroPorID(BigInteger id) {
		LivroBO livroBO = new LivroBO();
		
		return livroBO.buscarLivroPorID(id);
	}
	
	
	public List<String> listarEscritores() {
		LivroBO livroBO = new LivroBO();
		
		return livroBO.listarEscritores();
		
	}
	
	
	public LivroVO buscarLivroPorEscritor(String escritor) {
		LivroBO livroBO = new LivroBO();
		
		return livroBO.buscarLivroPorEscritor(escritor);
	}
}
