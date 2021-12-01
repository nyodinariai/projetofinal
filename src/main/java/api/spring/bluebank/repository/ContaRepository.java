package api.spring.bluebank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import api.spring.bluebank.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long>{

	@Query(value = "SELECT * FROM conta c WHERE c.conta = :conta ", nativeQuery = true)
	List<Conta> findByConta( Conta conta);
}
