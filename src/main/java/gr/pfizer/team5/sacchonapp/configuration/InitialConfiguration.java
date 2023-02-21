package gr.pfizer.team5.sacchonapp.configuration;

import gr.pfizer.team5.sacchonapp.model.BloodGlucoseLevel;
import gr.pfizer.team5.sacchonapp.model.Doctor;
import gr.pfizer.team5.sacchonapp.model.Patient;
import gr.pfizer.team5.sacchonapp.repository.BGLRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class InitialConfiguration {
//    @Bean
//    CommandLineRunner commandLineRunner(
//            BGLRepository BGLRepository){
//        return args -> {
//            BloodGlucoseLevel bgl1 = new BloodGlucoseLevel(0,date,time,122.0,new Patient());
//            BloodGlucoseLevel bgl2 = new BloodGlucoseLevel(0,date,time,122.0,new Patient());
//            BGLRepository.saveAll(List.of(bgl1, bgl2));
//        };
//    }

}