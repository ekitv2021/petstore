package com.itvedant.petstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.itvedant.petstore.dtos.ChangePasswordDto;
import com.itvedant.petstore.dtos.LoginDto;
import com.itvedant.petstore.dtos.RegisterUserDto;
import com.itvedant.petstore.dtos.UpdateProfileDto;
import com.itvedant.petstore.entities.User;
import com.itvedant.petstore.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    // @Autowired
    // private BCryptPasswordEncoder bCryptPasswordEncoder;

    public String register(RegisterUserDto data){
        if(this.userRepository.findByEmail(data.getEmail()).isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                                "User with email already exists");
		}
        User user = new User();
        user.setFirstName(data.getFirstName());
        user.setLastName(data.getLastName());
        user.setEmail(data.getEmail());
        // user.setPassword(bCryptPasswordEncoder.encode(data.getPassword()));
        user.setPassword(data.getPassword());
        user.setMobile(data.getMobile());   
        user.setRoles(data.getRoles());
        this.userRepository.save(user);
        return "User Registered Successfully";
    }

    public User login(LoginDto data){
        return null;
    }

    public User changePassword(ChangePasswordDto data){
        return null;
    }

    public User updateProfile(UpdateProfileDto data){
        return null;
    }
}
