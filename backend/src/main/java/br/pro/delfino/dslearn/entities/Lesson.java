package br.pro.delfino.dslearn.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_lesson")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Lesson extends  GenericEntity {
    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private Integer position;

    @ManyToOne
    @JoinColumn(name = "section_id")
    @Getter
    @Setter
    private Section section;

    @OneToMany(mappedBy = "lesson")
    @Getter
    private Set<Deliver> deliveries = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "tb_lessons_done",
            joinColumns = @JoinColumn(name = "lesson_id"),
            inverseJoinColumns = {
                    @JoinColumn(name = "user_id"),
                    @JoinColumn(name = "offer_id")
            }
    )
    @Getter
    private Set<Enrollment> enrollmentsDone = new HashSet<>();
}
