package api.spring.bluebank.service;

import java.nio.charset.Charset;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import api.spring.bluebank.model.Cliente;
import api.spring.bluebank.repository.ClienteRepository;

@Service
public class ClienteService {
	private @Autowired ClienteRepository repository;

	public Object cadastrarCliente(Cliente novocliente) {
		Optional<Cliente> clienteExistente = repository.findByEmail(novocliente.getEmail());

		Calendar nascimento = new GregorianCalendar();
		nascimento.setTime(novocliente.getData_nascimento());
		Calendar dataAtual = Calendar.getInstance();
		int idade = dataAtual.get(Calendar.YEAR) - nascimento.get(Calendar.YEAR);

		if (clienteExistente.isEmpty() && idade > 17) {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String senhaEncoder = encoder.encode(novocliente.getSenha());
			novocliente.setSenha(senhaEncoder);
			return repository.save(novocliente);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

	public Optional<Cliente> logar(Optional<Cliente> login) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Cliente> clienteExistente = repository.findByEmail(login.get().getEmail());

		if (clienteExistente.isPresent()) {
			if (encoder.matches(login.get().getSenha(), clienteExistente.get().getSenha())) {
				String auth = login.get().getEmail() + ":" + login.get().getSenha();
				byte[] encodeAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodeAuth);

				login.get().setToken(authHeader);
				login.get().setNome(clienteExistente.get().getNome());
				login.get().setSobrenome(clienteExistente.get().getSobrenome());
				login.get().setCpf(clienteExistente.get().getCpf());

				return login;
			}
		}
		return null;

	}

	public Optional<Cliente> alterarEmail(Long id, Cliente clienteParaAtualizar) {
		return repository.findById(id).map(emailExistente -> {
			emailExistente.setEmail(clienteParaAtualizar.getEmail());
			return Optional.ofNullable(repository.save(emailExistente));
		}).orElseGet(() -> {
			return Optional.empty();
		});

	}
}
