package khouini.yacine.assuranceexam.services;

import khouini.yacine.assuranceexam.entities.Assurance;
import khouini.yacine.assuranceexam.entities.Benificaire;
import khouini.yacine.assuranceexam.entities.Contrat;
import khouini.yacine.assuranceexam.repositories.AssuranceRepository;
import khouini.yacine.assuranceexam.repositories.BenificaireRepo;
import khouini.yacine.assuranceexam.repositories.ContratRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class AssuranceServiceImpl implements IAssuranceService {
    private final AssuranceRepository assuranceRepository;
    private final ContratRepo contratRepo;
    private final BenificaireRepo benificaireRepo;

    @Override
    public int ajouterAssurance(Assurance a, int cinBf) {
        Benificaire benificaire = benificaireRepo.findBenificaireByCin(cinBf);
        if (benificaire == null) throw new RuntimeException("Benificaire does not exists.");
        System.out.println("Benif: " + benificaire);
        a.setBenificaire(benificaire);
        System.out.println("contrat to save: " + a.getContrat());
        Contrat contrat = contratRepo.save(a.getContrat());
        System.out.println("saved contrat: " + contrat);
        System.out.println("assurance to save: " + a);
        Assurance savedAssurance = assuranceRepository.save(a);
        System.out.println("savedAssurance: " + savedAssurance);
        return 1;
    }

    public List<Assurance> getAssurances(){
        return assuranceRepository.findAll();
    }
}
