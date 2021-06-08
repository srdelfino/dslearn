package br.pro.delfino.dslearn.repositories;

import br.pro.delfino.dslearn.entities.Deliver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliverRepository extends JpaRepository<Deliver, Long> {
}
