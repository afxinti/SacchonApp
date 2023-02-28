package gr.pfizer.team5.sacchonapp.controller;

import gr.pfizer.team5.sacchonapp.dto.LoginDto;
import gr.pfizer.team5.sacchonapp.dto.UserDto;
import gr.pfizer.team5.sacchonapp.exception.RecordNotFoundException;
import gr.pfizer.team5.sacchonapp.service.UsersServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserController {
    private final UsersServices userServices;
    @GetMapping("/login/patient")
    public LoginDto loginUser(@RequestBody UserDto userDto) throws RecordNotFoundException {
        return userServices.loginUser(userDto);
    }
    @PostMapping("/signup")
        public boolean signupUser(@RequestBody UserDto userDto) throws RecordNotFoundException {
        return userServices.signupUser(userDto);
    }
}
