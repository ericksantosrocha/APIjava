package br.com.fiap.entity;

import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_CLIENTE")
@SequenceGenerator(name="seqCliente",sequenceName="SEQ_T_CLIENTE",allocationSize=1)
public class Cliente {

	@Id
	@Column(name="CD_CLIENTE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqCliente")
	private int codigo;
	
	@Column(nullable=false,name="NM_CLIENTE")
	private String nome;
	
	@Column(name="DT_NASCIMENTO")
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;
	
	@Column(name="DS_EMAIL")
	private String email;

	public Cliente() {
		super();
	}

	public Cliente(String nome, Calendar dataNascimento, String email) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.email = email;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
