package gr.pfizer.team5.sacchonapp.service;


import gr.pfizer.team5.sacchonapp.dto.ConsultationDto;
import java.util.List;

public interface DoctorAdviceServices {

    // Consultation  CRU

    ConsultationDto createConsultation(ConsultationDto consultation);
    List<ConsultationDto> readConsultation();
    ConsultationDto readConsultation(int id) throws MyException;
    boolean updateConsultation(ConsultationDto consultation, int id);
    String ping();

}
