package khouini.yacine.examenspring.services;

import khouini.yacine.examenspring.entities.Bank;
import khouini.yacine.examenspring.entities.Compte;
import khouini.yacine.examenspring.repositories.BankRepo;
import khouini.yacine.examenspring.repositories.CompteRepo;
import khouini.yacine.examenspring.repositories.TransactionRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AppService implements IAppService {
    private final BankRepo bankRepo;
    private final CompteRepo compteRepo;
    private final TransactionRepo transactionRepo;

    @Override
    public String test() {
        return "Hello from exam spring";
    }

    @Override
    public Bank ajouterBank(Bank bank) {
        return bankRepo.save(bank);
    }

    @Override
    public Compte ajouterCompteEtAffecterAAgence(Compte compte, String agenceBank) {
        Bank bank = bankRepo.findBankByAgence(agenceBank);
        if (bank == null) {
            throw new RuntimeException("bank not found");
        }
        Compte savedAccount = compteRepo.save(compte);
        System.out.println("saved comtpe: " + savedAccount);


        List<Compte> comptes = bank.getComptes();
        comptes.add(savedAccount);
        Bank savedBank = bankRepo.save(bank);
        System.out.println("saved bank: " + savedBank);
        return savedAccount;
    }
}
