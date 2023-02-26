package gr.pfizer.team5.sacchonapp.repository;


import gr.pfizer.team5.sacchonapp.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    @Query("select (count(p) =1) from Patient p where p.username = ?1 and p.password = ?2")
    boolean existsExactlyOnePatient(String username, String password);
    Optional<Patient> findByUsername(String username);

    @Query(value = "Select p from Patient p where p.currentDoctor.id = :id")
    List<Patient> getPatientsOfDoctor(@Param("id") int id);


    @Query(value = "SELECT b.patient from BloodGlucoseLevel b where b.date not BETWEEN :startDate and :endDate")
    List<Patient> patientsWithNoActivityBgl(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query(value = "SELECT d.patient from DailyCarbonatesIntake d where d.date not BETWEEN :startDate and :endDate")
    List<Patient> patientsWithNoActivityDci(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);


}
