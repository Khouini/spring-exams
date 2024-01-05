package khouini.yacine.assuranceexam.services;

import khouini.yacine.assuranceexam.entities.Assurance;
import khouini.yacine.assuranceexam.entities.Benificaire;
import khouini.yacine.assuranceexam.entities.TypeContrat;
import khouini.yacine.assuranceexam.repositories.AssuranceRepository;
import khouini.yacine.assuranceexam.repositories.BenificaireRepo;
import khouini.yacine.assuranceexam.repositories.ContratRepo;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class BenificaireServiceImpl implements IBenificaireService {
    private static final Logger log = LoggerFactory.getLogger(BenificaireServiceImpl.class);
    final private BenificaireRepo benificaireRepo;
    final private ContratRepo contratRepo;
    final private AssuranceRepository assuranceRepository;

    @Override
    public int ajouterBeneficaire(Benificaire bf) {
        try {
            benificaireRepo.save(bf);
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
        return 1;
    }

    @Override
    public float getMontantBf(int cinBf) {
        Benificaire benificaire = benificaireRepo.findBenificaireByCin(cinBf);
        System.out.println(benificaire);
        if (benificaire == null) {
            throw new RuntimeException("benif dont exists");
        }
        float total = 0;
        for (Assurance assurance : benificaire.getAssurances()) {
            switch (assurance.getContrat().getType()) {
                case Annuel:
                    total += assurance.getMontant();
                    break;
                case Semestriel:
                    total += assurance.getMontant() * 2;
                    break;
                case Mensuel:
                    total += assurance.getMontant() * 12;
                    break;
                default:
                    throw new RuntimeException("Invalid type");
            }
        }
        return total;
    }

    @Override
    public Set<Benificaire> getBeneficairesAsType(TypeContrat typeContrat) {
        Set<Benificaire> rs = new HashSet<>();
        for (Benificaire b : benificaireRepo.findAll()) {
            for (Assurance a : b.getAssurances()) {
                if (a.getContrat().getType() == typeContrat) {
                    rs.add(b);
                }
            }
        }
        return rs;
    }

    @Override
    @Scheduled(fixedRate = 60000)
    public void statistiques() {
        log.info("statistiques:");
        TreeMap<Integer, Integer> rs = new TreeMap<>(Collections.reverseOrder());
        for (Benificaire b : benificaireRepo.findAll()) {
            rs.put(b.getCin(), b.getAssurances().size());
        }
        for (Map.Entry<Integer, Integer> va : rs.entrySet()) {
            log.info("Benif: " + va.getKey() + " a " + va.getValue() + " assurances");
        }
    }
}
