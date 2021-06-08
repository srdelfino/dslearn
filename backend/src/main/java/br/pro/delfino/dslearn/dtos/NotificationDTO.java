package br.pro.delfino.dslearn.dtos;

import br.pro.delfino.dslearn.entities.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.Instant;

@Getter
@Setter
public class NotificationDTO extends AbstractBaseDTO {
    private String text;

    private Instant moment;

    private Boolean read = false;

    private String route;

    private Long userId;
}
