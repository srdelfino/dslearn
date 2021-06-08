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
@Table(name = "tb_reply")
public class Reply extends GenericEntity {
    @Column(columnDefinition = "text")
    @Getter
    @Setter
    private String body;

    @Column(columnDefinition = "timestamp without time zone")
    @Getter
    @Setter
    private Instant moment;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    @Getter
    @Setter
    private Topic topic;

    @ManyToOne
    @JoinColumn(name = "author_id")
    @Getter
    @Setter
    private User author;

    @ManyToMany
    @JoinTable(name = "tb_reply_likes",
            joinColumns = @JoinColumn(name = "reply_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    @Getter
    private Set<User> likes = new HashSet<>();
}
