package khouini.yacine.examenspring.repositories;

import khouini.yacine.examenspring.entities.Acte;
import khouini.yacine.examenspring.entities.Pathologie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActeRepo extends JpaRepository<Acte, Long> {
    Acte findActeByCodeActe(String codeActe);
}
