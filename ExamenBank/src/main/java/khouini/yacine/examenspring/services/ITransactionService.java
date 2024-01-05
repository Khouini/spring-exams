package khouini.yacine.examenspring.services;

import khouini.yacine.examenspring.entities.Transaction;
import khouini.yacine.examenspring.entities.TypeTransaction;

import java.util.List;

public interface ITransactionService {
    public String ajouterVirement(Transaction transaction);
    public String ajouterRetrait(Transaction transaction);
    public String ajouterVersement(Transaction transaction);
    public List<Transaction> getAllTransactionByBankId(long idBank);

    public List<Transaction> getAllTransactionByTypeAndCompte(TypeTransaction type, long idCompte);
}
