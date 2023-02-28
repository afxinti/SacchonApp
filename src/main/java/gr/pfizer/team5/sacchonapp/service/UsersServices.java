package gr.pfizer.team5.sacchonapp.service;

import gr.pfizer.team5.sacchonapp.dto.LoginDto;
import gr.pfizer.team5.sacchonapp.dto.UserDto;
import gr.pfizer.team5.sacchonapp.exception.RecordNotFoundException;

public interface UsersServices {
    LoginDto loginUser(UserDto userDto) throws RecordNotFoundException;
    boolean signupUser(UserDto userDto) throws RecordNotFoundException;
}
