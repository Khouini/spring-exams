package khouini.yacine.assuranceexam.controllers;

import khouini.yacine.assuranceexam.entities.Benificaire;
import khouini.yacine.assuranceexam.entities.TypeContrat;
import khouini.yacine.assuranceexam.services.IBenificaireService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/benificaires")
@AllArgsConstructor
public class BenificiareController {
    private final IBenificaireService benificaireService;

    @PostMapping("")
    public int ajouterBeneficaire(@RequestBody Benificaire bf) {
        return benificaireService.ajouterBeneficaire(bf);
    }

    @GetMapping("/beinfAnnuutel/{cin}")
    public float getMontantBf(@PathVariable int cin) {
        return benificaireService.getMontantBf(cin);
    }

    @GetMapping("/getBeneficairesAsType/{typeContrat}")
    public Set<Benificaire> getBeneficairesAsType(@PathVariable String typeContrat){
        TypeContrat type = TypeContrat.valueOf(typeContrat);
        System.out.println("Type is " + type);
        return benificaireService.getBeneficairesAsType(type);
    }
}
