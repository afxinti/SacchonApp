package gr.pfizer.team5.sacchonapp.service;

import gr.pfizer.team5.sacchonapp.dto.*;
import gr.pfizer.team5.sacchonapp.model.BloodGlucoseLevel;
import gr.pfizer.team5.sacchonapp.model.Consultation;
import gr.pfizer.team5.sacchonapp.model.DailyCarbonatesIntake;
import gr.pfizer.team5.sacchonapp.repository.BGLRepository;
import gr.pfizer.team5.sacchonapp.repository.ConsultationRepository;
import gr.pfizer.team5.sacchonapp.repository.DCIRepository;
import gr.pfizer.team5.sacchonapp.repository.DoctorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReporterServicesImpl implements ReporterServices {

    private final DoctorRepository docRepository;
    private DoctorAdviceServices doctorAdviceServices ;
    private final DCIRepository DCIRepository;
    private final BGLRepository BGLRepository;
    private final ConsultationRepository consultationRepository;




    //3. The list of the patients who are waiting for a consultation
    @Override
    public List<PatientDto> getPatientsWaitingForConsultation() {
        List<PatientDto> PatientsWaitingForConsultation= new ArrayList<>();
        for(Integer id : docRepository.getAllDoctorIds()) {
            PatientsWaitingForConsultation.addAll(doctorAdviceServices.getPatientsWithNoConsultationInTheLastMonth(id));
        }
        return PatientsWaitingForConsultation;
    }
    @Override
    public List<DCI_Dto> getDCIBetweenDates(int id, LocalDate startDate, LocalDate endDate) {
        List<DailyCarbonatesIntake> dciList = DCIRepository.findBetweenDatesDCI(id,startDate, endDate);
        return dciList.stream().map(DCI_Dto::new).collect(Collectors.toList());
    }
    @Override
    public List<BGL_Dto> getBGLBetweenDates(int id, LocalDate startDate, LocalDate endDate) {
        List<BloodGlucoseLevel> bglList = BGLRepository.findBetweenDatesBGL(id,startDate, endDate);
        return bglList.stream().map(BGL_Dto::new).collect(Collectors.toList());
    }
    @Override
    public List<ConsultationDto> getConsultationsDoctorBetweenDates(int id, LocalDate startDate, LocalDate endDate) {
        List<Consultation> consultationlList = consultationRepository.findBetweenDatesConsultationDoctor(id,startDate, endDate);
        return consultationlList.stream().map(ConsultationDto::new).collect(Collectors.toList());
    }
    @Override
    public List<ConsultationDto> getConsultationsPatientBetweenDates(int id, LocalDate startDate, LocalDate endDate) {
        List<Consultation> consultationlList = consultationRepository.findBetweenDatesConsultationPatient(id,startDate, endDate);
        return consultationlList.stream().map(ConsultationDto::new).collect(Collectors.toList());
    }
}
