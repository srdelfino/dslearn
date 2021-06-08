package br.pro.delfino.dslearn.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_topic")
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String title;

    @Column(columnDefinition = "text")
    @Getter
    @Setter
    private String body;

    @Column(columnDefinition = "timestamp without time zone")
    @Getter
    @Setter
    private Instant moment;

    @ManyToOne
    @JoinColumn(name = "author_id")
    @Getter
    @Setter
    private User author;

    @ManyToOne
    @JoinColumn(name = "offer_id")
    @Getter
    @Setter
    private Offer offer;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    @Getter
    @Setter
    private Lesson lesson;

    @ManyToOne
    @JoinColumn(name = "reply_id")
    private Reply answer;

    @ManyToMany
    @JoinTable(name = "tb_topic_likes",
            joinColumns = @JoinColumn(name = "topic_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    @Getter
    private Set<User> likes = new HashSet<>();

    @OneToMany(mappedBy = "topic")
    private List<Reply> replies = new ArrayList<>();
}
