package br.edu.unisep.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.edu.unisep.hibernate.HibernateSessionFactory;


public class DAOGenerico<T> {

	public List<T> listar(Class<T> classe) {
		Session session = HibernateSessionFactory.getSession();
		
		Criteria crit = session.createCriteria(classe);
		
		List<T> lista = crit.list();
		
		session.close();
		return lista;
	}
	
	public void salvar(T objeto) {
		
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();

		try {
			session.save(objeto);
			trans.commit();
		} catch(Exception e) {
			trans.rollback();
			e.printStackTrace();
		}
		
		session.close();
	}

	public void excluir(T objeto) {
		
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();

		try {
			session.delete(objeto);
			trans.commit();
		} catch(Exception e) {
			trans.rollback();
			e.printStackTrace();
		}
		
		session.close();
	}

	public void alterar(T objeto) {
		
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();

		try {
			session.update(objeto);
			trans.commit();
		} catch(Exception e) {
			trans.rollback();
			e.printStackTrace();
		}
		
		session.close();
	}
	
	public T consultar(Class<T> classe, Integer id) {
		Session session = HibernateSessionFactory.getSession();
		
		Criteria crit = session.createCriteria(classe);
		crit.add(Restrictions.eq("id", id));
		
		T objeto = (T) crit.uniqueResult();

		session.close();
		
		return objeto;
	}
	
}