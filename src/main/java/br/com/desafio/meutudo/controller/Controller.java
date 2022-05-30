package br.com.desafio.meutudo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.meutudo.Entity.ClienteEntity;
import br.com.desafio.meutudo.dto.ClienteDTO;
import br.com.desafio.meutudo.dto.TransacaoDTO;
import br.com.desafio.meutudo.service.Service;

@RestController
@RequestMapping("/banco")
public class Controller {

	@Autowired
	private Service service;
	
	@RequestMapping(method = RequestMethod.POST)
	public void salva(@RequestBody ClienteEntity cliente) {
		service.salvarCliente(cliente);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> mostraSaldo(@PathVariable("id") Long id) {
		ClienteDTO cliente = service.mostraSaldo(id);
		if (cliente == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(cliente);
	}
	
	@RequestMapping(value = "/transf", method = RequestMethod.POST)
	public ResponseEntity<Long> transferencia(@RequestBody TransacaoDTO transacaoDTO) {
		Long responseTransf = service.transferencia(transacaoDTO);
		return ResponseEntity.status(HttpStatus.OK).body(responseTransf);
	}
	
	@RequestMapping(value = "/revert/transf", method = RequestMethod.POST)
	public ResponseEntity<Long> revertTransf(@RequestBody TransacaoDTO transacaoDTO) {
		Long responseRevert = service.transferenciaRevert(transacaoDTO);
		return ResponseEntity.status(HttpStatus.OK).body(responseRevert);
	}
	
	@RequestMapping(value = "/agendaTransf", method = RequestMethod.POST)
	public ResponseEntity<Long> agendaTransf(@RequestBody TransacaoDTO transacaoDTO) {
		Long responseAgenda = service.agendaTransf(transacaoDTO);
		return ResponseEntity.status(HttpStatus.OK).body(responseAgenda);
	}
}
