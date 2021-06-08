package br.pro.delfino.dslearn.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_course")
public class Course extends  GenericEntity {
    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String imgUri;

    @Getter
    @Setter
    private String imgGrayUri;

    @OneToMany(mappedBy = "course")
    @Getter
    private Set<Offer> offers = new HashSet<>();
}
