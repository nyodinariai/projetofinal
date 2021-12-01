package api.spring.bluebank.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import api.spring.bluebank.exception.NaoEcontrado;
import api.spring.bluebank.model.Conta;
import api.spring.bluebank.repository.ContaRepository;
import api.spring.bluebank.repository.MovimentacoesRepository;

@Service
public class ContaService {
	@Autowired
	private ContaRepository repository;
	
//	public Conta verificaConta(Long id, int agencia, String conta, double saldo){
//		Optional<Conta> conta1 = repository.findById(id);
//		return conta1.orElseThrow(() -> new NaoEcontrado(
//				"conta não válida" + Conta.class.getName();
//				));
//	}

//	public void deposita(double valor, Long id) {
//		Optional<Conta> conta = repository.findById(id);
//		
//		conta.get().getSaldo() += valor;
//	}
	
	
	
}

