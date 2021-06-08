package br.pro.delfino.dslearn.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "tb_task")
@Getter
@Setter
public class Task extends Lesson {
    private String description;

    private Integer questionCount;

    private Integer approvalCount;

    private Double weight = 1.0;

    @Column(columnDefinition = "timestamp without time zone")
    private Instant dueDate;
}
