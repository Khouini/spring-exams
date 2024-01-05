package khouini.yacine.examenspring.entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class FamilleActe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codeFA;
    private String libelle;
    private String description;

    @OneToMany(mappedBy = "familleActe")
    List<Acte> actes;
}
