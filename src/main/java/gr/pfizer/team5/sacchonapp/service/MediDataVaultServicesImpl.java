package gr.pfizer.team5.sacchonapp.service;

import gr.pfizer.team5.sacchonapp.dto.PatientDto;
import gr.pfizer.team5.sacchonapp.exception.PatientException;
import gr.pfizer.team5.sacchonapp.model.Patient;
import gr.pfizer.team5.sacchonapp.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class MediDataVaultServicesImpl implements MediDataVaultServices{
    private final PatientRepository patientRepository;


    @Override
    public PatientDto createPatient(PatientDto patientDto) {
        //check id-->username-->unique?
        Patient patient = patientDto.asPatient();
        return new PatientDto(patientRepository.save(patient));
    }
    @Override
    public List<PatientDto> readPatient() {
        return null;
    }

//    @Override
//    public List<PatientDto> readPatient() {
//
//        return patientRepository
//                .findAll()
//                .stream()
//                .map(PatientDto::new)
//                .collect(Collectors.toList());
//    }

    @Override
    public PatientDto readPatient(int id) throws PatientException {
        return new PatientDto(readPatientData(id));
    }
    private Patient readPatientData(int id) throws PatientException {
        Optional<Patient> patientOptional = patientRepository.findById(id);
        if (patientOptional.isPresent())
            return patientOptional.get();
        throw new PatientException("Patient: "+ id+ "not found");
    }
    @Override
    public boolean updatePatient(PatientDto patient, int id) {
        boolean action;
        try{
            Patient patientDb= readPatientData(id);
            patientDb.setUsername(patient.getUsername());
            patientDb.setPassword(patient.getPassword());
            patientDb.setFirstName(patient.getFirstName());
            patientDb.setLastName(patient.getLastName());
            patientDb.setAmkaCode(patient.getAmkaCode());
            patient.setDateOfBirth(patient.getDateOfBirth());
            patientRepository.save(patientDb);
            action = true;
        } catch (PatientException e){
            action = false;
        }
        return action;
    }

    @Override
    public boolean deletePatient(int id) {
        boolean action;
        try {
            Patient patientDb = readPatientData(id);
            patientRepository.delete(patientDb);
            action = true;
        }catch(PatientException e){
            action = false;
        }
        return action;
    }
}
