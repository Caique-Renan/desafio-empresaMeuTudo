package br.com.desafio.meutudo.service;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.desafio.meutudo.Entity.Cliente;
import br.com.desafio.meutudo.dto.ClienteDTO;
import br.com.desafio.meutudo.repository.ClienteRepository;

@org.springframework.stereotype.Service
public class Service {

//	@Autowired
//	private Cliente cliente;
	
//	@Autowired
//	private Conta conta;
	
	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente salvarCliente(Cliente cliente) {
		cliente.setContaCliente(null);
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

}
