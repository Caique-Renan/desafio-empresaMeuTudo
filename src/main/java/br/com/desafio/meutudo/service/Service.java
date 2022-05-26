package br.com.desafio.meutudo.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.desafio.meutudo.Entity.Cliente;
import br.com.desafio.meutudo.Entity.Transacao;
import br.com.desafio.meutudo.dto.ClienteDTO;
import br.com.desafio.meutudo.dto.TransacaoDTO;
import br.com.desafio.meutudo.repository.ClienteRepository;
import br.com.desafio.meutudo.repository.TransacaoRepository;

@org.springframework.stereotype.Service
public class Service {
	
	@Autowired
	private TransacaoRepository transacaoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente salvarCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public ClienteDTO mostraSaldo(Long id) {
		Cliente cliente = new Cliente();
		ClienteDTO clienteDTO = new ClienteDTO();
		cliente = clienteRepository.findById(id).get();
		clienteDTO.setContaCliente(cliente.getContaCliente());
		clienteDTO.setCpf(cliente.getCpf());
		clienteDTO.setEmail(cliente.getEmail());
		clienteDTO.setNome(cliente.getNome());
		clienteDTO.setSaldoConta(cliente.getSaldoConta());

		return clienteDTO;
	}

	public Long transferencia(TransacaoDTO transacaoDTO) {
		
//		subtrai o valor do remetente 
		Cliente clienteRemetente = clienteRepository.findById(transacaoDTO.getContaRemetente()).get();
		Double subtraiValor = clienteRemetente.getSaldoConta() - transacaoDTO.getValorTransacao();
		clienteRemetente.setSaldoConta(subtraiValor);
		clienteRepository.save(clienteRemetente);
//		ADD o valor ao destinatario 
		Cliente clienteDestino = clienteRepository.findById(transacaoDTO.getContaDestinatario()).get();
		Double novoSaldo = clienteDestino.getSaldoConta() + transacaoDTO.getValorTransacao();
		clienteDestino.setSaldoConta(novoSaldo);
		clienteRepository.save(clienteDestino);
//		Cria a linha na entidade transacao
		Transacao transacao = new Transacao();
		transacao.setContaRemetente(clienteRemetente.getContaCliente());
		transacao.setContaDestinatario(clienteDestino.getContaCliente());
		transacao.setValorTransacao(transacaoDTO.getValorTransacao());
		transacao.setDataTransacao(Calendar.getInstance().getTime());
		Transacao savedTransacao = transacaoRepository.save(transacao);
		
		return savedTransacao.getIdTransacoes();
	}
	
	public Long transferenciaRevert(TransacaoDTO transacaoDTO) {
		Transacao busca = transacaoRepository.findById(transacaoDTO.getIdTransacoes()).get();
//		subtrai o valor do remetente 
		Cliente clienteRemetente = clienteRepository.findById(busca.getContaDestinatario()).get();
		Double subtraiValor = clienteRemetente.getSaldoConta() - busca.getValorTransacao();
		clienteRemetente.setSaldoConta(subtraiValor);
		clienteRepository.save(clienteRemetente);
//		ADD o valor ao destinatario 
		Cliente clienteDestino = clienteRepository.findById(busca.getContaRemetente()).get();
		Double novoSaldo = clienteDestino.getSaldoConta() + busca.getValorTransacao();
		clienteDestino.setSaldoConta(novoSaldo);
		clienteRepository.save(clienteDestino);
//		Cria a linha na entidade transacao
		Transacao transacao = new Transacao();
		transacao.setContaRemetente(clienteRemetente.getContaCliente());
		transacao.setContaDestinatario(clienteDestino.getContaCliente());
		transacao.setValorTransacao(busca.getValorTransacao());
		transacao.setDataTransacao(Calendar.getInstance().getTime());
		Transacao savedTransacao = transacaoRepository.save(transacao);
		
		return savedTransacao.getIdTransacoes();
		
	}
	

}
