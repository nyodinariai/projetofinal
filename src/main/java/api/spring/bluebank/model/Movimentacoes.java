package api.spring.bluebank.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


@Entity
@Table(name="movimentacoes")
public class Movimentacoes{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

//	@Column(name = "conta_id")
//	private Long conta;
	
	//Saque/Deposito/Pagamento
	@Column(name = "movNome", nullable = false, length = 60)
	private String movNome;
	
	@Column(name = "valor", nullable = false, length = 60)
	private Double valor;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data")
	private Date data = new java.sql.Date(System.currentTimeMillis());
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "conta_id_fk", nullable = false)
	@JsonProperty(access = Access.WRITE_ONLY)
	private Conta conta;

	private Double saldoFinal;

	private Double saldoInicial;
	
	public Double getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(Double saldoIncial) {
		this.saldoInicial = saldoIncial;
	}

	public Double getSaldoFinal() {
		return saldoFinal;
	}

	public void setSaldoFinal(Double saldoFinal) {
		this.saldoFinal = saldoFinal;
	}

	public Movimentacoes() {
		this(new Date());
	}
	
	public Movimentacoes(Conta conta, String movNome, Double valor, Double saldoInicial, Double saldoFinal) {
		super();
		this.setConta(conta);
		this.setMovNome(movNome);
		this.setValor(valor);
		this.setSaldoInicial(saldoInicial);
		this.setSaldoFinal(saldoFinal);
	}

	public Movimentacoes(Date data) {
		super();
		this.data = data;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMovNome() {
		return movNome;
	}

	public void setMovNome(String movNome) {
		this.movNome = movNome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

//	public Long getConta() {
//		return conta;
//	}
//
//
//	public void setConta(Long conta) {
//		this.conta = conta;
//	}
	
	
	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
}
