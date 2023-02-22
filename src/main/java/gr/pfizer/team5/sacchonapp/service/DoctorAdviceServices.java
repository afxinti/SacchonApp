package gr.pfizer.team5.sacchonapp.service;


import gr.pfizer.team5.sacchonapp.dto.*;
import gr.pfizer.team5.sacchonapp.exception.RecordNotFoundException;
import gr.pfizer.team5.sacchonapp.model.Doctor;

import java.util.List;

public interface DoctorAdviceServices {
    String ping();

    // Consultation  CRU

    ConsultationDto createConsultation(ConsultationDto consultation);
    List<ConsultationDto> readConsultation();
    ConsultationDto readConsultation(int id) throws RecordNotFoundException;
    boolean updateConsultation(ConsultationDto consultation, int id);


    // Doctor CRUD

    DoctorDto createDoctor(DoctorDto doctor);
    List<DoctorDto> readDoctor();
    DoctorDto readDoctor(int id) throws RecordNotFoundException;
    boolean updateDoctor(DoctorDto doctor, int id);
    boolean deleteDoctor(int id) ;


    // Chief Doctor CRUD

    ChiefDoctorDto createChiefDoctor(ChiefDoctorDto chiefdoctor);
    List<ChiefDoctorDto> readChiefDoctor();
    ChiefDoctorDto readChiefDoctor(int id) throws RecordNotFoundException;
    boolean updateChiefDoctor(ChiefDoctorDto chiefdoctor, int id);
    boolean deleteChiefDoctor(int id) ;




    //Other Services

    List<ConsultationDto> getConsultationsOfPatient(int id);

    List<BGL_Dto> getBGLRecordsOfPatient(int id);

    List<DCI_Dto> getDCIRecordsOfPatient(int id);

    List<PatientDto> getPatientsOfDoctor(int id);

    List<PatientDto> getPatientsWithNoConsultationInTheLastMonth(int id);

}
