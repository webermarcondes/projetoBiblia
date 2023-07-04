package br.com.projetobiblia.bo;

import java.math.BigInteger;
import java.util.List;

import br.com.projetobiblia.dao.LivroDAO;
import br.com.projetobiblia.vo.LivroVO;

public class LivroBO implements ILivroBO {

	@Override
	public LivroVO buscarLivroPorID(BigInteger id) {
		LivroDAO livroDAO = new LivroDAO();
		
		return livroDAO.buscarLivroPorID(id);
	}
	
	@Override
	public List<String> listarEscritores() {
		LivroDAO livroDAO = new LivroDAO();
		
		return livroDAO.listarEscritores();
	}


	@Override
	public LivroVO buscarLivroPorEscritor(String escritor) {
		LivroDAO livroDAO = new LivroDAO();
		
		
		return livroDAO.buscarLivroPorEscritor(escritor);
	}
}
