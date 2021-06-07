package br.pro.delfino.dslearn.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_offer")
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String edition;

    @Column(columnDefinition = "timestamp without time zone")
    @Getter
    @Setter
    private Instant startMoment;

    @Column(columnDefinition = "timestamp without time zone")
    @Getter
    @Setter
    private Instant endMoment;

    @ManyToOne
    @JoinColumn(name = "course_id")
    @Getter
    @Setter
    private Course course;

    @OneToMany(mappedBy = "offer")
    @Getter
    private Set<Resource> resources = new HashSet<>();
}
