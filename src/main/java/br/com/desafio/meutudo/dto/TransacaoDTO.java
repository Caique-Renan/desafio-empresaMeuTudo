package br.com.desafio.meutudo.dto;

import java.sql.Date;

public class TransacaoDTO {

	private Long idTransacoes;
	private Long contaRemetente;
	private Long contaDestinatario;
	private Integer valorTransacao;
	private Date dataTransacao;

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

	@Override
	public String toString() {
		return String.format(
				"TransacaoDTO [idTransacoes=%s, contaRemetente=%s, "
						+ "contaDestinatario=%s, valorTransacao=%s, dataTransacao=%s]",
				idTransacoes, contaRemetente, contaDestinatario, valorTransacao, dataTransacao);
	}

}
