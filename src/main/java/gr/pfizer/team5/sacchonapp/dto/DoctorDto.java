package gr.pfizer.team5.sacchonapp.dto;

import gr.pfizer.team5.sacchonapp.model.Doctor;
import gr.pfizer.team5.sacchonapp.model.Patient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class DoctorDto {

    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private List<Patient> managedPatients;

    public DoctorDto(Doctor doctor){
        if (doctor!= null){
            id = doctor.getId();
            firstName = doctor.getFirstName();
            lastName = doctor.getLastName();
            email = doctor.getEmail();
            password = doctor.getPassword();
            managedPatients = doctor.getManagedPatients();
        }
    }
    public Doctor asDoctor(){
        Doctor doctor = new Doctor();
        doctor.setId(id);
        doctor.setFirstName(firstName);
        doctor.setLastName(lastName);
        doctor.setEmail(email);
        doctor.setPassword(password);
        doctor.setManagedPatients(managedPatients);
        return doctor;
    }
}