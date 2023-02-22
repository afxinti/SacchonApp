package gr.pfizer.team5.sacchonapp.dto;


import gr.pfizer.team5.sacchonapp.model.BloodGlucoseLevel;
import gr.pfizer.team5.sacchonapp.model.Patient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@NoArgsConstructor
public class BGL_Dto {

    private int id;
    private LocalDate date;
    private LocalTime time;
    private Double measurement;
    private int patientId;



    public BGL_Dto(BloodGlucoseLevel bloodGlucoseLevel) {
        if (bloodGlucoseLevel != null) {
            id = bloodGlucoseLevel.getId();
            date = bloodGlucoseLevel.getDate();
            time = bloodGlucoseLevel.getTime();
            measurement = bloodGlucoseLevel.getMeasurement();
            patientId = bloodGlucoseLevel.getPatient().getId();

        }
    }

    public BloodGlucoseLevel asBGL() {
        BloodGlucoseLevel bloodGlucoseLevel = new BloodGlucoseLevel();
        bloodGlucoseLevel.setId(id);
        bloodGlucoseLevel.setDate(date);
        bloodGlucoseLevel.setTime(time);
        bloodGlucoseLevel.setMeasurement(measurement);

        Patient patient = new Patient();
        patient.setId(patientId);
        bloodGlucoseLevel.setPatient(patient);

        return bloodGlucoseLevel;
    }
}



