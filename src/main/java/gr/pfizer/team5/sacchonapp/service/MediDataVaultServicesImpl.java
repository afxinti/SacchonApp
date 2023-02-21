package gr.pfizer.team5.sacchonapp.service;

import gr.pfizer.team5.sacchonapp.repository.BGLRepository;
import gr.pfizer.team5.sacchonapp.repository.DCIRepository;
import gr.pfizer.team5.sacchonapp.dto.BGL_Dto;
import gr.pfizer.team5.sacchonapp.dto.DCI_Dto;
import gr.pfizer.team5.sacchonapp.exception.RecordNotFoundException;
import gr.pfizer.team5.sacchonapp.model.BloodGlucoseLevel;
import gr.pfizer.team5.sacchonapp.model.DailyCarbonatesIntake;
import gr.pfizer.team5.sacchonapp.dto.PatientDto;
import gr.pfizer.team5.sacchonapp.exception.PatientException;
import gr.pfizer.team5.sacchonapp.model.Patient;
import gr.pfizer.team5.sacchonapp.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MediDataVaultServicesImpl implements MediDataVaultServices{
    private final BGLRepository BGLRepository;
    private final DCIRepository DCIRepository;

    @Override
    public BGL_Dto createBGL(BGL_Dto bgl_dto) {
        BloodGlucoseLevel bloodGlucoseLevel = bgl_dto.asBGL();
        return new BGL_Dto(BGLRepository.save(bloodGlucoseLevel)) ;
    }
    @Override

    public List<BGL_Dto> readBGL() {
        return BGLRepository
                .findAll()
                .stream()
                .map(BGL_Dto::new)
                .collect(Collectors.toList());
    }
    @Override

    public BGL_Dto readBGL(int id) throws RecordNotFoundException {
        return new BGL_Dto( readBGL_DB(id));
    }

    private BloodGlucoseLevel readBGL_DB(int id) throws RecordNotFoundException {
        Optional<BloodGlucoseLevel> bglOptional = BGLRepository.findById(id);
        if (bglOptional.isPresent())
            return bglOptional.get();
        throw new RecordNotFoundException("Record not found");
    }
    @Override

    public boolean updateBGL(BGL_Dto bgl_dto, int id) {
        boolean action;
        try {
            BloodGlucoseLevel dbBGL = readBGL_DB(id);
            dbBGL.setDate(bgl_dto.getDate());
            dbBGL.setTime(bgl_dto.getTime());
            dbBGL.setMeasurement(bgl_dto.getMeasurement());
            dbBGL.setPatient(bgl_dto.getPatient());
            BGLRepository.save(dbBGL);
            action = true;
        } catch (RecordNotFoundException e) {
            action = false;
        }
        return action;

    }
    @Override

    public DCI_Dto createDCI(DCI_Dto dci_dto) {
        DailyCarbonatesIntake dailyCarbonatesIntake = dci_dto.asDCI();
        return new DCI_Dto(DCIRepository.save(dailyCarbonatesIntake)) ;
    }
    @Override

    public List<DCI_Dto> readDCI() {

        return DCIRepository
                .findAll()
                .stream()
                .map(DCI_Dto::new)
                .collect(Collectors.toList());
    }
    @Override

    public DCI_Dto readDCI(int id) throws RecordNotFoundException {
        return new DCI_Dto( readDCI_DB(id));

    }
    private DailyCarbonatesIntake readDCI_DB(int id) throws RecordNotFoundException {
        Optional<DailyCarbonatesIntake> dciOptional = DCIRepository.findById(id);
        if (dciOptional.isPresent())
            return dciOptional.get();
        throw new RecordNotFoundException("Record not found");
    }
    @Override

    public boolean updateDCI(DCI_Dto dci_dto, int id) {
        boolean action;
        try {
            DailyCarbonatesIntake dbDCI = readDCI_DB(id);
            dbDCI.setDate(dci_dto.getDate());
            dbDCI.setTime(dci_dto.getTime());
            dbDCI.setMeasurement(dci_dto.getMeasurement());
            dbDCI.setPatient(dci_dto.getPatient());
            DCIRepository.save(dbDCI);
            action = true;
        } catch (RecordNotFoundException e) {
    private final PatientRepository patientRepository;


    @Override
    public PatientDto createPatient(PatientDto patientDto) {
        //check id-->username-->unique?
        Patient patient = patientDto.asPatient();
        return new PatientDto(patientRepository.save(patient));
    }

    @Override
    public List<PatientDto> readPatient() {

        return patientRepository
                .findAll()
                .stream()
                .map(PatientDto::new)
                .collect(Collectors.toList());
    }

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
