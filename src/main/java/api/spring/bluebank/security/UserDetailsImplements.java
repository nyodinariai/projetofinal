package api.spring.bluebank.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import api.spring.bluebank.model.Cliente;

public class UserDetailsImplements implements UserDetails {

	private static final long serialVersionUID = 1L;

	private String userName;
	private String password;
	private List<GrantedAuthority> autorizacoes;

	public UserDetailsImplements(Cliente cliente) {
		super();
		this.userName = cliente.getNome();
		this.password = cliente.getSenha();
	}

	public UserDetailsImplements() {
		super();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return autorizacoes;
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
