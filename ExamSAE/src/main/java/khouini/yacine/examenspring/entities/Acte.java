package khouini.yacine.examenspring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Acte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codeActe;
    private int cotationActe;
    private float prixUnitaireActe;
    private String designationActe;

    @ManyToOne
    private FamilleActe familleActe;

    @ManyToMany(mappedBy = "actes")
    @JsonIgnore
    private List<Pathologie> pathologies;
}
