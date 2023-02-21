package gr.pfizer.team5.sacchonapp.repository;

import gr.pfizer.team5.sacchonapp.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
}
