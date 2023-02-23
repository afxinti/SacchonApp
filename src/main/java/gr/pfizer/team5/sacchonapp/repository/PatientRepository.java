package gr.pfizer.team5.sacchonapp.repository;


import gr.pfizer.team5.sacchonapp.model.Consultation;
import gr.pfizer.team5.sacchonapp.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    @Query(value = "Select p from Patient p where p.currentDoctor.id = :id")
    List<Patient> getPatientsOfDoctor(@Param("id") int id);

}

