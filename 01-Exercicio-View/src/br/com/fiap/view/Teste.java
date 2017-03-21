package br.com.fiap.view;


import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.fiap.bo.ClienteBOStub;
import br.com.fiap.bo.ClienteBOStub.Buscar;
import br.com.fiap.bo.ClienteBOStub.Cadastrar;
import br.com.fiap.bo.ClienteBOStub.Cliente;
import br.com.fiap.bo.ClienteBOStub.Listar;

public class Teste {

	public static void main(String[] args) {
		try {
			ClienteBOStub stub = new ClienteBOStub();
			
			//Cadastro de cliente
			Cadastrar cadastro = new Cadastrar();
			Cliente cliente = new Cliente();
			cliente.setNome("Ronaldo");
			cliente.setDataNascimento(new GregorianCalendar(1980,Calendar.JANUARY,22));
			cliente.setEmail("brilhamuitonocurintia@curintia.com");
			cadastro.setCliente(cliente);
			
			stub.cadastrar(cadastro);
			
			//Busca de cliente
			Buscar busca = new Buscar();
			busca.setCodigo(cliente.getCodigo());
			stub.buscar(busca);
			
			//Lista de Cliente
			Listar listar = new Listar();
			listar.setCliente(cliente);
			stub.listar(listar);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
