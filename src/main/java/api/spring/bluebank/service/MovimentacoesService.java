package api.spring.bluebank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import api.spring.bluebank.model.Conta;
import api.spring.bluebank.model.Movimentacoes;
import api.spring.bluebank.repository.ContaRepository;
import api.spring.bluebank.repository.MovimentacoesRepository;

@Service
public class MovimentacoesService {

	@Autowired
	private MovimentacoesRepository mRepository;

	@Autowired
	private ContaRepository cRepository;

	public ResponseEntity<Movimentacoes> deposito(Movimentacoes mov) {
		List<Conta> contaExiste = cRepository.findByConta(mov.getConta());	
		mov.setSaldoInicial(contaExiste.get(0).getSaldo());
		mov.setSaldoFinal(mov.getSaldoInicial()+ mov.getValor());
		contaExiste.get(0).setSaldo(mov.getSaldoFinal());
		mov.getConta().getSaldo();
		Movimentacoes inserir = new Movimentacoes(mov.getConta(), mov.getMovNome(), mov.getValor(), mov.getSaldoInicial(), mov.getSaldoFinal());

		if (!contaExiste.isEmpty()) {
			System.out.println(contaExiste.get(0).getSaldo());

			return ResponseEntity.status(201).body(mRepository.save(inserir));
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

	public ResponseEntity<Movimentacoes> sacar(Movimentacoes mov) {
		List<Conta> contaExiste = cRepository.findByConta(mov.getConta());	
		mov.setSaldoInicial(contaExiste.get(0).getSaldo());
		mov.setSaldoFinal(mov.getSaldoInicial()- mov.getValor());
		contaExiste.get(0).setSaldo(mov.getSaldoFinal());
		Movimentacoes inserir = new Movimentacoes(mov.getConta(), mov.getMovNome(), mov.getValor(), mov.getSaldoInicial(), mov.getSaldoFinal());
		if (!contaExiste.isEmpty() && mov.getSaldoInicial() >= mov.getValor()) {
			System.out.println(contaExiste.get(0).getSaldo());
			return ResponseEntity.status(201).body(mRepository.save(inserir));
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
	
//	public ResponseEntity<List<Movimentacoes>> movPorId(Movimentacoes mov){
//		List<Conta> contaExiste = cRepository.findByConta(mov.getConta());
//		Conta contaId = mov.getConta();
//		if(!contaExiste.isEmpty()) {
//			return ResponseEntity.status(201).body(mRepository.findMovByContaId(contaId));
//		} else {
//		 return ResponseEntity.badRequest().build();
//		}
//	}
}
