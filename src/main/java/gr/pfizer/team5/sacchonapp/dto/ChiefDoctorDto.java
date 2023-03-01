package gr.pfizer.team5.sacchonapp.dto;

import gr.pfizer.team5.sacchonapp.model.Authority;
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
    private String username;
    private String firstName;
    private String lastName;
    private Authority authority;

    public ChiefDoctorDto(ChiefDoctor chiefdoctor){
        if (chiefdoctor!= null){
            id = chiefdoctor.getId();
            firstName = chiefdoctor.getFirstName();
            lastName = chiefdoctor.getLastName();
            email = chiefdoctor.getEmail();
            username = chiefdoctor.getUsername();
            authority= chiefdoctor.getUser().getAuthority();
        }
    }
    public ChiefDoctor asChiefDoctor(){
        ChiefDoctor chiefdoctor = new ChiefDoctor();
        chiefdoctor.setId(id);
        chiefdoctor.setFirstName(firstName);
        chiefdoctor.setLastName(lastName);
        chiefdoctor.setEmail(email);
        chiefdoctor.setUsername(username);
        return chiefdoctor;
    }
}
