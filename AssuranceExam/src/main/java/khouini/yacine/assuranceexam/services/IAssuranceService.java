package khouini.yacine.assuranceexam.services;

import khouini.yacine.assuranceexam.entities.Assurance;

import java.util.List;

public interface IAssuranceService {
    public int ajouterAssurance (Assurance a, int cinBf);
    public List<Assurance> getAssurances();
}
