package gr.pfizer.team5.sacchonapp.controller;

import gr.pfizer.team5.sacchonapp.dto.DoctorDto;
import gr.pfizer.team5.sacchonapp.dto.PatientDto;
import gr.pfizer.team5.sacchonapp.exception.RecordNotFoundException;
import gr.pfizer.team5.sacchonapp.service.DoctorAdviceServices;
import gr.pfizer.team5.sacchonapp.service.ReporterServices;
import jdk.javadoc.doclet.Reporter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@RestController
@AllArgsConstructor
@Slf4j
public class ReporterController {

    private DoctorAdviceServices doctorAdviceServices;
    private ReporterServices reporterServices;

    @GetMapping("/doctor/firstname/{match}")
    public List<DoctorDto> getDoctorDto(@PathVariable("match") String match) {
        return doctorAdviceServices.findByNameLikeService(match);
    }

    @GetMapping("/patient_list_noactivity_bgl/{startDate}/{endDate}")
    public List<PatientDto> getPatientDto(@PathVariable("startDate") LocalDate startDate, @PathVariable("endDate") LocalDate endDate) {

        return doctorAdviceServices.patientsWithNoActivityBglService(startDate, endDate);
    }

    @GetMapping("/patients_noactivity_dci/{startDate}/{endDate}")
    public List<PatientDto> getPatientsDto(@PathVariable("startDate") LocalDate startDate, @PathVariable("endDate") LocalDate endDate) {

        return doctorAdviceServices.patientsWithNoActivityDciService(startDate, endDate);
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
