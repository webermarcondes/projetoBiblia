package br.com.projetobiblia;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import br.com.projetobiblia.dao.BibliaDAO;
import br.com.projetobiblia.dao.LivroDAO;
import br.com.projetobiblia.service.Service;
import br.com.projetobiblia.vo.BibliaVO;
import br.com.projetobiblia.vo.LivroVO;

public class Principal {

	public static final String ASCENDING = "ASCENDING";
	
	public static final String DESCENDING = "DESCENDING";
	
	public static void main(String[] args) {
		
		Principal p = new Principal();
		Service servico = new Service();
		LivroDAO livroDAO = new LivroDAO();
		LivroVO livro = new LivroVO();
		
		
		
		/*Map<String, Object> filters = new HashMap<>();
		filters.put("capitulo", new BigInteger("2"));
		filters.put("versic_inic", new BigInteger("18"));
		filters.put("versic_final", new BigInteger("18"));
		filters.put("livro", servico.buscarLivroPorID(new BigInteger("1")));
		
		
		for (BibliaVO b: servico.listarVersiculosDaBiblia(filters, servico.buscarLivroPorID(new BigInteger("1")))) {
			System.out.println(b);	
		}*/
		
		/*for (LivroVO livrO: livroDAO.listarLivros()) {
			System.out.print(livrO.getEscritor() + "  \n");		}*/
		
		
		
		

	}

}
