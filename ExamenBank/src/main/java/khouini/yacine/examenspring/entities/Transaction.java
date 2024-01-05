package khouini.yacine.examenspring.entities;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double montant;
    @Enumerated(EnumType.STRING)
    private TypeTransaction type;
    private LocalDate dateTransaction;


    @ManyToOne
    private Compte compteExpediteur;
    @ManyToOne
    private Compte compteDestinatire;
}
