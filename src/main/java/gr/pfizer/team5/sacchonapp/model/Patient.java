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
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="username",unique = true)
    private String username;
    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column (name ="amka_code")
    private int amkaCode;
    @Column(name="date_of_birth")
    private LocalDate dateOfBirth;
    @Column(name = "has_recordings")
    private boolean hasRecordings;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="doctor_id",referencedColumnName="id")
    private Doctor currentDoctor;
    @OneToMany(mappedBy="patient")
    private List<Consultation> consultations;
    @OneToMany(mappedBy="patient")
    private List<DailyCarbonatesIntake> dailyCarbonatesIntakes;
    @OneToMany(mappedBy="patient")
    private List<DailyCarbonatesIntake> bloodGlucoseLevel;

}