package br.pro.delfino.dslearn.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "tb_notification")
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private Instant moment;
    private Boolean read = false;
    private String route;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
