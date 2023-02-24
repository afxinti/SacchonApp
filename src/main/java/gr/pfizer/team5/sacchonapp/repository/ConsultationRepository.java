package gr.pfizer.team5.sacchonapp.repository;

import gr.pfizer.team5.sacchonapp.model.Consultation;
import gr.pfizer.team5.sacchonapp.model.Patient;
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

    @Query(value = "select c from Consultation c where c.patient = ?1 and c.date between ?2 and ?3")
    List<Consultation> getConsultationsByPatientAndDateIsBetween(int id, LocalDate date1, LocalDate date2);

}
