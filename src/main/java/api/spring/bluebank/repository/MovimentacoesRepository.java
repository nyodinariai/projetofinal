package api.spring.bluebank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import api.spring.bluebank.model.Conta;
import api.spring.bluebank.model.Movimentacoes;

@Repository
public interface MovimentacoesRepository extends JpaRepository<Movimentacoes, Long> {

//	@Query(value ="SELECT m.id, m.mov_nome, m.valor, m.saldo_inicial, m.saldo_final, m.data FROM movimentacoes m WHERE m.conta_id_fk = :id", nativeQuery = true)
//	List<Movimentacoes> findMovByContaId(Conta contaId);
	
}
