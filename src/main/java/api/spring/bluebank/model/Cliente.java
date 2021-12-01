package api.spring.bluebank.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.UniqueElements;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author hanely cadastro de cliente listagem de cliente atualização de cliente
 *         deletar clientes historico de transações entre contas
 */
@Entity
@Table(name = "cliente", uniqueConstraints = { @UniqueConstraint(columnNames = { "cpf" }) })

public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome", nullable = false, length = 60)
	private String nome;

	@Column(name = "sobrenome", nullable = false, length = 60)
	private String sobrenome;

	@Column(name = "email", nullable = false, unique = true, length = 60)
	@Email
	private String email;

	@CPF
	@Column(unique = true, nullable = false, length = 11)
	private String cpf;

	// @Column(name = "telefone", nullable = true, unique = true, length = 11)
	private int telefone;

	// @Column(name = "dataNascimento", nullable = false)
	private Date data_nascimento;

	private String senha;

	private String token;

	// relationship

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({"cliente", "movimentacoes"})
	private List<Conta> conta = new ArrayList<>();

	// special methods

	public Long getId() {
		return id;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<Conta> getConta() {
		return conta;
	}

	public void setConta(List<Conta> conta) {
		this.conta = conta;
	}

}
