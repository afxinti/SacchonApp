package gr.pfizer.team5.sacchonapp.repository;

import gr.pfizer.team5.sacchonapp.model.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Integer> {
    @Query(value = "Select c from Consultation c where c.patient.id = :id")
    List<Consultation> getConsultationsOfPatient(@Param("id") int id);

    @Query(value = "Select c from Consultation c where c.patient.id = :id order by c.date desc limit 1")
    Consultation getPatientsLastConsultation(@Param("id") int id);

    @Query("SELECT c FROM Consultation c WHERE c.doctor_id = :id AND (c.date BETWEEN :startDate AND :endDate)")
    List<Consultation> findBetweenDatesConsultationDoctor(@Param("id") int id, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
    @Query("SELECT c FROM Consultation c WHERE c.patient.id = :id AND (c.date BETWEEN :startDate AND :endDate)")
    List<Consultation> findBetweenDatesConsultationPatient(@Param("id") int id, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);


}
