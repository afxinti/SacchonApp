package gr.pfizer.team5.sacchonapp.service;

import gr.pfizer.team5.sacchonapp.dto.BGL_Dto;
import gr.pfizer.team5.sacchonapp.dto.DCI_Dto;
import gr.pfizer.team5.sacchonapp.dto.WarningDto;
import gr.pfizer.team5.sacchonapp.exception.CustomException;
import gr.pfizer.team5.sacchonapp.dto.PatientDto;
import java.time.LocalDate;
import java.util.List;
public interface MediDataVaultServices {

    // Patient CRUD

    boolean loginPatient(PatientDto patientDto);
    PatientDto createPatient(PatientDto patient) throws CustomException;
    PatientDto readPatient(int id) throws CustomException;
    List<PatientDto> readPatient();
    boolean updatePatient(PatientDto patient,int id);
    boolean deletePatient(int id);
    void updateWarning(int id);
    WarningDto warnPatientAboutModifiedConsultation(int id);


    //BGL CRU

    BGL_Dto createBGL(BGL_Dto bgl);
    List<BGL_Dto> readBGL();
    BGL_Dto readBGL(int id) throws CustomException;
    boolean updateBGL(BGL_Dto consultation, int id);
    boolean deleteBGL(int id);

    //DCI CRU

    DCI_Dto createDCI(DCI_Dto dci);
    List<DCI_Dto> readDCI();
    DCI_Dto readDCI(int id) throws CustomException;
    boolean updateDCI(DCI_Dto dci_dto, int id);
    boolean deleteDCI(int id);
    Double getAverageDCIBetweenDates(int id,LocalDate startDate, LocalDate endDate);
    Double getAverageBGLBetweenDates(int id,LocalDate startDate, LocalDate endDate);
    //    long isFirstAndLastRecordWithin30Days(int patientId,String recordType) throws CustomException;
    boolean enoughRecordingsCheck(int patientId) throws CustomException;
    long checkLowRecordingsExist(int patientId);
    long numberOfRecordings(int patientId);

}
