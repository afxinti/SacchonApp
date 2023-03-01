package gr.pfizer.team5.sacchonapp.controller;

import gr.pfizer.team5.sacchonapp.dto.BGL_Dto;
import gr.pfizer.team5.sacchonapp.dto.DCI_Dto;
import gr.pfizer.team5.sacchonapp.dto.*;
import gr.pfizer.team5.sacchonapp.exception.CustomException;
import gr.pfizer.team5.sacchonapp.dto.PatientDto;
import gr.pfizer.team5.sacchonapp.service.MediDataVaultServices;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

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
    public BGL_Dto getBGLDto(@PathVariable(name="id") int id) throws CustomException {
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
    @DeleteMapping("/bgl/{id}")
    public boolean deleteBGL(@PathVariable(name="id")int id){
        return mediDataVaultServices.deleteBGL(id);
    }

    //DCI controller methods

    @GetMapping("/dci")
    public List<DCI_Dto> getDCIDto(){
        return mediDataVaultServices.readDCI();
    }

    @GetMapping("/dci/{id}")
    public DCI_Dto getDCIDto(@PathVariable(name="id") int id) throws CustomException {
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
    @DeleteMapping("/dci/{id}")
    public boolean deleteDCI(@PathVariable(name="id")int id){
        return mediDataVaultServices.deleteDCI(id);
    }

    @GetMapping("/dci/{id}/avg/between-dates")
    public Double getAverageDCIBetweenDates(@PathVariable(name="id") int id,@RequestParam("startDate") LocalDate startDate, @RequestParam("endDate") LocalDate endDate) {
        return mediDataVaultServices.getAverageDCIBetweenDates(id,startDate,endDate);
    }
    @GetMapping("/bgl/{id}/avg/between-dates")
    public Double getAverageBGLBetweenDates(@PathVariable(name="id") int id,@RequestParam("startDate") LocalDate startDate, @RequestParam("endDate") LocalDate endDate) {
        return mediDataVaultServices.getAverageBGLBetweenDates(id,startDate,endDate);
    }

    @GetMapping("/dci/{id}/progress")
    public long numberOfRecordsDCI(@PathVariable(name="id") int id) throws CustomException {
        return mediDataVaultServices.isFirstAndLastRecordWithin30Days(id,"DCI");
    }
    @GetMapping("/bgl/{id}/progress")
    public long numberOfRecordsBGL(@PathVariable(name="id") int id) throws CustomException {
        return mediDataVaultServices.isFirstAndLastRecordWithin30Days(id,"BGL");
    }
    @GetMapping("/bgl/{id}/enoughRecordingsCheck")
    public boolean enoughRecordingsCheckBGL(@PathVariable(name="id") int id) throws CustomException {
        return mediDataVaultServices.enoughRecordingsCheck(id,"BGL");
    }
    @GetMapping("/dci/{id}/enoughRecordingsCheck")
    public boolean enoughRecordingsCheckDCI(@PathVariable(name="id") int id) throws CustomException {
        return mediDataVaultServices.enoughRecordingsCheck(id,"DCI");
    }
    @GetMapping("/bgl/{id}/checkLowRecordsExist")
    public long checkLowRecordsExist(@PathVariable(name="id") int id){
        return mediDataVaultServices.checkLowRecordingsExist(id);
    }
    //------------------------------------------------end of DCI BGL methods------------------------------------------//

    //Patient CRUD Controllers
    //json: post only username/password
    @PostMapping("/login/patient")
    public boolean loginPatient(@RequestBody PatientDto patientDto){
        return mediDataVaultServices.loginPatient(patientDto);
    }
    @GetMapping("/patient")
    public List<PatientDto> readPatient(){
        return mediDataVaultServices.readPatient();
    }
    @PostMapping("/patient")
    public PatientDto createPatient(@RequestBody PatientDto patientDto) throws CustomException {
        log.info("The createPatient endpoint is used");
        return mediDataVaultServices.createPatient(patientDto);
    }
    @GetMapping("/patient/{id}")
    public PatientDto readPatientDto(@PathVariable(name = "id") int id) throws CustomException {
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


    @GetMapping("/patient/{id}/warning")
    public WarningDto warnPatientAboutModifiedConsultation(@PathVariable(name = "id") int id){
        return mediDataVaultServices.warnPatientAboutModifiedConsultation(id);
    }
}

