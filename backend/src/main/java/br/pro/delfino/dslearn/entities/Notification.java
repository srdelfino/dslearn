package br.pro.delfino.dslearn.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "tb_notification")
@Getter
@Setter
public class Notification extends AbstractBaseEntity {
    private String text;

    @Column(columnDefinition = "timestamp without time zone")
    private Instant moment;

    private Boolean read = false;

    private String route;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
