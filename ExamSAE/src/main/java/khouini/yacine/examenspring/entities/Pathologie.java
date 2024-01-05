package khouini.yacine.examenspring.entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Pathologie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codePath;
    private String libelle;
    private String description;
    private Boolean archive;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Acte> actes;
}
