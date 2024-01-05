package khouini.yacine.examenspring.repositories;

import khouini.yacine.examenspring.entities.Pathologie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PathologieRepo extends JpaRepository<Pathologie, Long> {
    Pathologie findPathologieByCodePath(String codePath);
}
