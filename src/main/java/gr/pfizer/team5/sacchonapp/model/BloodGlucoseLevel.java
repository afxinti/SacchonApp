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
@Table(name="BGL_table")
public class BloodGlucoseLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="BGL_id")
    private int id;
    @Column(name="BGL_date")
    private LocalDate date;
    @Column(name="BGL_time")
    private LocalTime time;
    @Column(name="BGL_measurement")
    private Double measurement;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private Patient patient;
}
