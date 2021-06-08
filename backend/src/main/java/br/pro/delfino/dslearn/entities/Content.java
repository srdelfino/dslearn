package br.pro.delfino.dslearn.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_content")
@NoArgsConstructor
@Getter
@Setter
public class Content extends Lesson {
    private String textContent;

    private String videoUri;
}
