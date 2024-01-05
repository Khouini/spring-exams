package khouini.yacine.examenspring.services;

import khouini.yacine.examenspring.entities.Bank;
import khouini.yacine.examenspring.entities.Compte;

public interface IAppService {
    String test();

    public Bank ajouterBank(Bank bank);

    public Compte ajouterCompteEtAffecterAAgence(Compte compte, String agenceBank);
}
