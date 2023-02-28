package gr.pfizer.team5.sacchonapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Patient")
public class Patient{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="Username")
    private String username;
    @Column(name = "Password")
    private String password;

    @Column(name = "First_name")
    private String firstName;
    @Column(name = "Last_name")
    private String lastName;
    @Column (name ="Amka_code")
    private int amkaCode;
    @Column(name="Date_of_birth")
    private LocalDate dateOfBirth;
    @Column(name = "Has_recordings")
    private boolean hasRecordings;
    @Column(name = "Has_ModifiedConsultation")
    private boolean warning_modifiedconsultation;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="doctor_id",referencedColumnName="id")
    private Doctor currentDoctor;
    @OneToMany(mappedBy="patient", cascade = CascadeType.ALL)
    private List<Consultation> consultations;

    @OneToMany(mappedBy="patient", cascade = CascadeType.ALL)
    private List<DailyCarbonatesIntake> dailyCarbonatesIntakes;

    @OneToMany(mappedBy="patient", cascade = CascadeType.ALL)
    private List<BloodGlucoseLevel> bloodGlucoseLevels;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Users user;
}