package gr.pfizer.team5.sacchonapp.controller;

import gr.pfizer.team5.sacchonapp.dto.PatientDto;
import gr.pfizer.team5.sacchonapp.exception.PatientException;
import gr.pfizer.team5.sacchonapp.service.MediDataVaultServices;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
public class MediDataVaultController {
    private MediDataVaultServices patientServices;


    @GetMapping("/patient")
    public List<PatientDto> readPatient(){
        return patientServices.readPatient();
    }
    @PostMapping("/patient")
    public PatientDto createPatient(@RequestBody PatientDto patientDto){
        log.info("The patient was created");
        return patientServices.createPatient(patientDto);
    }
    @GetMapping("/patient/{id}")
    public PatientDto readPatientDto(@PathVariable(name = "id") int id) throws PatientException {
        log.info("Request a patient/endpoint");
        return patientServices.readPatient(id);
    }
    @PutMapping("/patient/{id}")
    public boolean updatePatientDto(@RequestBody PatientDto patientDto,@PathVariable(name ="id") int id){
        return patientServices.updatePatient(patientDto,id);
    }
    @DeleteMapping("/patient/{id}")
    public boolean deletePatientDto(@PathVariable(name="id")int id){
        return patientServices.deletePatient(id);
    }
}

