package br.pro.delfino.dslearn.entities;

import br.pro.delfino.dslearn.entities.pks.EnrollmentPK;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Instant;
@Entity
@Table(name = "tb_enrollment")
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Enrollment {
    @EmbeddedId
    private EnrollmentPK id = new EnrollmentPK();

    @Column(columnDefinition = "timestamp without time zone")
    @Getter
    @Setter
    private Instant enrollMoment;

    @Column(columnDefinition = "timestamp without time zone")
    @Getter
    @Setter
    private Instant refundMoment;

    @Getter
    @Setter
    private Boolean available = true;

    @Getter
    @Setter
    private Boolean onlyUpdate;

    public Enrollment(User student, Offer offer, Instant enrollMoment, Instant refundMoment, Boolean available, Boolean onlyUpdate) {
        this.id.setUser(student);
        this.id.setOffer(offer);
        this.enrollMoment = enrollMoment;
        this.refundMoment = refundMoment;
        this.available = available;
        this.onlyUpdate = onlyUpdate;
    }

    public User getStudent(){
        return id.getUser();
    }

    public void setStudent (User student){
        this.id.setUser(student);
    }

    public Offer getOffer(){
        return id.getOffer();
    }

    public void setOffer(Offer offer){
        this.id.setOffer(offer);
    }
}
