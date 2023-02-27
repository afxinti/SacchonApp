package gr.pfizer.team5.sacchonapp.repository;

import gr.pfizer.team5.sacchonapp.dto.DoctorDto;
import gr.pfizer.team5.sacchonapp.model.Consultation;
import gr.pfizer.team5.sacchonapp.model.Doctor;
import gr.pfizer.team5.sacchonapp.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

    @Query(value = "SELECT * FROM doctor WHERE first_name LIKE CONCAT('%', ?1, '%')", nativeQuery = true) //SQL Query
    List<Doctor> findByNameLike(String match);
    @Query(value = "Select d.id from Doctor d")
    List<Integer> getAllDoctorIds();

    @Query(value = "SELECT c.doctor_id from Consultation c where c.date not BETWEEN :startDate and :endDate")
    List<Integer> doctorsWithNoActivity(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

}
