package khouini.yacine.assuranceexam.services;

import khouini.yacine.assuranceexam.entities.Assurance;
import khouini.yacine.assuranceexam.entities.Benificaire;
import khouini.yacine.assuranceexam.entities.Contrat;
import khouini.yacine.assuranceexam.repositories.BenificaireRepo;
import khouini.yacine.assuranceexam.repositories.ContratRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class ContratServiceImpl implements IContratService {
    final private ContratRepo contratRepo;
    final private BenificaireRepo benificaireRepo;

    @Override
    public Contrat getContratBf(int idBf) {
        Benificaire benificaire = benificaireRepo.findById(idBf).orElse(null);
        if (benificaire == null) {
            throw new RuntimeException("benif dont exists");
        }
        Contrat maxContract = benificaire.getAssurances().get(0).getContrat();
        System.out.println("benif:" + benificaire);
        for (int i = 1; i < benificaire.getAssurances().size(); i++) {
            Assurance a = benificaire.getAssurances().get(i);
            if (a.getContrat().getDateEffet().isAfter(maxContract.getDateEffet())) {
                maxContract = a.getContrat();
            }
        }
        return maxContract;
    }
}
