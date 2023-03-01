package gr.pfizer.team5.sacchonapp.controller;

import gr.pfizer.team5.sacchonapp.dto.LoginDto;
import gr.pfizer.team5.sacchonapp.dto.UserDto;
import gr.pfizer.team5.sacchonapp.exception.CustomException;
import gr.pfizer.team5.sacchonapp.service.UsersServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserController {
    private final UsersServices userServices;
    @PostMapping("/login")
    public LoginDto loginUser(@RequestBody UserDto userDto) throws CustomException {
        return userServices.loginUser(userDto);
    }

    //Second way for signup
//    @PostMapping("/signup")
//        public boolean signupUser(@RequestBody UserDto userDto) throws RecordNotFoundException {
//        return userServices.signupUser(userDto);
//    }
}
