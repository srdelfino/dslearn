package br.pro.delfino.dslearn.repositories;

import br.pro.delfino.dslearn.entities.AbstractBaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface AbstractBaseRepository <T extends AbstractBaseEntity, ID extends Serializable> extends JpaRepository<T, ID>{
}
