package gr.pfizer.team5.sacchonapp.service;

import gr.pfizer.team5.sacchonapp.exception.RecordNotFoundException;
import gr.pfizer.team5.sacchonapp.model.ChiefDoctor;
import gr.pfizer.team5.sacchonapp.model.Doctor;
import gr.pfizer.team5.sacchonapp.model.Patient;
import gr.pfizer.team5.sacchonapp.model.Users;
import gr.pfizer.team5.sacchonapp.repository.ChiefDoctorRepository;
import gr.pfizer.team5.sacchonapp.repository.DoctorRepository;
import gr.pfizer.team5.sacchonapp.repository.PatientRepository;
import gr.pfizer.team5.sacchonapp.repository.UsersRepository;

import java.util.Optional;

public class UsersServicesImpl {
    private final PatientRepository patientRepository;
    private final UsersRepository usersRepository;
    private final DoctorRepository doctorRepository;
    private final ChiefDoctorRepository chiefDoctorRepository;
//USERdto na ginei
    public void createUser(UserDto userDto) {
        Users user = new Users();
//        private boolean usernameAvailable(Patient patient) throws RecordNotFoundException {
//            Optional<Patient> patientOptional = patientRepository.findByUsername(patient.getUsername());
//            return patientOptional.isPresent();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setAuthority(userDto.getAuthority());

        switch (user.getAuthority()) {
            case PATIENT:
//                ftiaxnei PatientDto
//                        UseDtoasPatientDto()
                //create
                Patient patient = new Patient();
                patient.setUser(user);

                patientRepository.save(patient);
                break;
            case DOCTOR:
                Doctor doctor = new Doctor;
                doctor.setUser(user);
                doctorRepository.save(doctor);
                break;
            case CHIEF:
                ChiefDoctor chief=new ChiefDoctor();
                chief.setUser(user);
                chiefDoctorRepository.save(user);
                break;
        }
}
