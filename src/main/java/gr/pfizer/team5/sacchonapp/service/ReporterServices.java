package gr.pfizer.team5.sacchonapp.service;

<<<<<<< HEAD
import gr.pfizer.team5.sacchonapp.dto.PatientDto;

import java.util.List;

public interface ReporterServices {

    List<PatientDto> getPatientsWaitingForConsultation();


=======
public interface ReporterServices {
    //crud

    //query select * from records where patientId = x && date between inputOfReporter
    // query select * from consultations where doctorId =x && date between inputOfReporter
    //query select * from patients where localdate.now- consultation.date >30
    //query select * consultations where patientId =x && date between inputOfReporter
    //query setOfPatients- Set(select patientId from records where date between inputOfReporter)
    //query setOfDoctors- Set(select doctorId from consultations where date between inputOfReporter)
>>>>>>> origin/afroditi
}
