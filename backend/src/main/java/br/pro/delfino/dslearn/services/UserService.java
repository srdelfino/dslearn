package br.pro.delfino.dslearn.services;

import br.pro.delfino.dslearn.entities.User;
import br.pro.delfino.dslearn.repositories.RoleRepository;
import br.pro.delfino.dslearn.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
	private final BCryptPasswordEncoder passwordEncoder;
	private final UserRepository repository;

	public UserService(BCryptPasswordEncoder passwordEncoder, UserRepository repository) {
		this.passwordEncoder = passwordEncoder;
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findByEmail(username);

		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}

		return user;
	}
}
