package gr.pfizer.team5.sacchonapp.repository;

import gr.pfizer.team5.sacchonapp.exception.RecordNotFoundException;
import gr.pfizer.team5.sacchonapp.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository  extends JpaRepository<Users, Integer>  {
    //loginQuery
  @Query("select (count(u) = 1) from Users u where u.username = ?1 and u.password = ?2")
  boolean existsUsersByUsernameAndPassword(String username,String password);

  //0
  @Query("select u from Users u where u.username = ?1")
  Users findByUsername(String username)throws RecordNotFoundException;

//
//  public void createUser(UserDto userDto) {
//    Users user = new Users();
//    user.setUsername(userDto.getUsername());
//    user.setPassword(userDto.getPassword());
//    user.setAuthority(userDto.getAuthority());
//
//    switch (user.getAuthority()) {
//      case PATIENT:
//        Patient patient = new Patient();
//        patient = UserDto.asPatient();
//        //patient set userId
//        patient.setUser(user);
//        patientRepository.save(patient);
//        break;
//      case DOCTOR:
//        Doctor doctor = new Doctor;
//        doctor.setUser(user);
//        doctorRepository.save(doctor);
//    }
//
//    public<T>signupUser(T t) throws RecordNotFoundException {
//      Users user = new User();
//      user.setUsername(t.getUsername());
//      user.setPassword(t.getPassword());
//      user.setAuthority(t.getAuthority());
//      switch (user.getAuthority()){
//        case Patient:
//          Patient patient =new Patient();
//          patient = t.asPatiet();
//          patient.setUser(user);
//          patientRepository.savee(patient);
//      }
//
//    }

    }

