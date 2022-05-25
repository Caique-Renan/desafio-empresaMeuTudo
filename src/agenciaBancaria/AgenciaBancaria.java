package agenciaBancaria;

import java.util.ArrayList;
import java.util.Scanner;

import entity.Cliente;
import entity.Conta;
import service.TransacoesService;

public class AgenciaBancaria {

	TransacoesService transacoes = new TransacoesService();

	static Scanner entrada = new Scanner(System.in);

	static ArrayList<Conta> contasBancarias;

	public static void main(String[] args) {
		contasBancarias = new ArrayList<Conta>();

		operacoes();
	}

	public static void operacoes() {
		System.out.println("------------------------------------------");
		System.out.println("---------- Bem vindo ao MeuTudo! ---------");
		System.out.println("******** Selecione a sua operação ********");
		System.out.println("------------------------------------------");
		System.out.println("|         Opção 1 - Criar Conta          |");
		System.out.println("|         Opção 2 - Depositar            |");
		System.out.println("|         Opção 3 - Sacar                |");
		System.out.println("|         Opção 4 - Transferir           |");
		System.out.println("|         Opção 5 - Listar               |");
		System.out.println("|         Opção 6 - Sair                 |");
		System.out.println("------------------------------------------");

		int operacao = entrada.nextInt();

		switch (operacao) {
		case 1:
			criarConta();
			break;

		case 2:
			depositar();
			break;

		case 3:
			sacar();
			break;

		case 4:
			transferir();
			break;

		case 5:
			listarContas();
			break;
		case 6:
			System.out.println("Obrigado por utilizar a nossa agência," + " não esqueça de avaliar meu trabalho!");
			System.exit(0);

		default:
			System.out.println("Opção inválida");
			operacoes();
			break;
		}
	}

	public static void criarConta() {
		System.out.println("\nNome: ");
		String nome = entrada.next();

		System.out.println("\nCPF: ");
		String cpf = entrada.next();

		System.out.println("\nEmail: ");
		String email = entrada.next();

		Cliente cliente = new Cliente(nome, cpf, email);
		Conta conta = new Conta(cliente);

		contasBancarias.add(conta);

		System.out.println("Conta criada com sucesso.");
		operacoes();
	}

	private static Conta encontrarConta(int numeroConta) {
		Conta conta = null;

		if (contasBancarias.size() > 0) {
			for (Conta c : contasBancarias) {
				if (c.getNumeroConta() == numeroConta)
				conta = c;
			}
		}
		return conta;
	}

	public static void depositar() {
		System.out.println("Insira o número da conta: ");
		int numeroConta = entrada.nextInt();
		Conta conta = encontrarConta(numeroConta);
		if (conta != null) {
			System.out.println("Qual o valor para ser depositado?");
			Double valorDeposito = entrada.nextDouble();
			conta.depositar(valorDeposito);
			System.out.println("Deposito efetuado com sucesso");
		} else {
			System.out.println("A conta não foi encontrada.");
		}
		operacoes();
	}

	public static void sacar() {
		System.out.println("Insira o número da conta: ");
		int numeroConta = entrada.nextInt();
		Conta conta = encontrarConta(numeroConta);

		if (conta != null) {
			System.out.println("Qual o valor para ser sacar?");
			Double valorSaque = entrada.nextDouble();
			conta.sacar(valorSaque);
		} else {
			System.out.println("A conta não foi encontrada.");
		}
		operacoes();
	}

	public static void transferir() {
		System.out.println("Número da conta do remetente: ");
		int numeroRemetente = entrada.nextInt();

		Conta contaRemetente = encontrarConta(numeroRemetente);
		
		if (contaRemetente != null) {
			System.out.println("Número da conta do destinatário: ");
			int numeroDestinatario = entrada.nextInt();
			Conta contaDestinatario = encontrarConta(numeroDestinatario);

			if (contaDestinatario != null) {
				System.out.println("Qual o valor da transferencia?");

				Double valor = entrada.nextDouble();

				contaRemetente.transferir(contaDestinatario, valor);

			} else {
				System.out.println("Conta não encontrada.");
			}operacoes();
		}
		
	}

	public static void listarContas() {
		if (contasBancarias.size() > 0) {
			for (Conta conta : contasBancarias) {
				System.out.println(conta);
			}
		} else {
			System.out.println("Não há contas cadastradas.");
		}
		operacoes();
	}

}
