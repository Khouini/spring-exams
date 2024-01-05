package khouini.yacine.examenspring.services;

import khouini.yacine.examenspring.entities.FamilleActe;
import khouini.yacine.examenspring.entities.Pathologie;
import khouini.yacine.examenspring.entities.Patient;

public interface IAppService {
    String test();
    public Pathologie ajouterPathologie(Pathologie path);
    public Patient ajouterPatientEtAffecterAPathologie(Patient p, String codePath);

    public FamilleActe ajouterFamilleActeEtActeAssocie(FamilleActe facte);

    public void affecterActeAPathologie(String codeActe , String codePathologie);

    public void calculerNombreActesParPathologie();

    public float calculerFacture(String identifiant);
}
