package gr.pfizer.team5.sacchonapp.repository;

import gr.pfizer.team5.sacchonapp.model.Consultation;
import gr.pfizer.team5.sacchonapp.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

    @Query(value = "SELECT * FROM doctor WHERE first_name LIKE CONCAT('%', ?1, '%')", nativeQuery = true) //SQL Query
    List<Doctor> findByNameLike(String match);
    @Query(value = "Select d.id from Doctor d")
    List<Integer> getAllDoctorIds();

}
