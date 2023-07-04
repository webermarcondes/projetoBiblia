package br.com.projetobiblia.dao;

import java.awt.image.FilteredImageSource;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.projetobiblia.Principal;
import br.com.projetobiblia.vo.*;

public class BibliaDAO implements IBibliaDAO {

	// Integer first, Integer pageSize, String sortField, String sortOrder,
	// Map<String, Object> filters, Livros livro
	@Override
	public List<BibliaVO> listarVersiculos(Map<String, Object> filters, LivroVO livro) {

		EntityManager em = HibernateUtil.getEntityManager();

		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<Tuple> criteria = cb.createQuery(Tuple.class);

		// Cláusula From
		Root<BibliaVO> bibliaFrom = criteria.from(BibliaVO.class);
		Join<BibliaVO, LivroVO> livroFrom = bibliaFrom.join("livro");

		criteria.multiselect(bibliaFrom, livroFrom);

		Predicate bibliaWhere = cb.equal(livroFrom, livro);

		if (filters != null) {

			// capitulo OK, versiculo ini, versiculo fin, texto OK

			if (filters.get("capitulo") != null) {
				bibliaWhere = cb.and(bibliaWhere, cb.equal(bibliaFrom.get("capitulo"), filters.get("capitulo")));

			}

			if (filters.get("texto") != null) {
				bibliaWhere = cb.and(bibliaWhere,
						cb.like(cb.lower(bibliaFrom.get("texto")), "%" + filters.get("texto") + "%"));
			}
			
			
			
			if (filters.get("versic_inic") != null && filters.get("versic_final") != null) {
				
				bibliaWhere = cb.and(bibliaWhere, cb.between(bibliaFrom.get("versiculo"), (BigInteger) filters.get("versic_inic"), (BigInteger) filters.get("versic_final")));
			}  
			
			else if(filters.get("versic_inic") != null) {
				bibliaWhere = cb.and(bibliaWhere, cb.greaterThanOrEqualTo(bibliaFrom.get("versiculo"), (BigInteger) filters.get("versic_inic")));
			}
			
			else if(filters.get("versic_final") != null) {
				bibliaWhere = cb.and(bibliaWhere, cb.lessThanOrEqualTo(bibliaFrom.get("versiculo"), (BigInteger) filters.get("versic_final")));
			}
			/*else if (filters.get("versic_inic") != null) {
				bibliaWhere = cb.and(bibliaWhere, cb.equal(bibliaFrom.get("versiculo"), filters.get("versic_inic")));
			} else if (filters.get("versic_final") != null) {

			}*/

		}

		Order BibliaOrderBy = cb.asc(bibliaFrom.get("texto"));

		/*
		 * if (sortField != null) {
		 * 
		 * if (sortOrder.equals(Principal.ASCENDING)) { produtoOrderBy =
		 * cb.asc(produtoFrom.get(sortField)); } else if
		 * (sortOrder.equals(Principal.DESCENDING)) { produtoOrderBy =
		 * cb.desc(produtoFrom.get(sortField)); } }
		 */

		// Where
		criteria.where(bibliaWhere);
		// Order by
		criteria.orderBy(BibliaOrderBy);

		TypedQuery<Tuple> query = em.createQuery(criteria);

		// Seta a quantidade máxima de elementos a serem retornados e primeiro.
		/*
		 * query.setFirstResult(first); if (pageSize != 0) {
		 * query.setMaxResults(pageSize); }
		 */

		List<Tuple> tuples = query.getResultList();

		// Monta o retorno da função.
		List<BibliaVO> ret = new ArrayList<BibliaVO>();
		if (tuples != null) {

			for (Tuple tuple : tuples) {

				LivroVO livroAux = tuple.get(livroFrom);

				BibliaVO bibliaVO = tuple.get(bibliaFrom);
				bibliaVO.setLivro(livro);

				ret.add(bibliaVO);

			}
		}

		em.close();

		System.out.println("Terminando filtro completo");

		return ret;

	}

}
