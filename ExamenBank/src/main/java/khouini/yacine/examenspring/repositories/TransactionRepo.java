package khouini.yacine.examenspring.repositories;

import khouini.yacine.examenspring.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepo extends JpaRepository<Transaction, Long> {
    //    @Query("SELECT r FROM Reservation r JOIN r.etudiants e WHERE e.id = ?1")
    //@Query("select t FROM Bank b JOIN b.comptes c JOIN c.")
   // public List<Transaction> getAllTransactionByBankId(long idBank);
}
