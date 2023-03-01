package gr.pfizer.team5.sacchonapp.dto;

import gr.pfizer.team5.sacchonapp.model.Authority;
import gr.pfizer.team5.sacchonapp.model.Patient;
import lombok.*;

import java.time.LocalDate;


@NoArgsConstructor
@Setter
@Getter
@ToString
public class PatientDto{
    private int id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private int amkaCode;
    private LocalDate dateOfBirth;
    private int doctorId;
    private boolean hasRecordings;
    private Authority authority;

    //private int userId;
    public PatientDto(Patient patient){
        if (patient!=null){
            id = patient.getId();
            username = patient.getUsername();
            password = patient.getPassword();
            amkaCode = patient.getAmkaCode();
            firstName = patient.getFirstName();
            lastName = patient.getLastName();
            dateOfBirth = patient.getDateOfBirth();
            hasRecordings = patient.isHasRecordings();
            authority = patient.getUser().getAuthority();
            if(patient.getCurrentDoctor()!=null){
                doctorId = patient.getCurrentDoctor().getId();
            }else {
                doctorId = 0;
            }
        }
    }

    public Patient asPatient(){
        Patient patient = new Patient();
        patient.setId(0);
        patient.setUsername(username);
        patient.setPassword(password);
        patient.setAmkaCode(amkaCode);
        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patient.setDateOfBirth(dateOfBirth);
        patient.setHasRecordings(hasRecordings);
//        Users user = new Users(); //connect user+patient
//        user.setId(userId);
//        patient.setUser(user);
        return patient;
    }

}