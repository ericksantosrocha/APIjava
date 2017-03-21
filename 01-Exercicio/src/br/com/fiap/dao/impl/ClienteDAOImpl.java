package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.entity.Cliente;

public class ClienteDAOImpl extends GenericDAOImpl<Cliente, Integer> implements ClienteDAO{

	public ClienteDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Cliente> listar() {
		return em.createQuery("from Cliente",Cliente.class).getResultList();
	}

}
