package gr.pfizer.team5.sacchonapp.repository;

import gr.pfizer.team5.sacchonapp.model.BloodGlucoseLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BGLRepository extends JpaRepository<BloodGlucoseLevel,Integer> {
//    List<BloodGlucoseLevel> findByDateBetween (LocalDate start, LocalDate end);


}