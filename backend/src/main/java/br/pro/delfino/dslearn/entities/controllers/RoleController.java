package br.pro.delfino.dslearn.entities.controllers;

import br.pro.delfino.dslearn.entities.Role;
import br.pro.delfino.dslearn.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/roles")
public class RoleController {
    private RoleService service;

    public RoleController(RoleService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Role findById(@PathVariable Long id) {
        return service.findById(id);
    }
}
