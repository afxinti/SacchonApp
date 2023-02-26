package gr.pfizer.team5.sacchonapp.service;

import gr.pfizer.team5.sacchonapp.repository.BGLRepository;
import gr.pfizer.team5.sacchonapp.repository.DCIRepository;
import gr.pfizer.team5.sacchonapp.dto.BGL_Dto;
import gr.pfizer.team5.sacchonapp.dto.DCI_Dto;
import gr.pfizer.team5.sacchonapp.exception.RecordNotFoundException;
import gr.pfizer.team5.sacchonapp.model.BloodGlucoseLevel;
import gr.pfizer.team5.sacchonapp.model.DailyCarbonatesIntake;
import gr.pfizer.team5.sacchonapp.dto.PatientDto;
import gr.pfizer.team5.sacchonapp.model.Patient;
import gr.pfizer.team5.sacchonapp.repository.PatientRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MediDataVaultServicesImpl implements MediDataVaultServices{
    private final BGLRepository BGLRepository;
    private final DCIRepository DCIRepository;
    private final PatientRepository patientRepository;


    //------------------------------------------------------start of BGL and DCI methods -------------------------------------------------//

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
//            Patient patient = patientRepository.findById(bgl_dto.getPatientId())
//                    .orElseThrow(() -> new RecordNotFoundException("Patient not found"));
//            dbBGL.setPatient(patient);
            BGLRepository.save(dbBGL);
            action = true;
        } catch (RecordNotFoundException e) {
            action = false;
        }
        return action;

    }
    @Override
    public boolean deleteBGL(int id) {
        boolean action;
        try {
            BloodGlucoseLevel dbBGL = readBGL_DB(id);
            BGLRepository.delete(dbBGL);
            action = true;
        }catch(RecordNotFoundException e){
            action = false;
        }
        return action;
    }


    //DCI CRU Services
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
//            Patient patient = patientRepository.findById(dci_dto.getPatientId())
//                    .orElseThrow(() -> new RecordNotFoundException("Patient not found"));
//            dbDCI.setPatient(patient);
            DCIRepository.save(dbDCI);
            action = true;
        } catch (RecordNotFoundException e) {
            action = false;
        }
        return action;
    }

    @Override
    public boolean deleteDCI(int id) {
        boolean action;
        try {
            DailyCarbonatesIntake dbDCI = readDCI_DB(id);
            DCIRepository.delete(dbDCI);
            action = true;
        }catch(RecordNotFoundException e){
            action = false;
        }
        return action;
    }

    public Double getAverageDCIBetweenDates(int id,LocalDate startDate, LocalDate endDate) {
        List<DailyCarbonatesIntake> dciList = DCIRepository.findBetweenDatesDCI(id,startDate, endDate);
        if (dciList == null || dciList.isEmpty()) {
            return null;
        }
        Double sum = 0.0;
        for (DailyCarbonatesIntake dci : dciList) {
            sum += dci.getMeasurement();
        }
        return sum / dciList.size();
    }


    @Override
    public Double getAverageBGLBetweenDates(int id,LocalDate startDate, LocalDate endDate) {
        List<BloodGlucoseLevel> bglList = BGLRepository.findBetweenDatesBGL(id,startDate, endDate);
        if (bglList == null || bglList.isEmpty()) {
            return null;
        }
        Double sum = 0.0;
        for (BloodGlucoseLevel bgl : bglList) {
            sum += bgl.getMeasurement();
        }
        return sum / bglList.size();
    }
//------------------------------------------------------end of BGL and DCI methods -------------------------------------------------//

    @Override
    public boolean loginPatient(PatientDto patientDto) {
           return  patientRepository.existsExactlyOnePatient(patientDto.getUsername(), patientDto.getPassword());
    }

    @Override
    public PatientDto createPatient(PatientDto patientDto) throws RecordNotFoundException {
            Patient patient = patientDto.asPatient();
            if(!usernameNotAvailable(patient))
                return new PatientDto(patientRepository.save(patient));
            throw new RecordNotFoundException("Username already exists");
    }
      private boolean usernameNotAvailable(Patient patient) throws RecordNotFoundException {
        Optional<Patient> patientOptional = patientRepository.findByUsername(patient.getUsername());
        return patientOptional.isPresent();
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
    public PatientDto readPatient(int id) throws RecordNotFoundException {
        return new PatientDto(readPatientData(id));
    }
    private Patient readPatientData(int id) throws RecordNotFoundException {
        Optional<Patient> patientOptional = patientRepository.findById(id);
        if (patientOptional.isPresent())
            return patientOptional.get();
        throw new RecordNotFoundException("Patient: "+ id+ "not found");
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
        } catch (RecordNotFoundException e){
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
        }catch(RecordNotFoundException e){
            action = false;
        }
        return action;
    }

    public void updateWarning(int id) {
        try {
            Patient p = readPatientData(id);
            p.setWarning_modifiedconsultation(true);
            patientRepository.save(p);
        }catch(RecordNotFoundException e){
        }
    }

    @Override
    public String warnPatientAboutModifiedConsultation(int id) {
        String warning = null;
        try {
            Patient p = readPatientData(id);
            if (p.isWarning_modifiedconsultation())
                warning = "Warning: Your Doctor modified a consultation. Important information must be reviewed";
        }catch(RecordNotFoundException e){
        }
        return warning;
    }



}
