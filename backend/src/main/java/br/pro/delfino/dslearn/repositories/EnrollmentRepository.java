package br.pro.delfino.dslearn.repositories;

import br.pro.delfino.dslearn.entities.Enrollment;
import br.pro.delfino.dslearn.entities.pks.EnrollmentPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, EnrollmentPK> {
}
