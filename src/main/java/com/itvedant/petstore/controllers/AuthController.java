package com.itvedant.petstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
// import org.springframework.security.access.annotation.Secured;
// import org.springframework.security.access.prepost.PreAuthorize;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itvedant.petstore.dtos.LoginDto;
import com.itvedant.petstore.dtos.RegisterUserDto;
import com.itvedant.petstore.services.UserService;

import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterUserDto data) {
        return ResponseEntity.ok(this.userService.register(data));
    }

    // @Autowired
    // private AuthenticationManager authenticationManager;

    // @PostMapping("/login")
    // public ResponseEntity<?> login(@RequestBody LoginDto loginDto){
    //     Authentication authentication = authenticationManager.authenticate
    //                 (new UsernamePasswordAuthenticationToken(loginDto.getEmail(), 
    //                                                          loginDto.getPassword()));  
    //     SecurityContextHolder.getContext().setAuthentication(authentication);
    //     return ResponseEntity.ok("User Logged In Successfully!!!");
    // }

    @GetMapping("/demo")
    public void demo(){
        System.out.println("demo");
    }

    // @PreAuthorize("hasRole('ADMIN')")
    // @GetMapping("/check")
    // public void checkPreAuthorize(){
    //     System.out.println("Method Executable by Users with Role ADMIN");
    // }

    // @RolesAllowed("ADMIN")
    // @GetMapping("/checkroles")
    // public void checkRolesAllowed(){
    //     System.out.println("Method Executable by Users with Role ADMIN");
    // }

    // @Secured("ROLE_ADMIN")
    // @GetMapping("/checksecured")
    // public void checkSecured(){
    //     System.out.println("Method Executable by Users with Role ADMIN");
    // }
}
