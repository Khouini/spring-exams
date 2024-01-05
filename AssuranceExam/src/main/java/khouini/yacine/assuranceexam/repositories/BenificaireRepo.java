package khouini.yacine.assuranceexam.repositories;

import khouini.yacine.assuranceexam.entities.Benificaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BenificaireRepo extends JpaRepository<Benificaire, Integer> {
    Benificaire findBenificaireByCin(int cin);
}
