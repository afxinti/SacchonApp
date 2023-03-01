package gr.pfizer.team5.sacchonapp.configuration;

import gr.pfizer.team5.sacchonapp.model.*;
import gr.pfizer.team5.sacchonapp.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Configuration
public class InitialConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(
            PatientRepository patientRepository, DoctorRepository doctorRepository, BGLRepository BGLRepository, DCIRepository DCIRepository,ConsultationRepository consultationRepository, ChiefDoctorRepository chiefDoctorRepository,UsersRepository usersRepository){
        return args -> {
            Patient pat1 = new Patient(0,"Giannis22","drop12","Giannis","Kourtis",1704930012,LocalDate.of(1993,4,17),false,false,null,null,null,null,new Users("Giannis22","drop12",Authority.PATIENT));
            Patient pat2 = new Patient(0,"Georgia172","koks14","Georgia","Panagi",1012890077,LocalDate.of(1997,5,4),false,false,null,null,null,null,new Users("Georgia172","koks14", Authority.PATIENT));
            patientRepository.saveAll(List.of(pat1,pat2));
            BloodGlucoseLevel bgl1 = new BloodGlucoseLevel(0, LocalDate.of(2023,1,10), LocalTime.of(12,16),12.0,pat1);
            BloodGlucoseLevel bgl2 = new BloodGlucoseLevel(0, LocalDate.of(2022,5,13), LocalTime.of(13,20),10.0,pat1);
            BGLRepository.saveAll(List.of(bgl1, bgl2));
            DailyCarbonatesIntake dci1= new DailyCarbonatesIntake(0,LocalDate.of(2022,12,2),LocalTime.of(10,22),200.0,pat1);
            DailyCarbonatesIntake dci2= new DailyCarbonatesIntake(0,LocalDate.of(2022,12,14),LocalTime.of(12,17),190.0,pat1);
            DCIRepository.saveAll(List.of(dci1,dci2));
            Doctor doc1 = new Doctor(0,"appdoc@cod.gr","aapdoc","werqr2","Panagiota","Deli", Set.of(pat1,pat2),new Users(0,"aapdoc","werqr2", Authority.DOCTOR));
            Doctor doc2 = new Doctor(0,"apap@fka.com","apap","aposl2","Giorgos","Papas",null,new Users(0,"apap","aposl2", Authority.DOCTOR));
            doctorRepository.saveAll(List.of(doc1,doc2));
            Consultation cons1 = new Consultation(0, LocalDate.of(2023,2,20),"xanax",20,"two per day",1,pat1);
            Consultation cons2 = new Consultation(0, LocalDate.of(2023,1,18),"lyrica",10,"one per day",1,pat2);
            consultationRepository.saveAll(List.of(cons1,cons2));
            ChiefDoctor chief1 = new ChiefDoctor(0,"bard@lanf.gr","bard","sssoo90","Thanasis","Lelos",new Users("bard","sssoo90",Authority.CHIEF));
            ChiefDoctor chief2 = new ChiefDoctor(0,"ang@lanf.gr","ang","sso90","Aggeliki","Georgiou",new Users("ang","sso90",Authority.CHIEF));
            chiefDoctorRepository.saveAll(List.of(chief1,chief2));

        };
    }

}