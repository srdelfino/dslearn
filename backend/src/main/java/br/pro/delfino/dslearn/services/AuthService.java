package br.pro.delfino.dslearn.services;

import br.pro.delfino.dslearn.entities.User;
import br.pro.delfino.dslearn.repositories.UserRepository;
import br.pro.delfino.dslearn.services.exceptions.ForbiddenException;
import br.pro.delfino.dslearn.services.exceptions.UnauthorizedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {
    private final UserRepository repository;

    public AuthService(UserRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public User authenticated() {
        try {
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            User entity = repository.findByEmail(username);
            return entity;
        }catch (RuntimeException exception){
            throw new UnauthorizedException("Invalid user");
        }
    }

    public void validateSelfOrAdmin(Long userId) {
        User entity = authenticated();

        if (!entity.getId().equals(userId) && ! entity.hasRole("ROLE_ADMIN")) {
            throw new ForbiddenException("Access denied");
        }
    }
}
