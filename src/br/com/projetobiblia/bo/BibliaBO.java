package br.com.projetobiblia.bo;

import java.util.List;
import java.util.Map;

import br.com.projetobiblia.dao.BibliaDAO;
import br.com.projetobiblia.vo.BibliaVO;
import br.com.projetobiblia.vo.LivroVO;

public class BibliaBO implements IBibliaBO {

	@Override
	public List<BibliaVO> listarVersiculos(Map<String, Object> filters, LivroVO livro) {
		
		BibliaDAO bibliaDAO = new BibliaDAO();
		
		return bibliaDAO.listarVersiculos(filters, livro);
	}

}
