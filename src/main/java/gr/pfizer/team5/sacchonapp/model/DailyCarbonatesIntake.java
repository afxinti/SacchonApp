package gr.pfizer.team5.sacchonapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="DCI_table")
public class DailyCarbonatesIntake {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="DCI_id")
    private int id;
    @Column(name="DCI_date")
    private LocalDate date;
    @Column(name="DCI_time")
    private LocalTime time;
    @Column(name="DCI_measurement")
    private Double measurement;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private Patient patient;
}
