package gr.pfizer.team5.sacchonapp.repository;

import gr.pfizer.team5.sacchonapp.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    @Query(value = "SELECT b.patient, d.patient from BloodGlucoseLevel b, DailyCarbonatesIntake d where " +
            "(b.date not BETWEEN :startDate and :endDate) or (d.date not BETWEEN :startDate and :endDate)")

    List<Patient> patientsWithNoActivity(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
