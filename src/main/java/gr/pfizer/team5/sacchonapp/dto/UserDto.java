package gr.pfizer.team5.sacchonapp.dto;

import gr.pfizer.team5.sacchonapp.model.*;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@Setter
@Getter
@ToString
public class UserDto{
    private int id;
   private Authority authority;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private Integer amkaCode;
    private LocalDate dateOfBirth;

//    public Users asUser(){
//        Users user = new Users();
//        user.setUsername(username);
//        user.setPassword(password);
//        user.setAuthority(authority);
//        return user;
//
//    }
//
//    public Patient asPatient() {
//        Patient patient = new Patient();
//        patient.setId(0);
//        patient.setUsername(username);
//        patient.setPassword(password);
//        patient.setAmkaCode(amkaCode);
//        patient.setFirstName(firstName);
//        patient.setLastName(lastName);
//        patient.setDateOfBirth(dateOfBirth);
//        return patient;
//    }
//
//    public Doctor asDoctor() {
//        Doctor doctor = new Doctor();
//        doctor.setId(0);
//        doctor.setUsername(username);
//        doctor.setEmail(email);
//        doctor.setFirstName(firstName);
//        doctor.setLastName(lastName);
//        doctor.setPassword(password);
//        return doctor;
//    }
//
//    public ChiefDoctor asChiefDoctor() {
//        ChiefDoctor chief = new ChiefDoctor();
//        chief.setId(0);
//        chief.setUsername(username);
//        chief.setEmail(email);
//        chief.setFirstName(firstName);
//        chief.setLastName(lastName);
//        chief.setPassword(password);
//        return chief;
//    }

}
