package gr.pfizer.team5.sacchonapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Consultations")
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Date")
    private LocalDate date;
    @Column(name = "NameOfMedication")
    private String nameOfMedication;
    @Column(name = "Dosage")
    private int dosage;
    @Column(name = "Notes")
    private String notes;

    @Column(name = "Doctor")
    private String doctorName;

    @ManyToOne
    private Patient patient;


}