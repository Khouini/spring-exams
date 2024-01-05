package khouini.yacine.examenspring.repositories;

import khouini.yacine.examenspring.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepo extends JpaRepository<Compte, Long> {
}
