package br.pro.delfino.dslearn.resources;

import br.pro.delfino.dslearn.dtos.NotificationDTO;
import br.pro.delfino.dslearn.dtos.UserDTO;
import br.pro.delfino.dslearn.services.NotificationService;
import br.pro.delfino.dslearn.services.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
public class NotificationResource {
    private final NotificationService service;

    public NotificationResource(NotificationService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<NotificationDTO>> findNotificationsForCurrentUser(Pageable pageable){
        Page<NotificationDTO> page = service.findNotificationsForCurrentUser(pageable);
        return ResponseEntity.ok().body(page);
    }

}
