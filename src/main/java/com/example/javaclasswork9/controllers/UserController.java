package com.example.javaclasswork9.controllers;


import com.example.javaclasswork9.models.User;
import com.example.javaclasswork9.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping("/save")
    public void saveUser(@RequestParam String firstname,
                         @RequestParam String lastname,
                         @RequestParam int age,
                         @RequestParam String mail,
                         @RequestParam String password,
                         @RequestParam MultipartFile avatar) {

        String pathToImageFolder =
            System.getProperty("user.home") + File.separator + ("pictures2") + File.separator + avatar.getOriginalFilename();

        try {
            avatar.transferTo(new File(pathToImageFolder));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String filename = avatar.getOriginalFilename();
        User user = new User(firstname,lastname, age, mail, password, filename);
        userService.saveUser(user);

    }

    @GetMapping("")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/user{id}")
    public User getUser(@PathVariable int id){
        return userService.getUserById(id);
    }

    @PostMapping("/user{id}/update")
    public User updateUser(@PathVariable int id,
                           @RequestParam int age,
                           @RequestParam String password,
                           @RequestParam String mail){
        ;
        return userService.updateUser(id, age, password, mail);
    }

    @GetMapping("user{id}/delete")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }





}
