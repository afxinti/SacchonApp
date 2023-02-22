package gr.pfizer.team5.sacchonapp.service;

import gr.pfizer.team5.sacchonapp.dto.PatientDto;

import java.util.List;

public interface ReporterServices {

    List<PatientDto> getPatientsWaitingForConsultation();


}
