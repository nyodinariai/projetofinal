package api.spring.bluebank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Agência e Conta não encontradas.")
public class NaoEcontrado extends RuntimeException {

	
	private static final long serialVersionUID = 1L;

}
