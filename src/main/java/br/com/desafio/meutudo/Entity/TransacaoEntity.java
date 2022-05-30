package br.com.desafio.meutudo.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "TB_TRANSACOES")
public class TransacaoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TRANSACOES")
	@JsonInclude(Include.NON_NULL)
	private Long idTransacoes;

	@Column(name = "CONTA_REMETENTE")
	@JsonInclude(Include.NON_NULL)
	private Long contaRemetente;

	@Column(name = "CONTA_DESTINATARIO")
	@JsonInclude(Include.NON_NULL)
	private Long contaDestinatario;

	@Column(name = "VALOR_TRANSACAO")
	@JsonInclude(Include.NON_NULL)
	private Integer valorTransacao;

	@Column(name = "DATA_TRANSACAO")
	@JsonInclude(Include.NON_NULL)
	private Date dataTransacao;

	@Column(name = "QUANTIDADE_PARCELA")
	@JsonInclude(Include.NON_NULL)
	private Integer quantidadeParcela;

	@Column(name = "NUMERO_PARCELA")
	@JsonInclude(Include.NON_NULL)
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
				"Transacao [idTransacoes=%s, contaRemetente=%s, contaDestinatario=%s,"
						+ " valorTransacao=%s, dataTransacao=%s, parcelaTransacao=%s]",
				idTransacoes, contaRemetente, contaDestinatario, valorTransacao,
				dataTransacao, quantidadeParcela);
	}

}
