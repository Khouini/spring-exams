package khouini.yacine.examenspring.services;

import khouini.yacine.examenspring.entities.Acte;
import khouini.yacine.examenspring.entities.FamilleActe;
import khouini.yacine.examenspring.entities.Pathologie;
import khouini.yacine.examenspring.entities.Patient;
import khouini.yacine.examenspring.repositories.ActeRepo;
import khouini.yacine.examenspring.repositories.FamilleActeRepo;
import khouini.yacine.examenspring.repositories.PathologieRepo;
import khouini.yacine.examenspring.repositories.PatientRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class AppService implements IAppService {
    final private PathologieRepo pathologieRepo;
    final private PatientRepository patientRepository;

    final private FamilleActeRepo familleActeRepo;
    final private ActeRepo acteRepo;
    private static final Logger log = LoggerFactory.getLogger(AppService.class);

    @Override
    public String test() {
        return "Hello from exam spring";
    }

    @Override
    public Pathologie ajouterPathologie(Pathologie path) {
        return pathologieRepo.save(path);
    }

    @Override
    public Patient ajouterPatientEtAffecterAPathologie(Patient p, String codePath) {
        Pathologie pathologie = pathologieRepo.findPathologieByCodePath(codePath);
        if (pathologie == null) {
            throw new RuntimeException("Patholo not found");
        }
        List<Pathologie> pathologies = new ArrayList<>();
        pathologies.add(pathologie);
        p.setPathologies(pathologies);

        System.out.println("Patent to save: " + p);
        Patient savedPatient = patientRepository.save(p);
        System.out.println("saved patient:" + savedPatient);
        return savedPatient;
    }

    @Override
    public FamilleActe ajouterFamilleActeEtActeAssocie(FamilleActe facte) {
        FamilleActe savedFamilleActe = familleActeRepo.save(facte);
        System.out.println("saved FCATE" + savedFamilleActe);
        List<Acte> actes = facte.getActes();
        System.out.println("actes" + actes);
        for (Acte acte : actes) {
            acte.setFamilleActe(savedFamilleActe);
            Acte savedActe = acteRepo.save(acte);
            System.out.println("saved acte: " + savedActe);
        }
        facte.setActes(null);
        return facte;
    }

    @Override
    public void affecterActeAPathologie(String codeActe, String codePathologie) {
        Pathologie pathologie = pathologieRepo.findPathologieByCodePath(codePathologie);
        if (pathologie == null) {
            throw new RuntimeException("patho not found");
        }
        Acte acte = acteRepo.findActeByCodeActe(codeActe);
        if (acte == null) {
            throw new RuntimeException("acte not found");
        }
        List<Acte> actes = pathologie.getActes();
        actes.add(acte);

        pathologie.setActes(actes);
        pathologieRepo.save(pathologie);
    }

    @Scheduled(fixedRate = 10000)
    @Override
    public void calculerNombreActesParPathologie() {
        for (Pathologie pathologie : pathologieRepo.findAll()) {
            log.info("pato " + pathologie.getCodePath() + " a " + pathologie.getActes().size() + " actes ");
        }
    }

    public float calculerFacture(String identifiant) {
        Pathologie pathologie = pathologieRepo.findPathologieByCodePath(identifiant);
        if (pathologie == null) {
            throw new RuntimeException("patho not found");
        }
        System.out.println("actes"+ pathologie.getActes());
        float total = 0;
        for (Acte acte : pathologie.getActes()) {
            System.out.println(total);
            total += acte.getPrixUnitaireActe() * acte.getCotationActe();
            System.out.println(total);
        }
        return total;
    }
}
