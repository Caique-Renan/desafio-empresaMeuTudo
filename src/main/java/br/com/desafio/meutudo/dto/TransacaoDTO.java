package br.com.desafio.meutudo.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TransacaoDTO {

	private Long idTransacoes;
	private Long contaRemetente;
	private Long contaDestinatario;
	private Integer valorTransacao;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@JsonFormat(shape = JsonFormat.Shape.STRING, 
	pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
	private Date dataTransacao;
	
	private Integer quantidadeParcela;
	private Integer numeroParcela;

	public Long getIdTransacoes() {
		return idTransacoes;
	}

	public void setIdTransacoes(Long idTransacoes) {
		this.idTransacoes = idTransacoes;
	}

	public Long getContaRemetente() {
		return contaRemetente;
	}

	public void setContaRemetente(Long contaRemetente) {
		this.contaRemetente = contaRemetente;
	}

	public Long getContaDestinatario() {
		return contaDestinatario;
	}

	public void setContaDestinatario(Long contaDestinatario) {
		this.contaDestinatario = contaDestinatario;
	}

	public Integer getValorTransacao() {
		return valorTransacao;
	}

	public void setValorTransacao(Integer valorTransacao) {
		this.valorTransacao = valorTransacao;
	}

	public Date getDataTransacao() {
		return dataTransacao;
	}

	public void setDataTransacao(Date dataTransacao) {
		this.dataTransacao = dataTransacao;
	}

	public Integer getQuantidadeParcela() {
		return quantidadeParcela;
	}

	public void setQuantidadeParcela(Integer quantidadeParcela) {
		this.quantidadeParcela = quantidadeParcela;
	}

	public Integer getNumeroParcela() {
		return numeroParcela;
	}

	public void setNumeroParcela(Integer numeroParcela) {
		this.numeroParcela = numeroParcela;
	}

	@Override
	public String toString() {
		return String.format(
				"TransacaoDTO [idTransacoes=%s, contaRemetente=%s, "
						+ "contaDestinatario=%s, valorTransacao=%s, dataTransacao=%s, parcelaTransacao=%s]",
				idTransacoes, contaRemetente, contaDestinatario, valorTransacao, dataTransacao, quantidadeParcela);
	}

}
