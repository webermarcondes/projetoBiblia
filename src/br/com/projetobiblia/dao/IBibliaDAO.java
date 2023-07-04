package br.com.projetobiblia.dao;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import br.com.projetobiblia.vo.*;

public interface IBibliaDAO {
	
	//Integer first, Integer pageSize, String sortField, String sortOrder,
	//Map<String, Object> filters, Livros livro
	public abstract List<BibliaVO> listarVersiculos(Map<String, Object> filters, LivroVO livro);
}
