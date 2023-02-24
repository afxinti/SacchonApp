package gr.pfizer.team5.sacchonapp.configuration;


import gr.pfizer.team5.sacchonapp.model.*;
import gr.pfizer.team5.sacchonapp.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Configuration
public class InitialConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(
            DoctorRepository docRepository, PatientRepository patientRepository, DCIRepository dciRepository,
            BGLRepository bglRepository, ConsultationRepository consRepository, ChiefDoctorRepository chiefdocRepository) {
        return args -> {

            Patient patient1 = new Patient(0, "Dim", "dimitris", "Dimitris", "Georgiou", 5, LocalDate.now(), false, null, null, null, null);
            Patient patient2 = new Patient(0, "Geo", "georg", "Giorgos", "Apostolou", 5, LocalDate.now(), false, null, null, null, null);
            patientRepository.saveAll(List.of(patient1, patient2));

            Doctor doctor1 = new Doctor(0, "malvina@gmail.com", "Malvina", "Malvina", "Antoniou", List.of(patient1));
            Doctor doctor2 = new Doctor(0, "anna@gmail.com", "annadd", "Anna", "Papadopoulou", List.of(patient2));
            docRepository.saveAll(List.of(doctor1, doctor2));

            DailyCarbonatesIntake carb1 = new DailyCarbonatesIntake(0, LocalDate.of(2022, 5, 17),LocalTime.now(), 1.2, patient1);
            DailyCarbonatesIntake carb2 = new DailyCarbonatesIntake(0, LocalDate.of(2022, 2, 2), LocalTime.now(), 1.4, patient2);
            dciRepository.saveAll(List.of(carb1, carb2));

            BloodGlucoseLevel bgl1 = new BloodGlucoseLevel(0, LocalDate.of(2022, 3, 22), LocalTime.of(14,15,18), 0.2, patient1);
            BloodGlucoseLevel bgl2 = new BloodGlucoseLevel(0, LocalDate.of(2022, 5, 5), LocalTime.of(13,45,7), 1.2, patient2);
            bglRepository.saveAll(List.of(bgl1, bgl2));

            Consultation cons1 = new Consultation(0, LocalDate.of(2022, 2, 2), "Malvina_cons", 5, "Take pills", 2, patient1);
            Consultation cons2 = new Consultation(0, LocalDate.of(2022, 11, 15), "Giorgos_cons", 3, "Take pills", 1, patient2);
            consRepository.saveAll(List.of(cons1, cons2));

            System.out.println(bgl1.getDate().getDayOfMonth());
            System.out.println(LocalDate.now().getMonthValue());
            System.out.println(bgl1.getPatient().getId());
            System.out.println(bgl1.getTime());

//            ChiefDoctor chiefdoctor1 = new ChiefDoctor(0 , "malvina@gmail.com",  "Malvina", "Malvina", "Antoniou", null);
//            ChiefDoctor chiefdoctor2 = new ChiefDoctor(0 , "malsdvsdvvina@gmail.com",  "Malvdsvdina", "Mcdsina", "Acdsniou", null);
//            chiefdocRepository.saveAll(List.of(chiefdoctor1, chiefdoctor2));

        };
    }

}