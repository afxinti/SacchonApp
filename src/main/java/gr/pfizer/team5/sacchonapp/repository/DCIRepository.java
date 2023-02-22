package gr.pfizer.team5.sacchonapp.repository;

import gr.pfizer.team5.sacchonapp.model.BloodGlucoseLevel;
import gr.pfizer.team5.sacchonapp.model.DailyCarbonatesIntake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DCIRepository extends JpaRepository<DailyCarbonatesIntake,Integer> {



    @Query(value = "Select d from DailyCarbonatesIntake d where d.patient.id = :id")
    List<DailyCarbonatesIntake> getDCIRecordsOfPatient(@Param("id") int id);

}

