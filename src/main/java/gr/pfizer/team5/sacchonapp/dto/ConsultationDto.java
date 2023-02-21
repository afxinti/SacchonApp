package gr.pfizer.team5.sacchonapp.dto;

import gr.pfizer.team5.sacchonapp.model.Consultation;
import gr.pfizer.team5.sacchonapp.model.Patient;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
public class ConsultationDto {
    private int id;
    private LocalDate date;
    private String nameOfMedication;
    private int dosage;
    private String notes;

    private int doctor_id;

    private Patient patient;


    public ConsultationDto(Consultation consultation){
        if (consultation!= null){
            id = consultation.getId();
            date = consultation.getDate();
            nameOfMedication = consultation.getNameOfMedication();
            dosage = consultation.getDosage();
            notes = consultation.getNotes();
            doctorName = consultation.getDoctorName();
        }
    }
    public Consultation asConsultation(){
        Consultation consultation = new Consultation();
        consultation.setId(id);
        consultation.setDate(date);
        consultation.setNameOfMedication(nameOfMedication);
        consultation.setDosage(dosage);
        consultation.setNotes(notes);

        return consultation;
    }

