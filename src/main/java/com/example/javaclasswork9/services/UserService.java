package com.example.javaclasswork9.services;


import com.example.javaclasswork9.models.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    void saveUser(User user);

    List<User> getUsers();

    User getUserById(int id);

    User updateUser(int id, int age, String password, String mail);

    void deleteUser(int id);



}
