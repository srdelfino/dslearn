package br.pro.delfino.dslearn.entities;

import br.pro.delfino.dslearn.entities.enums.ResourceType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_resource")
public class Resource extends GenericEntity {
    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private Integer position;

    @Getter
    @Setter
    private String imgUri;

    @Getter
    @Setter
    private ResourceType type;

    @ManyToOne
    @JoinColumn(name = "offer_id")
    @Getter
    @Setter
    private Offer offer;

    @OneToMany(mappedBy = "resource")
    @Getter
    private Set<Section> sections = new HashSet<>();
}
