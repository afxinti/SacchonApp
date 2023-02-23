package gr.pfizer.team5.sacchonapp.controller;

import gr.pfizer.team5.sacchonapp.dto.BGL_Dto;
import gr.pfizer.team5.sacchonapp.dto.ConsultationDto;
import gr.pfizer.team5.sacchonapp.dto.DCI_Dto;
import gr.pfizer.team5.sacchonapp.dto.PatientDto;
import gr.pfizer.team5.sacchonapp.exception.RecordNotFoundException;
import gr.pfizer.team5.sacchonapp.service.DoctorAdviceServices;
import gr.pfizer.team5.sacchonapp.service.MediDataVaultServices;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class DoctorAdviceRestController {
    private DoctorAdviceServices doctorAdviceServices ;
    private MediDataVaultServices mediDataVaultServices ;


    @GetMapping("/ping")
    public String ping(){
        log.info("The end point ping has been used");
        return doctorAdviceServices.ping();
    }




    //Consultation CRU Controllers
    @GetMapping("/consultation")
    public List<ConsultationDto> getConsultationDto(){
        //log.info("The end point ConsultationDto has been used");
        return doctorAdviceServices.readConsultation();
    }

    @GetMapping("/consultation/{id}")
    public ConsultationDto getConsultationDto(@PathVariable(name="id") int id) throws RecordNotFoundException {
        //log.info("The end point ConsultationDto has been used");
        return doctorAdviceServices.readConsultation(id);
    }

    @PostMapping("/consultation")
    public  ConsultationDto createConsultationDto(@RequestBody ConsultationDto consultationDto){
        //log.info("The end point product has been used");
        return doctorAdviceServices.createConsultation(consultationDto);
    }

    @PutMapping("/consultation/{id}")
    public boolean updateConsultationDto(@RequestBody ConsultationDto consultationDto,
                                         @PathVariable(name="id") int id)
    {
        if (doctorAdviceServices.updateConsultation(consultationDto, id))
        {
            mediDataVaultServices.updateWarning(consultationDto.getPatientId());
        }
        return doctorAdviceServices.updateConsultation(consultationDto, id);
    }

    //Doctor CRU Controllers




    //Chief Doctor Controllers





    //Other Controllers

    @GetMapping("/doctor/{id}/patients")
    public List<PatientDto> getPatientsOfDoctor(@PathVariable(name = "id") int id)  {
        return doctorAdviceServices.getPatientsOfDoctor(id);
    }

    @GetMapping("/patient/{id}/consultations")
    public List<ConsultationDto> getConsultationsOfPatient(@PathVariable(name = "id") int id)  {
        return doctorAdviceServices.getConsultationsOfPatient(id);
    }

    @GetMapping("/patient/{id}/bgl_records")
    public List<BGL_Dto> getBGLRecordsOfPatient(@PathVariable(name = "id") int id)  {
        return doctorAdviceServices.getBGLRecordsOfPatient(id);
    }

    @GetMapping("/patient/{id}/cdi_records")
    public List<DCI_Dto> getDCIRecordsOfPatient(@PathVariable(name = "id") int id)  {
        return doctorAdviceServices.getDCIRecordsOfPatient(id);
    }

    @GetMapping("/doctor/{id}/patientsnoconsultationlastmonth")
    public  List<PatientDto> getPatientsWithNoConsultationInTheLastMonth(@PathVariable(name = "id") int id)  {
        return doctorAdviceServices.getPatientsWithNoConsultationInTheLastMonth(id);
    }

}