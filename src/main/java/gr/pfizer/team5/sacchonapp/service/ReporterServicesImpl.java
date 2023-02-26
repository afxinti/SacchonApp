package gr.pfizer.team5.sacchonapp.service;

import gr.pfizer.team5.sacchonapp.dto.DoctorDto;
import gr.pfizer.team5.sacchonapp.dto.PatientDto;
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
    private DoctorAdviceServices doctorAdviceServices;


    //3. The list of the patients who are waiting for a consultation
    @Override
    public List<PatientDto> getPatientsWaitingForConsultation() {
        List<PatientDto> PatientsWaitingForConsultation = new ArrayList<>();
        for (Integer id : docRepository.getAllDoctorIds()) {
            PatientsWaitingForConsultation.addAll(doctorAdviceServices.getPatientsWithNoConsultationInTheLastMonth(id));
        }
        return PatientsWaitingForConsultation;
    }

    public List<Integer> doctorsWithNoActivityService(LocalDate startDate, LocalDate endDate) {
        return docRepository
                .doctorsWithNoActivity(startDate, endDate)
                .stream()
                .collect(Collectors.toList());
    }
}
