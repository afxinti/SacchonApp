package gr.pfizer.team5.sacchonapp.repository;

import gr.pfizer.team5.sacchonapp.model.ChiefDoctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiefDoctorRepository extends JpaRepository<ChiefDoctor, Integer> {
}
