package gr.pfizer.team5.sacchonapp.service;

import gr.pfizer.team5.sacchonapp.dto.*;
import gr.pfizer.team5.sacchonapp.exception.RecordNotFoundException;
import gr.pfizer.team5.sacchonapp.model.ChiefDoctor;
import gr.pfizer.team5.sacchonapp.model.Consultation;
import gr.pfizer.team5.sacchonapp.model.Doctor;
import gr.pfizer.team5.sacchonapp.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
@AllArgsConstructor
public class DoctorAdviceServicesImpl implements DoctorAdviceServices{

    private final ConsultationRepository consultationRepository;
    private final DoctorRepository docRepository;
    private final ChiefDoctorRepository chiefDocRepository;
    private final PatientRepository patientRepository;
    private final BGLRepository BGLRepository;
    private final DCIRepository DCIRepository;

    @Override
    public String ping() {
        return "hello Sacchon Doctor";
    }



    // Consultation CRU Services
    @Override
    public ConsultationDto createConsultation(ConsultationDto consultationDto) {
        //validation
        Consultation consultation = consultationDto.asConsultation();
        return new ConsultationDto(consultationRepository.save(consultation)) ;

    }

    @Override
    public List<ConsultationDto> readConsultation() {
        return consultationRepository
                .findAll()
                .stream()
                .map(ConsultationDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public ConsultationDto readConsultation(int id) throws RecordNotFoundException {
        return new ConsultationDto( readConsultationDb(id));
    }

    private Consultation readConsultationDb(int id) throws RecordNotFoundException {
        Optional<Consultation> consultationOptional = consultationRepository.findById(id);
        if (consultationOptional.isPresent())
            return consultationOptional.get() ;
        throw new RecordNotFoundException("Consultation not found id= " + id);
    }

    @Override
    public boolean updateConsultation(ConsultationDto consultation, int id) {

        boolean action;
        try {
            Consultation dbConsultation = readConsultationDb(id);
            dbConsultation.setDate(consultation.getDate());
            dbConsultation.setNameOfMedication(consultation.getNameOfMedication());
            dbConsultation.setDosage(consultation.getDosage());
            dbConsultation.setNotes(consultation.getNotes());
            dbConsultation.setDoctor_id(consultation.getDoctor_id());
            consultationRepository.save(dbConsultation);
            action = true;
        } catch (RecordNotFoundException e) {
            action = false;
        }
        return action;
    }



    //Doctor CRUD Services
    @Override
    public DoctorDto createDoctor(DoctorDto doctorDto) {
        //validation
        Doctor doctor = doctorDto.asDoctor();
        return new DoctorDto(docRepository.save(doctor));
    }

    @Override
    public List<DoctorDto> readDoctor() {
        return docRepository
                .findAll()
                .stream()
                .map(DoctorDto::new)
                .collect(Collectors.toList());
    }

        public DoctorDto readDoctor(int id) throws RecordNotFoundException {
            return new DoctorDto( readDoctorDb(id));
        }

        private Doctor readDoctorDb(int id) throws RecordNotFoundException {
            Optional<Doctor> doctorOptional = docRepository.findById(id);
            if (doctorOptional.isPresent())
                return doctorOptional.get();
            throw new RecordNotFoundException("Doctor not found id= " + id);
        }

    @Override
    public boolean updateDoctor(DoctorDto doctor, int id) {
        boolean action;
        try {
            Doctor dbDoctor = readDoctorDb(id);
            dbDoctor.setFirstName(doctor.getFirstName());
            dbDoctor.setLastName(doctor.getLastName());
            dbDoctor.setEmail(doctor.getEmail());
            dbDoctor.setPassword(doctor.getPassword());
            docRepository.save(dbDoctor);
            action = true;
        } catch (RecordNotFoundException e) {
            action = false;
        }
        return action;
    }

    @Override
    public boolean deleteDoctor(int id) {
        boolean action;
        try {
            Doctor doctorDb = readDoctorDb(id);
            docRepository.delete(doctorDb);
            action = true;
        } catch (RecordNotFoundException e) {
            action = false;
        }
        return action;
    }



    //Chief Doctor CRUD Services
    @Override
    public ChiefDoctorDto createChiefDoctor(ChiefDoctorDto chiefDoctorDto) {
        //validation
        ChiefDoctor doctor = chiefDoctorDto.asChiefDoctor();
        return new ChiefDoctorDto(chiefDocRepository.save(doctor));
    }

    @Override
    public List<ChiefDoctorDto> readChiefDoctor() {
        return chiefDocRepository
                .findAll()
                .stream()
                .map(ChiefDoctorDto::new)
                .collect(Collectors.toList());
    }

    public ChiefDoctorDto readChiefDoctor(int id) throws RecordNotFoundException {
        return new ChiefDoctorDto( readChiefDoctorDb(id));
    }

    private ChiefDoctor readChiefDoctorDb(int id) throws RecordNotFoundException {
        Optional<ChiefDoctor> chiefdoctorOptional = chiefDocRepository.findById(id);
        if (chiefdoctorOptional.isPresent())
            return chiefdoctorOptional.get();
        throw new RecordNotFoundException("Chief Doctor not found id= " + id);
    }

    @Override
    public boolean updateChiefDoctor(ChiefDoctorDto chiefdoctor, int id) {
        boolean action;
        try {
            ChiefDoctor dbChiefDoctor = readChiefDoctorDb(id);
            dbChiefDoctor.setFirstName(chiefdoctor.getFirstName());
            dbChiefDoctor.setLastName(chiefdoctor.getLastName());
            dbChiefDoctor.setEmail(chiefdoctor.getEmail());
            dbChiefDoctor.setPassword(chiefdoctor.getPassword());
            chiefDocRepository.save(dbChiefDoctor);
            action = true;
        } catch (RecordNotFoundException e) {
            action = false;
        }
        return action;
    }

    @Override
    public boolean deleteChiefDoctor(int id) {
        boolean action;
        try {
            ChiefDoctor chiefdoctorDb = readChiefDoctorDb(id);
            chiefDocRepository.delete(chiefdoctorDb);
            action = true;
        } catch (RecordNotFoundException e) {
            action = false;
        }
        return action;
    }



    //Other Services

    //view patient record
    public List<PatientDto> getPatientsOfDoctor(int id){
        return patientRepository.getPatientsOfDoctor(id)
                .stream()
                .map(PatientDto::new)
                .collect(Collectors.toList());
    }


    //browse the data of a single patient(Consultations)
    public List<ConsultationDto> getConsultationsOfPatient(int id) {
        return consultationRepository.getConsultationsOfPatient(id)
                .stream()
                .map(ConsultationDto::new)
                .collect(Collectors.toList());
    }

    //browse the data of a single patient(BGL)
    public List<BGL_Dto> getBGLRecordsOfPatient(int id) {
        return BGLRepository.getBGLRecordsOfPatient(id)
                .stream()
                .map(BGL_Dto::new)
                .collect(Collectors.toList());
    }

    //browse the data of a single patient(DCI)
    public List<DCI_Dto> getDCIRecordsOfPatient(int id) {
        return DCIRepository.getDCIRecordsOfPatient(id)
                .stream()
                .map(DCI_Dto::new)
                .collect(Collectors.toList());
    }


    public List<PatientDto> getPatientsWithNoConsultationInTheLastMonth(int id){
        List<PatientDto> PatientsWithNoConsultationInTheLastMonth = new ArrayList<>();
        for(PatientDto p : getPatientsOfDoctor(id)) {
            Consultation c = consultationRepository.getLastConsultationOfPatient(p.getId());
            if (DAYS.between(c.getDate(), LocalDate.now())>30)
                PatientsWithNoConsultationInTheLastMonth.add(p);
        }
        return PatientsWithNoConsultationInTheLastMonth;
    }

    public ConsultationDto getLastConsultationOfPatient(int id) {
        return new ConsultationDto(consultationRepository.getLastConsultationOfPatient(id));
    }


}
