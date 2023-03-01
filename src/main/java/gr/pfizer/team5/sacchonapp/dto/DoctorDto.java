package gr.pfizer.team5.sacchonapp.dto;

import gr.pfizer.team5.sacchonapp.model.Authority;
import gr.pfizer.team5.sacchonapp.model.Doctor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class DoctorDto {

    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String username;
    private Authority authority;

    public DoctorDto(Doctor doctor){
        if (doctor!= null){
            id = doctor.getId();
            firstName = doctor.getFirstName();
            lastName = doctor.getLastName();
            email = doctor.getEmail();
            password = doctor.getPassword();
            username = doctor.getUsername();
            authority = doctor.getUser().getAuthority();
        }
    }
    public Doctor asDoctor(){
        Doctor doctor = new Doctor();
        doctor.setId(id);
        doctor.setFirstName(firstName);
        doctor.setLastName(lastName);
        doctor.setEmail(email);
        doctor.setPassword(password);
        doctor.setUsername(username);
        return doctor;
    }
}