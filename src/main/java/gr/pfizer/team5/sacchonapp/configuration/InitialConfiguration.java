package gr.pfizer.team5.sacchonapp.configuration;

import gr.pfizer.team5.sacchonapp.model.*;
import gr.pfizer.team5.sacchonapp.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashSet;



@Configuration
public class InitialConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(
            PatientRepository patientRepository, DoctorRepository doctorRepository, BGLRepository BGLRepository, DCIRepository DCIRepository,ConsultationRepository consultationRepository, ChiefDoctorRepository chiefDoctorRepository,UsersRepository usersRepository) {
        return args -> {

            Faker faker = new Faker();
            Date maxDate = new Date(); // today's date
            for (int i = 0; i < 10; i++) {
                Patient patient = new Patient();
                String username3 = faker.name().username();
                String password3 = faker.internet().password();

                patient.setUsername(username3);
                patient.setPassword(password3);
                patient.setFirstName(faker.name().firstName());
                patient.setLastName(faker.name().lastName());
                int amkaCode = (int) faker.number().randomNumber(11,true);
                if (amkaCode < 0) {
                    amkaCode *= -1;
                }
                patient.setAmkaCode(amkaCode);

                // Generate a new randomTimestamp for each patient
                Date minDate = Date.from(LocalDate.of(2022, 5, 1).atStartOfDay(ZoneId.systemDefault()).toInstant());
                long randomTimestamp = faker.date().between(minDate, maxDate).getTime();
                patient.setDateOfBirth(new java.sql.Date(randomTimestamp).toLocalDate());

                Users userPatient = new Users();
                userPatient.setUsername(username3);
                userPatient.setPassword(password3);
                userPatient.setAuthority(Authority.PATIENT);
                patient.setUser(userPatient);
                patientRepository.save(patient);

                for (int j=0; j<15; j++) {
                    BloodGlucoseLevel bgl = new BloodGlucoseLevel();
                    long randomTimestamp2 = faker.date().between(minDate, maxDate).getTime();

                    bgl.setDate(new java.sql.Date(randomTimestamp2).toLocalDate());
                    bgl.setTime(faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().toLocalTime());
                    bgl.setMeasurement(faker.number().randomDouble(1, 0, 200));
                    bgl.setPatient(patient);
                    BGLRepository.save(bgl);
                }

                    for (int k=0; k<15; k++) {
                        DailyCarbonatesIntake dci = new DailyCarbonatesIntake();
                        long randomTimestamp3 = faker.date().between(minDate, maxDate).getTime();
                        dci.setDate(new java.sql.Date(randomTimestamp3).toLocalDate());
                        dci.setTime(faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().toLocalTime());
                        dci.setMeasurement(faker.number().randomDouble(1, 0, 200));
                        dci.setPatient(patient);
                        DCIRepository.save(dci);
                    }
                    Doctor doctor = new Doctor();
                    doctor.setEmail(faker.internet().emailAddress());
                    String username1 = faker.name().username();
                    doctor.setUsername(username1);
                    String password1 = faker.internet().password();
                    doctor.setPassword(password1);
                    doctor.setFirstName(faker.name().firstName());
                    doctor.setLastName(faker.name().lastName());
                    doctor.setManagedPatients(new HashSet<>());

                    Users userDoctor = new Users();
                    userDoctor.setUsername(username1);
                    userDoctor.setPassword(password1);
                    userDoctor.setAuthority(Authority.DOCTOR);
                    doctor.setUser(userDoctor);
                    doctorRepository.save(doctor);

                    for (int l=0;l<10;l++) {
                        Consultation consultation = new Consultation();
                        long randomTimestamp4 = faker.date().between(minDate, maxDate).getTime();
                        consultation.setDate(new java.sql.Date(randomTimestamp4).toLocalDate());
                        consultation.setNameOfMedication(faker.medical().medicineName());
                        consultation.setDosage(faker.number().numberBetween(1, 100));
                        consultation.setNotes(faker.lorem().sentence());
                        consultation.setDoctor_id(doctor.getId());
                        consultation.setPatient(patient);
                        consultationRepository.save(consultation);
                    }

                    ChiefDoctor chiefDoctor = new ChiefDoctor();
                    chiefDoctor.setEmail(faker.internet().emailAddress());
                    String username2 = faker.name().username();
                    chiefDoctor.setUsername(username2);
                    String password2 = faker.internet().password();
                    chiefDoctor.setPassword(password2);
                    chiefDoctor.setFirstName(faker.name().firstName());
                    chiefDoctor.setLastName(faker.name().lastName());

                    Users userChief = new Users();
                    userChief.setAuthority(Authority.CHIEF);
                    userChief.setUsername(username2);
                    userChief.setPassword(password2);
                    doctor.setUser(userDoctor);
                    chiefDoctor.setUser(userChief);
                    chiefDoctorRepository.save(chiefDoctor);

                }
//            Patient pat1 = new Patient(0, "Giannis22", "drop12", "Giannis", "Kourtis", 1704930012, LocalDate.of(1993, 4, 17), false, false, null, null, null, null, new Users("Giannis22", "drop12", Authority.PATIENT));
//            Patient pat2 = new Patient(0, "Georgia172", "koks14", "Georgia", "Panagi", 1012890077, LocalDate.of(1997, 5, 4), false, false, null, null, null, null, new Users("Georgia172", "koks14", Authority.PATIENT));
//                patientRepository.saveAll(List.of(pat1, pat2));
//                BloodGlucoseLevel bgl1 = new BloodGlucoseLevel(0, LocalDate.of(2023, 1, 10), LocalTime.of(12, 16), 12.0, pat1);
//                BloodGlucoseLevel bgl2 = new BloodGlucoseLevel(0, LocalDate.of(2022, 5, 13), LocalTime.of(13, 20), 10.0, pat1);
//                BGLRepository.saveAll(List.of(bgl1, bgl2));
//                DailyCarbonatesIntake dci1 = new DailyCarbonatesIntake(0, LocalDate.of(2022, 12, 2), LocalTime.of(10, 22), 200.0, pat1);
//                DailyCarbonatesIntake dci2 = new DailyCarbonatesIntake(0, LocalDate.of(2022, 12, 14), LocalTime.of(12, 17), 190.0, pat1);
//                DCIRepository.saveAll(List.of(dci1, dci2));
//                Doctor doc1 = new Doctor(0, "appdoc@cod.gr", "aapdoc", "werqr2", "Panagiota", "Deli", Set.of(pat1, pat2), new Users(0, "aapdoc", "werqr2", Authority.DOCTOR));
//                Doctor doc2 = new Doctor(0, "apap@fka.com", "apap", "aposl2", "Giorgos", "Papas", null, new Users(0, "apap", "aposl2", Authority.DOCTOR));
//                doctorRepository.saveAll(List.of(doc1, doc2));
//                Consultation cons1 = new Consultation(0, LocalDate.of(2023, 2, 20), "xanax", 20, "two per day", 1, pat1);
//                Consultation cons2 = new Consultation(0, LocalDate.of(2023, 1, 18), "lyrica", 10, "one per day", 1, pat2);
//                consultationRepository.saveAll(List.of(cons1, cons2));
//                ChiefDoctor chief1 = new ChiefDoctor(0, "bard@lanf.gr", "bard", "sssoo90", "Thanasis", "Lelos", new Users("bard", "sssoo90", Authority.CHIEF));
//                ChiefDoctor chief2 = new ChiefDoctor(0, "ang@lanf.gr", "ang", "sso90", "Aggeliki", "Georgiou", new Users("ang", "sso90", Authority.CHIEF));
//                chiefDoctorRepository.saveAll(List.of(chief1, chief2));
            };
        }
    }
