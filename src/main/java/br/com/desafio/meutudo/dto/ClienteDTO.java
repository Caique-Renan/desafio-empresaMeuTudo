package br.com.desafio.meutudo.dto;

public class ClienteDTO {

	private Long contaCliente;
	private String nome;
	private String cpf;
	private String email;
	private Double saldoConta;
	
	@Override
	public String toString() {
		return String.format("ClienteDTO [contaCliente=%s, nome=%s, cpf=%s, email=%s]",
				contaCliente, nome, cpf, email);
	}
	
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

	
//	Data transfer object da classe Cliente
}
