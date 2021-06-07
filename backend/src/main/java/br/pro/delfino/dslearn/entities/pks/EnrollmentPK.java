package br.pro.delfino.dslearn.entities.pks;

import br.pro.delfino.dslearn.entities.Offer;
import br.pro.delfino.dslearn.entities.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class EnrollmentPK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "student_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;
}
