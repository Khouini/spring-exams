package khouini.yacine.assuranceexam.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Assurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String designation;
    private float montant;

    @ManyToOne
    private Contrat contrat;

        @ManyToOne
        private Benificaire benificaire;

    @Override
    public String toString() {
        return "Assurance{" +
                "id=" + id +
                ", designation='" + designation + '\'' +
                ", montant=" + montant +
               // ", contrat=" + contrat +
               // ", benificaire=" + benificaire +
                '}';
    }
}
