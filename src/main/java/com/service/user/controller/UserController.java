package com.service.user.controller;

import com.service.user.model.UserDomain;
import com.service.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/userservice")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/healthcheck")
    public String healthCheck(){
        return "***** Welcome to the User Service Application - Health check !!! updated ! 01/03/2021";
    }

    @PostMapping("/create-user")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveUser(@RequestBody UserDomain user){
        userRepository.save(user);
        return "User data inserted successfully!!!";
    }

    @PutMapping("/update-user/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDomain updateUser(@PathVariable Integer id,@RequestBody UserDomain user){
        Optional<UserDomain> userObj  = userRepository.findById(id);
        if(userObj.isPresent()){
            return userRepository.save(user);
        }else{
            System.out.println("No user data to update");
            return null;
        }
    }


    @GetMapping("/fetch-user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<UserDomain> getUser(@PathVariable Integer id) throws ConfigDataResourceNotFoundException {
        if(userRepository.existsById(id)) {
            return userRepository.findById(id);
        }else{
            return Optional.empty();
        }
    }


    @GetMapping("/fetch-user-all")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDomain> getAllUsers(){
        return userRepository.findAll();
    }
    @DeleteMapping("/delete-user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletebyUserId(@PathVariable Integer id){
        System.out.println("Delete user");
        userRepository.deleteById(id);
    }

}


