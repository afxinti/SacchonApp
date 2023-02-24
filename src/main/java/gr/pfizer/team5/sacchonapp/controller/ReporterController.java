package gr.pfizer.team5.sacchonapp.controller;

import gr.pfizer.team5.sacchonapp.dto.DoctorDto;
import gr.pfizer.team5.sacchonapp.dto.PatientDto;
import gr.pfizer.team5.sacchonapp.service.DoctorAdviceServices;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class ReporterController {

    private DoctorAdviceServices doctorAdviceServices;

    @GetMapping("/doctor/firstname/{match}")
    public List<DoctorDto> getDoctorDto(@PathVariable("match") String match){
        return doctorAdviceServices.findByNameLikeService(match);
    }

    @GetMapping("/patient_list_noactivity/{startDate}/{endDate}")
    public List<PatientDto> getPatientDto(@PathVariable("startDate") LocalDate startDate , @PathVariable("endDate")LocalDate endDate){
        log.info("dddd");
        return doctorAdviceServices.patientsWithNoActivityService(startDate, endDate);
    }

}
