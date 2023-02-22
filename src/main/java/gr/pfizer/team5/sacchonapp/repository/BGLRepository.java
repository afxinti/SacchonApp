package gr.pfizer.team5.sacchonapp.repository;

import gr.pfizer.team5.sacchonapp.model.BloodGlucoseLevel;
import gr.pfizer.team5.sacchonapp.model.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BGLRepository extends JpaRepository<BloodGlucoseLevel,Integer> {
//    List<BloodGlucoseLevel> findByDateBetween (LocalDate start, LocalDate end);

    @Query(value = "Select b from BloodGlucoseLevel b where b.patient.id = :id")
    List<BloodGlucoseLevel> getBGLRecordsOfPatient(@Param("id") int id);

}