package khouini.yacine.examenspring.controllers;

import khouini.yacine.examenspring.entities.Bank;
import khouini.yacine.examenspring.entities.Compte;
import khouini.yacine.examenspring.entities.Transaction;
import khouini.yacine.examenspring.entities.TypeTransaction;
import khouini.yacine.examenspring.services.IAppService;
import khouini.yacine.examenspring.services.ITransactionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("restApp")
@AllArgsConstructor
public class AppController {
    private final IAppService appService;
    private final ITransactionService transactionService;

    @GetMapping("test")
    public String test() {
        return appService.test();
    }

    @PostMapping("addBank")
    public Bank ajouterBank(@RequestBody Bank bank) {
        return appService.ajouterBank(bank);
    }

    @PostMapping("addCompteAndAffectToBank/{agenceBank}")
    public Compte ajouterCompteEtAffecterAAgence(@RequestBody Compte compte, @PathVariable String agenceBank) {
        return appService.ajouterCompteEtAffecterAAgence(compte, agenceBank);
    }

    @PostMapping("addTransaction")
    public String addTransaction(@RequestBody Transaction transaction) {
        if (transaction.getType() == TypeTransaction.RETRAIT) {
            return transactionService.ajouterRetrait(transaction);
        } else if (transaction.getType() == TypeTransaction.VERSEMENT) {
            return transactionService.ajouterVersement(transaction);
        } else if (transaction.getType() == TypeTransaction.VIREMENT) {
            return transactionService.ajouterVirement(transaction);
        }
        throw new RuntimeException("Unhandled transaction type");
    }
}
