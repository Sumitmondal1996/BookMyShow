package com.scaler.bookmyshow.services;

import com.scaler.bookmyshow.dtos.ResponseStatus;
import com.scaler.bookmyshow.exception.UserNotFoundException;
import com.scaler.bookmyshow.models.User;
import com.scaler.bookmyshow.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    public User signup(String email, String name, String password) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            return user.get();
        }
        else
        {
            User newUser = new User();
            newUser.setEmail(email);

            newUser.setPassword("password");
            newUser.setName(name);
            newUser.setPassword(bCryptPasswordEncoder.encode(password));
            return userRepository.save(newUser);

        }
    }
    public ResponseStatus login(String email, String password) throws UserNotFoundException {
        Optional<User> optionalUser= userRepository.findByEmail(email);
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException("User with email "+ email+ " not found.");
        }
        else
        {
            User user = optionalUser.get();
            if(bCryptPasswordEncoder.matches(password,user.getPassword()))
            {
                return ResponseStatus.SUCCESS;
            }
            else
            {
                return ResponseStatus.FAILURE;
            }


        }
    }
}
