package gr.pfizer.team5.sacchonapp.service;

import gr.pfizer.team5.sacchonapp.dto.BGL_Dto;
import gr.pfizer.team5.sacchonapp.dto.DCI_Dto;
import gr.pfizer.team5.sacchonapp.exception.RecordNotFoundException;
import gr.pfizer.team5.sacchonapp.dto.PatientDto;

import java.util.List;

public interface MediDataVaultServices {
    PatientDto createPatient(PatientDto patient) throws RecordNotFoundException;
    PatientDto readPatient(int id) throws RecordNotFoundException;
    List<PatientDto> readPatient();
    boolean updatePatient(PatientDto patient,int id);
    boolean deletePatient(int id);
    BGL_Dto createBGL(BGL_Dto bgl);
    List<BGL_Dto> readBGL();
    BGL_Dto readBGL(int id) throws RecordNotFoundException;
    boolean updateBGL(BGL_Dto consultation, int id);

    DCI_Dto createDCI(DCI_Dto dci);
    List<DCI_Dto> readDCI();
    DCI_Dto readDCI(int id) throws RecordNotFoundException;
    boolean updateDCI(DCI_Dto dci_dto, int id);
}
