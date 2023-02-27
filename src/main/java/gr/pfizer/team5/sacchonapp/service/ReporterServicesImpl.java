package gr.pfizer.team5.sacchonapp.service;

import gr.pfizer.team5.sacchonapp.dto.*;
import gr.pfizer.team5.sacchonapp.model.BloodGlucoseLevel;
import gr.pfizer.team5.sacchonapp.model.Consultation;
import gr.pfizer.team5.sacchonapp.model.DailyCarbonatesIntake;
import gr.pfizer.team5.sacchonapp.repository.BGLRepository;
import gr.pfizer.team5.sacchonapp.repository.ConsultationRepository;
import gr.pfizer.team5.sacchonapp.repository.DCIRepository;
import gr.pfizer.team5.sacchonapp.repository.DoctorRepository;
import gr.pfizer.team5.sacchonapp.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReporterServicesImpl implements ReporterServices {

    private final DoctorRepository docRepository;
    private final DoctorAdviceServices doctorAdviceServices;
    private final PatientRepository patientRepository;
    private final DCIRepository DCIRepository;
    private final BGLRepository BGLRepository;
    private final ConsultationRepository consultationRepository;




    //3. The list of the patients who are waiting for a consultation
    @Override
    public List<PatientDto> getPatientsWaitingForConsultation() {
        List<PatientDto> PatientsWaitingForConsultation = new ArrayList<>();
        for (Integer id : docRepository.getAllDoctorIds()) {
            PatientsWaitingForConsultation.addAll(doctorAdviceServices.getPatientsWithNoConsultationInTheLastMonth(id));
        }
        return PatientsWaitingForConsultation;
    }

    //5. The list of patients with no activity over a time range
    public List<Map> patientsWithNoActivityService(LocalDate startDate, LocalDate endDate) {
        Map<String, List<PatientDto>> maplistBGL = new HashMap<String, List<PatientDto>>();
        String s1 = "BGL";
        List<PatientDto> listPatients1 = patientRepository
                .patientsWithNoActivityBgl(startDate, endDate)
                .stream()
                .map(PatientDto::new)
                .collect(Collectors.toList());

        Map<String, List<PatientDto>> maplistDCI = new HashMap<String, List<PatientDto>>();
        String s2 = "DCI";
        List<PatientDto> listPatients2 = patientRepository
                .patientsWithNoActivityDci(startDate, endDate)
                .stream()
                .map(PatientDto::new)
                .collect(Collectors.toList());

        maplistBGL.put(s1, listPatients1);
        maplistDCI.put(s2, listPatients2);

        List<Map> mapPatientList = new ArrayList<>();
        mapPatientList.add(maplistBGL);
        mapPatientList.add(maplistDCI);

        return mapPatientList;
    }

    //6. The list of the doctors with no activity over a time range
    public List<Integer> doctorsWithNoActivityService(LocalDate startDate, LocalDate endDate) {
        return docRepository
                .doctorsWithNoActivity(startDate, endDate)
                .stream()
                .collect(Collectors.toList());
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
