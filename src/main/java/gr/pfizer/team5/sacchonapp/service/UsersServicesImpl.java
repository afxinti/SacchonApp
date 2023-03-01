package gr.pfizer.team5.sacchonapp.service;
import gr.pfizer.team5.sacchonapp.dto.*;
import gr.pfizer.team5.sacchonapp.dto.LoginDto;
import gr.pfizer.team5.sacchonapp.exception.RecordNotFoundException;
import gr.pfizer.team5.sacchonapp.model.*;
import gr.pfizer.team5.sacchonapp.repository.ChiefDoctorRepository;
import gr.pfizer.team5.sacchonapp.repository.DoctorRepository;
import gr.pfizer.team5.sacchonapp.repository.PatientRepository;
import gr.pfizer.team5.sacchonapp.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsersServicesImpl implements UsersServices{
    private final UsersRepository usersRepository;

    public LoginDto loginUser(UserDto userDto) throws RecordNotFoundException {
        if (usersRepository.existsUsersByUsernameAndPassword(userDto.getUsername(), userDto.getPassword())) {
            Users user = usersRepository.findByUsername(userDto.getUsername());
            return new LoginDto(true, user.getAuthority());
        } else {
            return new LoginDto(false, null);
        }
    }

    //Second way for signup
//        public boolean signupUser(UserDto userDto) throws RecordNotFoundException {
//            boolean action = true;
//            String username = userDto.getUsername();
//            if (usersRepository.findByUsername(username) != null) {
//                throw new RecordNotFoundException("Username already exists");
//            }
//
//            Users user = userDto.asUser();
//            usersRepository.save(user);
//
//            switch (user.getAuthority()) {
//                case PATIENT:
//                    Patient patient = userDto.asPatient();
//                    patient.setUser(user);
//                    patientRepository.save(patient);
//                    break;
//                case DOCTOR:
//                    Doctor doctor = userDto.asDoctor();
//                    doctor.setUser(user);
//                    doctorRepository.save(doctor);
//                    break;
//                case CHIEF:
//                    ChiefDoctor chief = userDto.asChiefDoctor();
//                    chief.setUser(user);
//                    chiefDoctorRepository.save(chief);
//                    break;
//                default:
//                    action = false;
//            }
//            return action;
//        }
    }