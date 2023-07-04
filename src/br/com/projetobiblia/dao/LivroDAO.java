package br.com.projetobiblia.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.projetobiblia.vo.LivroVO;

public class LivroDAO implements ILivroDAO{

	@Override
	public LivroVO buscarLivroPorID(BigInteger id) {
		
		EntityManager em = HibernateUtil.getEntityManager();
		
		TypedQuery<LivroVO> query = em.createQuery("SELECT L FROM LivroVO as L WHERE livro = :id", LivroVO.class);
		query.setParameter("id", id);
		
		return query.getSingleResult();
	}
	
	@Override
	public List<String> listarEscritores() {
		EntityManager em = HibernateUtil.getEntityManager();
		
		List<String> escritores = new ArrayList<>();
		
		TypedQuery<String> query = em.createQuery("SELECT L.escritor FROM LivroVO as L", String.class);
		
		for (String escritor: query.getResultList()) {
			escritores.add(escritor);
		}
		
		return escritores;
		
	}
	
	@Override
	public LivroVO buscarLivroPorEscritor(String escritor) {
		EntityManager em = HibernateUtil.getEntityManager();
		
		TypedQuery<LivroVO> query = em.createQuery("SELECT L FROM LivroVO as L WHERE escritor = :escritor", LivroVO.class);
		query.setParameter("escritor", escritor);
		
		return query.getSingleResult();
		
	}

}
