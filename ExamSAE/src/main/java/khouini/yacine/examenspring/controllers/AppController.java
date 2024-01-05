package khouini.yacine.examenspring.controllers;

import khouini.yacine.examenspring.entities.FamilleActe;
import khouini.yacine.examenspring.entities.Pathologie;
import khouini.yacine.examenspring.entities.Patient;
import khouini.yacine.examenspring.services.IAppService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("restApp")
@AllArgsConstructor
public class AppController {
    private final IAppService appService;

    @GetMapping("test")
    public String test() {
        return appService.test();
    }

    @PostMapping("addPathologie")
    public Pathologie ajouterPathologie(@RequestBody Pathologie path) {
        return appService.ajouterPathologie(path);
    }

    @PostMapping("addPatient/{codePath}")
    public Patient ajouterPatientEtAffecterAPathologie(@RequestBody Patient p, @PathVariable String codePath) {
        return appService.ajouterPatientEtAffecterAPathologie(p, codePath);
    }

    @PostMapping("addFActe")
    public FamilleActe ajouterFamilleActeEtActeAssocie(@RequestBody FamilleActe facte) {
        return appService.ajouterFamilleActeEtActeAssocie(facte);
    }

    @PutMapping("affecterPA/{codeActe}/{codePathologie}")
    public String affecterActeAPathologie(@PathVariable String codeActe, @PathVariable String codePathologie) {
        appService.affecterActeAPathologie(codeActe, codePathologie);
        return "affected success";
    }

    @GetMapping("calculerFacture/{identifiant}")
    public float calculerFacture(@PathVariable String identifiant){
        return appService.calculerFacture(identifiant);
    }
}
