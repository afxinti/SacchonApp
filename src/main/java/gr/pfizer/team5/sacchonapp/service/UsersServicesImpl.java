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

import java.util.Optional;
@AllArgsConstructor
public class UsersServicesImpl implements UsersServices{
    private final PatientRepository patientRepository;
    private final UsersRepository usersRepository;
    private final DoctorRepository doctorRepository;
    private final ChiefDoctorRepository chiefDoctorRepository;

    public LoginDto loginUser(UserDto userDto) throws RecordNotFoundException {
       Users user = usersRepository.findByUsername(userDto.getUsername());
        if (!user.getPassword().equals(userDto.getPassword())) {
            return new LoginDto(false, null);
        }
        if (usersRepository.existsUsersByUsernameAndPassword(userDto.getUsername(), userDto.getPassword())) {
            return new LoginDto(true, user.getAuthority());
        } else {
            return new LoginDto(false, null);
        }
    }
        public void signupUser(UserDto userDto) throws RecordNotFoundException {
            String username = userDto.getUsername();
            if (usersRepository.findByUsername(username) != null) {
                throw new RecordNotFoundException("Username already exists");
            }

            Users user = userDto.asUser();
            usersRepository.save(user);

            switch (user.getAuthority()) {
                case PATIENT:
                    Patient patient = userDto.asPatient();
                    patient.setUser(user);
                    patientRepository.save(patient);
                    break;
                case DOCTOR:
                    Doctor doctor = userDto.asDoctor();
                    doctor.setUser(user);
                    doctorRepository.save(doctor);
                    break;
                case CHIEF:
                    ChiefDoctor chief = userDto.asChiefDoctor();
                    chief.setUser(user);
                    chiefDoctorRepository.save(chief);
                    break;
                default:
                    throw new RecordNotFoundException("Invalid user authority");
            }
        }
        //2 CONTROLLERS GIA LOGIN+SIGN UP + OTI QUERY SE USERSERVICE GIA FINDUSERNAME&PASSWORD TRUE
    }