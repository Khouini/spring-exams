package khouini.yacine.assuranceexam.entities;
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
public class Benificaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true) // Make cin field unique
    private int cin;
    private String nom;
    private String prenom;
    private String profession;
    private float salaire;

    @JsonIgnore
    @OneToMany(mappedBy = "benificaire", fetch = FetchType.EAGER)
    private List<Assurance> assurances;

    @Override
    public String toString() {
        return "Benificaire{" +
                "id=" + id +
                ", cin=" + cin +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", profession='" + profession + '\'' +
                ", salaire=" + salaire +
                ", assurances=" + assurances +
                '}';
    }
}
