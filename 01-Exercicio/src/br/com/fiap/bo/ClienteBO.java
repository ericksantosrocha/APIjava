package br.com.fiap.bo;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.entity.Cliente;
import br.com.fiap.exception.DBException;
import br.com.fiap.factory.EntityManagerFactorySingleton;

public class ClienteBO {

	private EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
	
	public void cadastrar(Cliente cliente){
		EntityManager em = fabrica.createEntityManager();
		ClienteDAO dao = new ClienteDAOImpl(em);
		
		try {
			dao.cadastrar(cliente);
			dao.salvar();
		} catch (DBException e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
		
	}
	
	public Cliente buscar(int codigo){
		EntityManager em = fabrica.createEntityManager();
		ClienteDAO dao = new ClienteDAOImpl(em);
		
		Cliente cliente = dao.pesquisar(codigo);
		em.close();
		return cliente;
	}
	
	public List<Cliente> listar(Cliente cliente){
		EntityManager em = fabrica.createEntityManager();
		ClienteDAO dao = new ClienteDAOImpl(em);
		
		 List<Cliente> lista = dao.listar();
		 
		 lista.add(cliente);
		 
		 em.close();
		 return lista;
		
	}
}
