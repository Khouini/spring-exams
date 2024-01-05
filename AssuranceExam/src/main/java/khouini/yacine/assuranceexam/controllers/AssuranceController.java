package khouini.yacine.assuranceexam.controllers;

import khouini.yacine.assuranceexam.entities.Assurance;
import khouini.yacine.assuranceexam.services.IAssuranceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/assurances")
public class AssuranceController {
    private final IAssuranceService assuranceService;
    @PostMapping("/{cin}")
    public int ajouterAssurance(@RequestBody Assurance a, @PathVariable int cin) {
        return assuranceService.ajouterAssurance(a, cin);

    }

    @GetMapping("")
    public List<Assurance> getAssurances(){
        return assuranceService.getAssurances();
    }}
