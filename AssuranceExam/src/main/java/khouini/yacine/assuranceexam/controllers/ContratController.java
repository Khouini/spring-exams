package khouini.yacine.assuranceexam.controllers;

import khouini.yacine.assuranceexam.entities.Contrat;
import khouini.yacine.assuranceexam.services.IContratService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("contrats")
public class ContratController {
    private final IContratService contratService;

    @GetMapping("benif/{id}")
    public Contrat getContrat1(@PathVariable int id) {
        System.out.println("find contart with benif: " + id);
        Contrat c = contratService.getContratBf(id);
        System.out.println("c:" + c);
        return c;
    }
}
