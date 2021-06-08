package br.pro.delfino.dslearn.services;

import br.pro.delfino.dslearn.dtos.NotificationDTO;
import br.pro.delfino.dslearn.entities.Notification;
import br.pro.delfino.dslearn.entities.User;
import br.pro.delfino.dslearn.repositories.NotificationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NotificationService {
    private final AuthService authService;
    private final ModelMapper mapper;
    private final NotificationRepository repository;

    public NotificationService(AuthService authService, ModelMapper mapper, NotificationRepository repository) {
        this.authService = authService;
        this.mapper = mapper;
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Page<NotificationDTO> findNotificationsForCurrentUser(Pageable pageable){
        User entity = authService.authenticated();
        Page<Notification> entities = repository.findByUser(entity, pageable);
        Page<NotificationDTO> dtos = entities.map(source -> mapper.map(source, NotificationDTO.class));
        return dtos;
    }
}
