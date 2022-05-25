package entity;

import util.Utils;

public class Conta {
	
	private static int contadorContas = 1;
	private int numeroConta;
	private Cliente cliente;
	private Double saldo = 0.0;
	
	public Conta( Cliente cliente) {
		this.numeroConta = contadorContas;
		this.cliente = cliente;
		contadorContas += 1;
	}


	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	public String toString() {
		return "\nNúmero da Conta:" + this.getNumeroConta()+
				"\nNome: " + this.cliente.getNome() +
				"\nCPF: " + this.cliente.getCpf() +
				"\nEmail: " + this.cliente.getEmail() +
				"\nSaldo: " + Utils.doubleToString(this.getSaldo()) + "\n";
	}
	
	public void depositar(Double valor) {
		if(valor > 0) {
			setSaldo(getSaldo()+ valor);
			System.out.println("Seu depósito foi realizado com sucesso");
		}else {
			System.out.println("Não foi possível efetuar o depósito");
		}
	}
	
	public void sacar(Double valor) {
		if(valor > 0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
			System.out.println("Saque efetuado com sucesso");
		}else {
			System.out.println("Não foi possível realizar o saque");
		}
	}
	
	public void transferir(Conta contaDeposito, Double valor) {
		if(valor > 0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
			contaDeposito.saldo = contaDeposito.getSaldo() + valor;
			System.out.println("Transferencia realizada com sucesso");
		}else {
			System.out.println("Não foi possível realizar a transferencia");
		}
	}
	
}
