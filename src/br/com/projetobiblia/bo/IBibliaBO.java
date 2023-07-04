package br.com.projetobiblia.bo;

import java.util.List;
import java.util.Map;

import br.com.projetobiblia.vo.BibliaVO;
import br.com.projetobiblia.vo.LivroVO;

public interface IBibliaBO {
	
	public abstract List<BibliaVO> listarVersiculos(Map<String, Object> filters, LivroVO livro);

}
