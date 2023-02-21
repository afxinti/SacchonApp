package gr.pfizer.team5.sacchonapp.service;

import gr.pfizer.team5.sacchonapp.dto.PatientDto;
import gr.pfizer.team5.sacchonapp.exception.PatientException;

import java.util.List;

public interface MediDataVaultServices {
    PatientDto createPatient(PatientDto patient);
    PatientDto readPatient(int id) throws PatientException;
    List<PatientDto> readPatient();
    boolean updatePatient(PatientDto patient,int id);
    boolean deletePatient(int id);
}
