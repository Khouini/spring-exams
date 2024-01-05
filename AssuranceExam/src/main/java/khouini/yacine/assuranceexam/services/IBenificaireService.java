package khouini.yacine.assuranceexam.services;

import khouini.yacine.assuranceexam.entities.Benificaire;
import khouini.yacine.assuranceexam.entities.TypeContrat;

import java.util.Set;

public interface IBenificaireService {
    public int ajouterBeneficaire (Benificaire bf);
    public float getMontantBf (int cinBf);

    public Set<Benificaire> getBeneficairesAsType(TypeContrat typeContrat);

    public void statistiques ();
}
