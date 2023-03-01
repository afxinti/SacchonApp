package gr.pfizer.team5.sacchonapp.repository;

import gr.pfizer.team5.sacchonapp.exception.RecordNotFoundException;
import gr.pfizer.team5.sacchonapp.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UsersRepository  extends JpaRepository<Users, Integer>  {
    //loginQuery
  @Query("select (count(u) = 1) from Users u where u.username = ?1 and u.password = ?2")
  boolean existsUsersByUsernameAndPassword(String username,String password);



  @Query("select (count(u) = 1) from Users u where u.username = ?1")
  boolean existsUsersByUsername(String username)throws RecordNotFoundException;

  @Query("select u from Users u where u.username = ?1")
  Users findByUsername (String username) throws RecordNotFoundException;


}

