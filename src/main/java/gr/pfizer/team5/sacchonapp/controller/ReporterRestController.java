package gr.pfizer.team5.sacchonapp.controller;

import gr.pfizer.team5.sacchonapp.dto.BGL_Dto;
import gr.pfizer.team5.sacchonapp.dto.ConsultationDto;
import gr.pfizer.team5.sacchonapp.dto.DCI_Dto;
import gr.pfizer.team5.sacchonapp.dto.DoctorDto;
import gr.pfizer.team5.sacchonapp.dto.PatientDto;
import gr.pfizer.team5.sacchonapp.exception.CustomException;
import gr.pfizer.team5.sacchonapp.service.DoctorAdviceServices;
import gr.pfizer.team5.sacchonapp.service.ReporterServices;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;


@RestController
@AllArgsConstructor
@Slf4j
public class ReporterRestController {
    private ReporterServices reporterServices ;
    private DoctorAdviceServices doctorAdviceServices;

    @GetMapping("/reporter/patientswaitingconsultation")
    public List<PatientDto> getPatientsWaitingForConsultation() {
        return reporterServices.getPatientsWaitingForConsultation();
    }
    @GetMapping("/dci/{id}/between-dates")
    public List<DCI_Dto> getDCIBetweenDates(@PathVariable(name="id") int id, @RequestParam("startDate") LocalDate startDate, @RequestParam("endDate") LocalDate endDate) {
        return reporterServices.getDCIBetweenDates(id,startDate,endDate);
    }
    @GetMapping("/bgl/{id}/between-dates")
    public List<BGL_Dto> getBGLBetweenDates(@PathVariable(name="id") int id, @RequestParam("startDate") LocalDate startDate, @RequestParam("endDate") LocalDate endDate) {
        return reporterServices.getBGLBetweenDates(id,startDate,endDate);
    }
    @GetMapping("/reporter/consultation-doctor/{id}/between-dates")
    public List<ConsultationDto> getConsultationsDoctorBetweenDates(@PathVariable(name="id") int id, @RequestParam("startDate") LocalDate startDate, @RequestParam("endDate") LocalDate endDate) {
        return reporterServices.getConsultationsDoctorBetweenDates(id,startDate,endDate);
    }
    @GetMapping("/reporter/consultation-patient/{id}/between-dates")
    public List<ConsultationDto> getConsultationsPatientBetweenDates(@PathVariable(name="id") int id, @RequestParam("startDate") LocalDate startDate, @RequestParam("endDate") LocalDate endDate) {
        return reporterServices.getConsultationsPatientBetweenDates(id,startDate,endDate);
    }


    @GetMapping("/patients_noactivity/{startDate}/{endDate}")
    public List<Map> getPatientNoActivity(@PathVariable("startDate") LocalDate startDate, @PathVariable("endDate") LocalDate endDate) {

        return reporterServices.patientsWithNoActivityService(startDate, endDate);
    }


    @GetMapping("/doctors_noactivity/{startDate}/{endDate}")
    public List<DoctorDto> getDoctorNoActivity(@PathVariable("startDate") LocalDate startDate, @PathVariable("endDate") LocalDate endDate) throws CustomException {
        List<Integer> docIds = reporterServices.doctorsWithNoActivityService(startDate, endDate);
        List<DoctorDto> listDoctors = new ArrayList<>();
        for (int i : docIds) {
            DoctorDto doc = doctorAdviceServices.readDoctor(i);
            listDoctors.add(doc);
        }
        return listDoctors;
    }
}
