package khouini.yacine.examenspring.entities;
import jakarta.persistence.*;
import lombok.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TypePieceIdentite typePieceIdentite;
    private String identifiantPieceIdentite;
    private LocalDate dateEmission;
    private String nom;
    private String prenom;

    @ManyToMany
    private List<Pathologie> pathologies;
}
