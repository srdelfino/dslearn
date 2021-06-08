package br.pro.delfino.dslearn.services;

import br.pro.delfino.dslearn.entities.Role;
import br.pro.delfino.dslearn.repositories.RoleRepository;
import br.pro.delfino.dslearn.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class RoleService {
    private RoleRepository repository;

    public RoleService (RoleRepository repository){
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Role findById(Long id) {
        Optional<Role> optional = repository.findById(id);

        Role entity = optional.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));

        return entity;
    }
}
