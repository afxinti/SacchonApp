package gr.pfizer.team5.sacchonapp.dto;

import gr.pfizer.team5.sacchonapp.model.Patient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@NoArgsConstructor
@Setter
@Getter
@ToString
public class PatientDto {
    private int id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private int amkaCode;
    private LocalDate dateOfBirth;
    public PatientDto(Patient patient){
        if (patient!=null){
            id = patient.getId();
            username = patient.getUsername();
            password = patient.getPassword();
            amkaCode = patient.getAmkaCode();
            firstName = patient.getFirstName();
            lastName = patient.getLastName();
            dateOfBirth = patient.getDateOfBirth();
        }
    }

    public Patient asPatient(){
        Patient patient = new Patient();
        patient.setId(0);
        patient.setUsername(username); //need to check for unique userName;
        patient.setPassword(password);
        patient.setAmkaCode(amkaCode);
        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patient.setDateOfBirth(dateOfBirth);
        //patient.setDateOfBirth(LocalDate.parse(dateOfBirth));
        return patient;
    }

}