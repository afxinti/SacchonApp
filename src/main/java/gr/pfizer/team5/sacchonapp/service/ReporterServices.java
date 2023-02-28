package gr.pfizer.team5.sacchonapp.service;

import gr.pfizer.team5.sacchonapp.dto.BGL_Dto;
import gr.pfizer.team5.sacchonapp.dto.ConsultationDto;
import gr.pfizer.team5.sacchonapp.dto.DCI_Dto;
import gr.pfizer.team5.sacchonapp.dto.PatientDto;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface ReporterServices {

    List<PatientDto> getPatientsWaitingForConsultation();
    List<DCI_Dto> getDCIBetweenDates(int id, LocalDate startDate, LocalDate endDate);
    List<BGL_Dto> getBGLBetweenDates(int id, LocalDate startDate, LocalDate endDate);

    List<ConsultationDto> getConsultationsDoctorBetweenDates(int id, LocalDate startDate, LocalDate endDate);
    List<ConsultationDto> getConsultationsPatientBetweenDates(int id, LocalDate startDate, LocalDate endDate);

    //crud

    //query select * from records where patientId = x && date between inputOfReporter(have to move from MediDataVault Services) | done!
    // query select * from consultations where doctorId =x && date between inputOfReporter | done!
    //query select * from patients where localdate.now- consultation.date >30
    //query select * consultations where patientId =x && date between inputOfReporter |done!
    //query select * consultations where patientId =x && date between inputOfReporter

    //query setOfPatients- Set(select patientId from records where date between inputOfReporter)
    List<Map> patientsWithNoActivityService(LocalDate startDate, LocalDate endDate);

    //query setOfDoctors- Set(select doctorId from consultations where date between inputOfReporter)
    List<Integer> doctorsWithNoActivityService(LocalDate startDate, LocalDate endDate);

}
