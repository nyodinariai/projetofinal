package api.spring.bluebank.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import api.spring.bluebank.model.Conta;
import api.spring.bluebank.model.Movimentacoes;
import api.spring.bluebank.repository.MovimentacoesRepository;
import api.spring.bluebank.service.MovimentacoesService;

@RestController
@RequestMapping("/movimentacoes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MovimentacoesController {

	@Autowired
	private MovimentacoesRepository mRepository;
	
	@Autowired
	private MovimentacoesService mService;

	@GetMapping
	public ResponseEntity<List<Movimentacoes>> buscarTodosId(){
		return ResponseEntity.ok(mRepository.findAll());
	}
	
//	@GetMapping("/{id}")
//	public ResponseEntity<List<Movimentacoes>> buscarMovPorId(@PathVariable Conta id){
//		return ResponseEntity.ok(mRepository.findMovByContaId(id));
//	}
	
	@PostMapping("/depositar")
	public ResponseEntity<ResponseEntity<Movimentacoes>> deposito(@RequestBody Movimentacoes novaMovimentacao) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(mService.deposito(novaMovimentacao));
	}
	
	@PostMapping("/sacar")
	public ResponseEntity<ResponseEntity<Movimentacoes>> sacar(@RequestBody Movimentacoes novaMovimentacao) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(mService.sacar(novaMovimentacao));
	}




}
