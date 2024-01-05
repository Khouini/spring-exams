package khouini.yacine.examenspring.repositories;

import khouini.yacine.examenspring.entities.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepo extends JpaRepository<Bank, Long> {
    public Bank findBankByAgence(String agence);
}
