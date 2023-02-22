package gr.pfizer.team5.sacchonapp.dto;

import gr.pfizer.team5.sacchonapp.model.DailyCarbonatesIntake;
import gr.pfizer.team5.sacchonapp.model.Patient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
@Setter
@Getter
@NoArgsConstructor
public class DCI_Dto {
    private int id;
    private LocalDate date;
    private LocalTime time;
    private Double measurement;
    private int patientId;

    public DCI_Dto(DailyCarbonatesIntake dailyCarbonatesIntake) {
        if (dailyCarbonatesIntake != null) {
            id = dailyCarbonatesIntake.getId();
            date = dailyCarbonatesIntake.getDate();
            time = dailyCarbonatesIntake.getTime();
            measurement = dailyCarbonatesIntake.getMeasurement();
            patientId = dailyCarbonatesIntake.getPatient().getId();
        }
    }

    public DailyCarbonatesIntake asDCI() {
        DailyCarbonatesIntake dailyCarbonatesIntake = new DailyCarbonatesIntake();
        dailyCarbonatesIntake.setId(id);
        dailyCarbonatesIntake.setDate(date);
        dailyCarbonatesIntake.setTime(time);
        dailyCarbonatesIntake.setMeasurement(measurement);

        Patient patient = new Patient();
        patient.setId(patientId);
        dailyCarbonatesIntake.setPatient(patient);

        return dailyCarbonatesIntake;
    }
}

