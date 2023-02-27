package gr.pfizer.team5.sacchonapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "currentDoctor")
    private Set<Patient> managedPatients;
    @OneToOne(cascade = CascadeType.PERSIST)//cascade??
    @JoinColumn(name = "user_id")
    private Users user;
    private List<Patient> managedPatients;
}

