package gr.pfizer.team5.sacchonapp.controller;

import gr.pfizer.team5.sacchonapp.dto.PatientDto;
import gr.pfizer.team5.sacchonapp.service.MediDataVaultServices;
import gr.pfizer.team5.sacchonapp.service.ReporterServices;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class ReporterRestController {
    private ReporterServices reporterServices ;


    @GetMapping("/reporter/patientswaitingconsultation")
    public List<PatientDto> getPatientsWaitingForConsultation() {
        return reporterServices.getPatientsWaitingForConsultation();
    }
}
