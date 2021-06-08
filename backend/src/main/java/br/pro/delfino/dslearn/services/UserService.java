package br.pro.delfino.dslearn.services;

import br.pro.delfino.dslearn.dtos.UserDTO;
import br.pro.delfino.dslearn.entities.User;
import br.pro.delfino.dslearn.repositories.UserRepository;
import br.pro.delfino.dslearn.services.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
	private final BCryptPasswordEncoder passwordEncoder;
	private final ModelMapper mapper;
	private final UserRepository repository;

	public UserService(BCryptPasswordEncoder passwordEncoder, ModelMapper mapper, UserRepository repository) {
		this.passwordEncoder = passwordEncoder;
		this.mapper = mapper;
		this.repository = repository;
	}

	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {
		Optional<User> optional = repository.findById(id);

		User entity = optional.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		UserDTO dto = mapper.map(entity, UserDTO.class);

		return dto;
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
