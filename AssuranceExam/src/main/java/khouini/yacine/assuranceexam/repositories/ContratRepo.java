package khouini.yacine.assuranceexam.repositories;

import khouini.yacine.assuranceexam.entities.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratRepo extends JpaRepository<Contrat, Integer> {
}
