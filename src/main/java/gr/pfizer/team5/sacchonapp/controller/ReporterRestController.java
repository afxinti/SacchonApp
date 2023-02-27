package gr.pfizer.team5.sacchonapp.controller;

import gr.pfizer.team5.sacchonapp.dto.DoctorDto;
import gr.pfizer.team5.sacchonapp.dto.PatientDto;
import gr.pfizer.team5.sacchonapp.exception.RecordNotFoundException;
import gr.pfizer.team5.sacchonapp.service.DoctorAdviceServices;
import gr.pfizer.team5.sacchonapp.service.MediDataVaultServices;
import gr.pfizer.team5.sacchonapp.service.ReporterServices;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@Slf4j
public class ReporterRestController {

    private final ReporterServices reporterServices;
    private DoctorAdviceServices doctorAdviceServices;

    @GetMapping("/reporter/patientswaitingconsultation")
    public List<PatientDto> getPatientsWaitingForConsultation() {
        return reporterServices.getPatientsWaitingForConsultation();
    }

    @GetMapping("/patients_noactivity/{startDate}/{endDate}")
    public List<Map> getPatientDto(@PathVariable("startDate") LocalDate startDate, @PathVariable("endDate") LocalDate endDate) {

        return reporterServices.patientsWithNoActivityService(startDate, endDate);
    }


    @GetMapping("/doctors_noactivity/{startDate}/{endDate}")
    public List<DoctorDto> getDoctorsDto(@PathVariable("startDate") LocalDate startDate, @PathVariable("endDate") LocalDate endDate) throws RecordNotFoundException {
        List<Integer> docIds = reporterServices.doctorsWithNoActivityService(startDate, endDate);
        List<DoctorDto> listDoctors = new ArrayList<>();
        for (int i : docIds) {
            DoctorDto doc = doctorAdviceServices.readDoctor(i);
            listDoctors.add(doc);
        }
        return listDoctors;
    }
}
