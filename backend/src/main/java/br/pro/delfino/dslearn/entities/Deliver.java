package br.pro.delfino.dslearn.entities;

import br.pro.delfino.dslearn.entities.enums.DeliverStatus;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "tb_deliver")
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class Deliver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uri;

    @Column(columnDefinition = "timestamp without time zone")
    private Instant moment;

    private DeliverStatus status;

    private String feedback;

    private Integer correctCount;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "offer_id"),
            @JoinColumn(name = "user_id")
    })
    private Enrollment enrollment;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;
}
