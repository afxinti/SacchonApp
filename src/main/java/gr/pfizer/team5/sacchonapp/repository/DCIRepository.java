package gr.pfizer.team5.sacchonapp.repository;

import gr.pfizer.team5.sacchonapp.model.DailyCarbonatesIntake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface DCIRepository extends JpaRepository<DailyCarbonatesIntake,Integer> {
    @Query("SELECT d FROM DailyCarbonatesIntake d WHERE d.patient.id = :id AND (d.date BETWEEN :startDate AND :endDate)")
    List<DailyCarbonatesIntake> findBetweenDatesDCI(@Param("id") int id,@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query(value = "Select d from DailyCarbonatesIntake d where d.patient.id = :id")
    List<DailyCarbonatesIntake> getDCIRecordsOfPatient(@Param("id") int id);

    @Query("SELECT d FROM DailyCarbonatesIntake d WHERE d.patient.id = :patientId ORDER BY d.date ASC")
    List<DailyCarbonatesIntake> findAllByPatientIdOrderByDateAsc(int patientId);

    @Query("SELECT COUNT(d) = 1 FROM DailyCarbonatesIntake d WHERE d.patient.id = :patientId")
    boolean hasOnlyOneRecord(int patientId);

    }



