package gr.pfizer.team5.sacchonapp.repository;

import gr.pfizer.team5.sacchonapp.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    @Query("select (count(p) =1) from Patient p where p.username = ?1 and p.password = ?2")
    boolean existsExactlyOnePatient(String username, String password);
    Optional<Patient> findByUsername(String username);
}
