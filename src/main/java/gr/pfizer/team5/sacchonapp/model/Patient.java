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
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private int amkaCode;
    private LocalDate dateOfBirth;
    private boolean hasRecordings;
    private boolean warning_modifiedconsultation;
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