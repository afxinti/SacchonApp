package gr.pfizer.team5.sacchonapp.repository;

import gr.pfizer.team5.sacchonapp.model.Doctor;
import gr.pfizer.team5.sacchonapp.model.Patient;
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
  Users findByUsername(String username);


  public void createUser(UserDto userDto) {
    Users user = new Users();
    user.setUsername(userDto.getUsername());
    user.setPassword(userDto.getPassword());
    user.setAuthority(userDto.getAuthority());

    switch (user.getAuthority()) {
      case PATIENT:
        Patient patient = new Patient();
        patient.setUser(user);
        patientRepository.save(patient);
        break;
      case DOCTOR:
        Doctor doctor = new Doctor;
        doctor.setUser(user);
        doctorRepository.save(doctor);
}
