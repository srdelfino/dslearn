package br.pro.delfino.dslearn.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_role")
@Getter
@Setter
public class Role extends AbstractBaseEntity {
    private String authority;
}
