package br.pro.delfino.dslearn.repositories;

import br.pro.delfino.dslearn.entities.Notification;
import br.pro.delfino.dslearn.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    Page<Notification> findByUser (User user, Pageable pageable);
}
