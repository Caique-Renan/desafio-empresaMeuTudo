package br.com.desafio.meutudo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@Entity
@Table(name = "TB_CLIENTE")
public class ClienteEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CONTA_CLIENTE")
	@JsonInclude(Include.NON_NULL)
	private Long contaCliente;
	
	@Column(name = "NOME_CLIENTE")
	@JsonInclude(Include.NON_NULL)
	private String nome;
	
	@Column(name = "CPF_CLIENTE")
	@JsonInclude(Include.NON_NULL)
	private String cpf;
	
	@Column(name = "EMAIL_CLIENTE")
	@JsonInclude(Include.NON_NULL)
	private String email;
	
	@Column(name = "SALDO_CONTA")
	@JsonInclude(Include.NON_NULL)
	private Double saldoConta;
	
	
	public Long getContaCliente() {
		return contaCliente;
	}
	public void setContaCliente(Long contaCliente) {
		this.contaCliente = contaCliente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Double getSaldoConta() {
		return saldoConta;
	}
	public void setSaldoConta(Double saldoConta) {
		this.saldoConta = saldoConta;
	}
	public String toString() {
		return String.format("ClienteDTO [contaCliente=%s, nome=%s, cpf=%s, email=%s, saldo=%s]",
				contaCliente, nome, cpf, email, saldoConta);
	}
	
	
// Classe Entidade que salva as informações no banco de dados.
}
