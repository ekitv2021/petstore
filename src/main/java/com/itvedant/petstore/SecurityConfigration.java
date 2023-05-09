package com.itvedant.petstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
// import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
// import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
// import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
// import org.springframework.security.web.SecurityFilterChain;

// import com.itvedant.petstore.services.MyUserDetailsService;

// import static org.springframework.security.config.Customizer.withDefaults;

// @EnableWebSecurity
@Configuration
// @EnableMethodSecurity(
//     prePostEnabled = true,
//     jsr250Enabled = true,
//     securedEnabled = true
// )
public class SecurityConfigration {
    
    // @Bean
	// public BCryptPasswordEncoder passwordEncoder() {
	// 	return new BCryptPasswordEncoder();
	// }

//     @Bean
//     public UserDetailsService users() {        
//         UserDetails user = User.builder()
//             .username("user")
//             .password(passwordEncoder().encode("password"))
//             .roles("USER")
//             .build();
//         UserDetails admin = User.builder()
//             .username("admin")
//             .password(passwordEncoder().encode("password"))
//             .roles("ADMIN","USER")
//             .build();
//         return new InMemoryUserDetailsManager(user, admin);
// }

    // @Bean
    // public MyUserDetailsService myUserDetailsService() { 
    //     System.out.println("authen");
    //     return new MyUserDetailsService();
    // }

    // @Bean
    // public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) 
    //             throws Exception{
    //     return configuration.getAuthenticationManager();
    // }

    // @Autowired
    // private MyUserDetailsService myUserDetailsService;   

    // @Bean
    // public DaoAuthenticationProvider daoAuthenticationProvider(){
    //     DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    //     provider.setUserDetailsService(this.myUserDetailsService);
    //     provider.setPasswordEncoder(this.passwordEncoder());
    //     return provider;
    // }

    // @Bean
    // public SecurityFilterChain configure(HttpSecurity http) throws Exception {
    //     http
    //     .csrf().disable()
    //     .authorizeHttpRequests()
    //     .requestMatchers("/auth/register","/auth/login","/products/**").permitAll()
    //     //.requestMatchers("/products/**").hasRole("USER")
    //     .anyRequest().authenticated()
    //     .and()
    //     .httpBasic()
    //     .and()
    //     .authenticationProvider(daoAuthenticationProvider());
    //     return http.build();
    // }
}
