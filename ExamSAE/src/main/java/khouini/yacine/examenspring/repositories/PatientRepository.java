package khouini.yacine.examenspring.repositories;

import khouini.yacine.examenspring.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
