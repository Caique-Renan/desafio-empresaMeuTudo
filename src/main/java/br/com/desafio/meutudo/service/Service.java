package br.com.desafio.meutudo.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.desafio.meutudo.Entity.ClienteEntity;
import br.com.desafio.meutudo.Entity.TransacaoEntity;
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

	public ClienteEntity salvarCliente(ClienteEntity cliente) {
		return clienteRepository.save(cliente);
	}

	public ClienteDTO mostraSaldo(Long id) {
		ClienteEntity cliente = new ClienteEntity();
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
		ClienteEntity clienteRemetente = clienteRepository.findById(transacaoDTO.getContaRemetente()).get();
		Double subtraiValor = clienteRemetente.getSaldoConta() - transacaoDTO.getValorTransacao();
		clienteRemetente.setSaldoConta(subtraiValor);
		clienteRepository.save(clienteRemetente);
//		ADD o valor ao destinatario 
		ClienteEntity clienteDestino = clienteRepository.findById(transacaoDTO.getContaDestinatario()).get();
		Double novoSaldo = clienteDestino.getSaldoConta() + transacaoDTO.getValorTransacao();
		clienteDestino.setSaldoConta(novoSaldo);
		clienteRepository.save(clienteDestino);
//		Cria a linha na entidade transacao
		TransacaoEntity transacao = new TransacaoEntity();
		transacao.setContaRemetente(clienteRemetente.getContaCliente());
		transacao.setContaDestinatario(clienteDestino.getContaCliente());
		transacao.setValorTransacao(transacaoDTO.getValorTransacao());
		transacao.setDataTransacao(transacao.getDataTransacao());
		TransacaoEntity savedTransacao = transacaoRepository.save(transacao);

		return savedTransacao.getIdTransacoes();
	}

	public Long transferenciaRevert(TransacaoDTO transacaoDTO) {
		TransacaoEntity busca = transacaoRepository.findById(transacaoDTO.getIdTransacoes()).get();
//		subtrai o valor do remetente 
		ClienteEntity clienteRemetente = clienteRepository.findById(busca.getContaDestinatario()).get();
		Double subtraiValor = clienteRemetente.getSaldoConta() - busca.getValorTransacao();
		clienteRemetente.setSaldoConta(subtraiValor);
		clienteRepository.save(clienteRemetente);
//		ADD o valor ao destinatario 
		ClienteEntity clienteDestino = clienteRepository.findById(busca.getContaRemetente()).get();
		Double novoSaldo = clienteDestino.getSaldoConta() + busca.getValorTransacao();
		clienteDestino.setSaldoConta(novoSaldo);
		clienteRepository.save(clienteDestino);
//		Cria a linha na entidade transacao
		TransacaoEntity transacao = new TransacaoEntity();
		transacao.setContaRemetente(clienteRemetente.getContaCliente());
		transacao.setContaDestinatario(clienteDestino.getContaCliente());
		transacao.setValorTransacao(busca.getValorTransacao());
		transacao.setDataTransacao(transacao.getDataTransacao());
		TransacaoEntity savedTransacao = transacaoRepository.save(transacao);

		return savedTransacao.getIdTransacoes();

	}

	public Long agendaTransf(TransacaoDTO transacaoDTO) {
		
//		Busca cliente remetente
		ClienteEntity clienteRemetente = clienteRepository.findById(transacaoDTO.getContaRemetente()).get();
//		Já com o remetente, busca o recebe o valor de transação e subtrai da conta do remetente
		Double subtraiValor = clienteRemetente.getSaldoConta() - transacaoDTO.getValorTransacao();
		clienteRemetente.setSaldoConta(subtraiValor);
		clienteRepository.save(clienteRemetente);
//		ADD o valor ao destinatario 
		ClienteEntity clienteDestino = clienteRepository.findById(transacaoDTO.getContaDestinatario()).get();
		Double novoSaldo = clienteDestino.getSaldoConta() + transacaoDTO.getValorTransacao();
		clienteDestino.setSaldoConta(novoSaldo);
		clienteRepository.save(clienteDestino);
		Integer quantidadeParcela = transacaoDTO.getQuantidadeParcela();
		Integer numeroParcela = transacaoDTO.getNumeroParcela();
		
		for (numeroParcela = 0; numeroParcela < quantidadeParcela; numeroParcela++) {
            
            TransacaoEntity transacaoEntity = new TransacaoEntity();
    		transacaoEntity.setContaRemetente(clienteRemetente.getContaCliente());
    		transacaoEntity.setContaDestinatario(clienteDestino.getContaCliente());
    		transacaoEntity.setValorTransacao(transacaoDTO.getValorTransacao()/quantidadeParcela);
    		transacaoEntity.setDataTransacao(transacaoDTO.getDataTransacao());
    		transacaoEntity.setQuantidadeParcela(transacaoDTO.getQuantidadeParcela());
    		transacaoEntity.setDataTransacao(transacaoDTO.getDataTransacao());
    		transacaoEntity.setNumeroParcela(numeroParcela);
    		TransacaoEntity savedTransacao = transacaoRepository.save(transacaoEntity);
    		
    		savedTransacao.getIdTransacoes();
    		
        }
		
		return transacaoDTO.getIdTransacoes();

	}
	
	

}
