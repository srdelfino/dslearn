package br.pro.delfino.dslearn.resources;

import br.pro.delfino.dslearn.dtos.UserDTO;
import br.pro.delfino.dslearn.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserResource {
    private final UserService service;

    public UserResource(UserService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO findById(@PathVariable Long id){
        UserDTO dto = service.findById(id);
        return dto;
    }

}
