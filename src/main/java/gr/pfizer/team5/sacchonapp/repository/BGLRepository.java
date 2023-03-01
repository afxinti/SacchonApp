package gr.pfizer.team5.sacchonapp.repository;

import gr.pfizer.team5.sacchonapp.model.BloodGlucoseLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BGLRepository extends JpaRepository<BloodGlucoseLevel,Integer> {
    @Query("SELECT d FROM BloodGlucoseLevel d WHERE d.patient.id = :id AND (d.date BETWEEN :startDate AND :endDate)")
    List<BloodGlucoseLevel> findBetweenDatesBGL(@Param("id") int id,@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query(value = "Select b from BloodGlucoseLevel b where b.patient.id = :id")
    List<BloodGlucoseLevel> getBGLRecordsOfPatient(@Param("id") int id);

    @Query("SELECT b FROM BloodGlucoseLevel b WHERE b.patient.id = :patientId ORDER BY b.date ASC")
    List<BloodGlucoseLevel> findAllByPatientIdOrderByDateAsc(int patientId);

    @Query("SELECT COUNT(b) = 1 FROM BloodGlucoseLevel b WHERE b.patient.id = :patientId")
    boolean hasOnlyOneRecord(int patientId);

    @Query(value = "SELECT COUNT(b) FROM BloodGlucoseLevel b where b.id = :patientId AND b.measurement < 70")
    long checkLowRecordsExist(@Param("patientId") int id);



}