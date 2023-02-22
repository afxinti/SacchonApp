package gr.pfizer.team5.sacchonapp.controller;

import gr.pfizer.team5.sacchonapp.dto.BGL_Dto;
import gr.pfizer.team5.sacchonapp.dto.DCI_Dto;
import gr.pfizer.team5.sacchonapp.exception.RecordNotFoundException;
import gr.pfizer.team5.sacchonapp.dto.PatientDto;
import gr.pfizer.team5.sacchonapp.model.DailyCarbonatesIntake;
import gr.pfizer.team5.sacchonapp.service.MediDataVaultServices;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@Slf4j
public class MediDataVaultRestController {

    private MediDataVaultServices mediDataVaultServices ;


    //------------------------------------------------start of DCI BGL methods------------------------------------------//

    @GetMapping("/bgl")
    public List<BGL_Dto> getBGLDto(){
        return mediDataVaultServices.readBGL();
    }

    @GetMapping("/bgl/{id}")
    public BGL_Dto getBGLDto(@PathVariable(name="id") int id) throws RecordNotFoundException {
        return mediDataVaultServices.readBGL(id);
    }

    @PostMapping("/bgl")
    public  BGL_Dto createBGLDto(@RequestBody BGL_Dto BGLDto){
        return mediDataVaultServices.createBGL(BGLDto);
    }

    @PutMapping("/bgl/{id}")
    public boolean updateBGLDto(@RequestBody BGL_Dto BGLDto,
                                         @PathVariable(name="id") int id)
    {

        return mediDataVaultServices.updateBGL(BGLDto, id);
    }


    @GetMapping("/dci")
    public List<DCI_Dto> getDCIDto(){
        return mediDataVaultServices.readDCI();
    }

    @GetMapping("/dci/{id}")
    public DCI_Dto getDCIDto(@PathVariable(name="id") int id) throws RecordNotFoundException {
        return mediDataVaultServices.readDCI(id);
    }

    @PostMapping("/dci")
    public  DCI_Dto createDCIDto(@RequestBody DCI_Dto DCIDto){
        //log.info("The end point product has been used");
        return mediDataVaultServices.createDCI(DCIDto);
    }

    @PutMapping("/dci/{id}")
    public boolean updateDCIDto(@RequestBody DCI_Dto DCIDto,
                                @PathVariable(name="id") int id)
    {

        return mediDataVaultServices.updateDCI(DCIDto, id);
    }
    @GetMapping("/dci/between-dates")
    public List<DCI_Dto> getDCIBetweenDates(@RequestParam("startDate") LocalDate startDate, @RequestParam("endDate") LocalDate endDate) {
    return mediDataVaultServices.getDCIBetweenDates(startDate,endDate);
    }
    @GetMapping("/bgl/between-dates")
    public List<BGL_Dto> getBGLBetweenDates(@RequestParam("startDate") LocalDate startDate, @RequestParam("endDate") LocalDate endDate) {
        return mediDataVaultServices.getBGLBetweenDates(startDate,endDate);
    }
    @GetMapping("/dci/avg/between-dates")
    public Double getAverageDCIBetweenDates(@RequestParam("startDate") LocalDate startDate, @RequestParam("endDate") LocalDate endDate) {
        return mediDataVaultServices.getAverageDCIBetweenDates(startDate,endDate);
    }
    @GetMapping("/bgl/avg/between-dates")
    public Double getAverageBGLBetweenDates(@RequestParam("startDate") LocalDate startDate, @RequestParam("endDate") LocalDate endDate) {
        return mediDataVaultServices.getAverageBGLBetweenDates(startDate,endDate);
    }
    //------------------------------------------------end of DCI BGL methods------------------------------------------//

    @GetMapping("/patient")
    public List<PatientDto> readPatient(){
        return mediDataVaultServices.readPatient();
    }
    @PostMapping("/patient")
    public PatientDto createPatient(@RequestBody PatientDto patientDto){
        log.info("The patient was created");
        return mediDataVaultServices.createPatient(patientDto);
    }
    @GetMapping("/patient/{id}")
    public PatientDto readPatientDto(@PathVariable(name = "id") int id) throws RecordNotFoundException {
        log.info("Request a patient/endpoint");
        return mediDataVaultServices.readPatient(id);
    }
    @PutMapping("/patient/{id}")
    public boolean updatePatientDto(@RequestBody PatientDto patientDto,@PathVariable(name ="id") int id){
        return mediDataVaultServices.updatePatient(patientDto,id);
    }
    @DeleteMapping("/patient/{id}")
    public boolean deletePatientDto(@PathVariable(name="id")int id){
        return mediDataVaultServices.deletePatient(id);
    }
}

