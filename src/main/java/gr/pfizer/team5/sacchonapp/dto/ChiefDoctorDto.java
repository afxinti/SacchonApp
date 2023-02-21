package gr.pfizer.team5.sacchonapp.dto;

import gr.pfizer.team5.sacchonapp.model.ChiefDoctor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ChiefDoctorDto {

    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    public ChiefDoctorDto(ChiefDoctor chiefdoctor){
        if (chiefdoctor!= null){
            id = chiefdoctor.getId();
            firstName = chiefdoctor.getFirstName();
            lastName = chiefdoctor.getLastName();
            email = chiefdoctor.getEmail();
        }
    }
    public ChiefDoctor asChiefDoctor(){
        ChiefDoctor chiefdoctor = new ChiefDoctor();
        chiefdoctor.setId(0);
        chiefdoctor.setFirstName(firstName);
        chiefdoctor.setLastName(lastName);
        chiefdoctor.setEmail(email);
        return chiefdoctor;
    }
}
