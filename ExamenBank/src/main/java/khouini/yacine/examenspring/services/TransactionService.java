package khouini.yacine.examenspring.services;


import khouini.yacine.examenspring.entities.*;
import khouini.yacine.examenspring.repositories.BankRepo;
import khouini.yacine.examenspring.repositories.CompteRepo;
import khouini.yacine.examenspring.repositories.TransactionRepo;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class TransactionService implements ITransactionService {
    final private TransactionRepo transactionRepo;
    final private CompteRepo compteRepo;
    final private BankRepo bankRepo;
    private static final Logger log = LoggerFactory.getLogger(TransactionService.class);

    @Override
    public String ajouterVirement(Transaction transaction) {
        Compte compteEx = compteRepo.findById(transaction.getCompteExpediteur().getId()).orElse(null);
        if (compteEx == null) {
            throw new RuntimeException("compteEx not found");
        }
        Compte compteDest = compteRepo.findById(transaction.getCompteDestinatire().getId()).orElse(null);
        if (compteDest == null) {
            throw new RuntimeException("comtpeDest not found");
        }
        if (compteEx.getSolde() < transaction.getMontant()) {
            throw new RuntimeException("sole insuffisant!");
        }

        if (compteEx.getType() == TypeCompte.EPARGNE) {
            throw new RuntimeException("One ne peut pas faire virement  a partir dun comtpe epargne");
        }

        if (compteEx.getSolde() < transaction.getMontant() + 3) {
            throw new RuntimeException("solde insuffisant");
        }


        compteEx.setSolde(compteEx.getSolde() - transaction.getMontant() - 3);
        compteRepo.save(compteEx);
        compteDest.setSolde(compteDest.getSolde() + transaction.getMontant());
        compteRepo.save(compteDest);
        transactionRepo.save(transaction);
        return "Virement de " + transaction.getMontant() + " de Compte " + transaction.getCompteExpediteur().getId() + " ver le compte " + transaction.getCompteDestinatire().getId() + " approuvée avec succées.";
    }

    @Override
    public String ajouterRetrait(Transaction transaction) {
        Compte compteEx = compteRepo.findById(transaction.getCompteExpediteur().getId()).orElse(null);
        if (compteEx == null) {
            throw new RuntimeException("compteEx not found");
        }
        if (compteEx.getSolde() < transaction.getMontant()) {
            throw new RuntimeException("sole insuffisant!");
        }
        if (compteEx.getSolde() < transaction.getMontant() + 2) {
            throw new RuntimeException("sole insuffisant!");
        }
        transactionRepo.save(transaction);
        compteEx.setSolde(compteEx.getSolde() - transaction.getMontant() - 2);
        compteRepo.save(compteEx);
        return "retrait de " + transaction.getMontant() + " de comtpe " + transaction.getCompteExpediteur().getId() + " approuvée avec succeés ";
    }

    @Override
    public String ajouterVersement(Transaction transaction) {
        return null;
    }

    @Override
    public List<Transaction> getAllTransactionByBankId(long idBank) {
        Bank bank = bankRepo.findById(idBank).orElse(null);
        if (bank == null) {
            throw new RuntimeException("Bank does not exists");
        }
        return null;
    }

    @Override
    public List<Transaction> getAllTransactionByTypeAndCompte(TypeTransaction type, long idCompte) {
        return null;
    }

    @Scheduled(fixedRate = 30000)
    public void getAllTransactionsByDate() {
        // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Extract the date part (ignoring time)
        LocalDate currentDate = currentDateTime.toLocalDate();
        log.info("Les transaction aijourdhui");
        for (Transaction transaction : transactionRepo.findAll()) {
            if (transaction.getDateTransaction().isAfter(currentDate) || transaction.getDateTransaction().isEqual(currentDate)) {
                log.info("Trasaction: " + transaction.getId() + " avec montant" + transaction.getMontant());
            }
        }
    }
}
