package com.example.javaclasswork9.services;


import com.example.javaclasswork9.dao.UserDAO;
import com.example.javaclasswork9.models.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImplementation implements UserService{

    private UserDAO userDAO;


    @Override
    public void saveUser(User user) {
        userDAO.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userDAO.findAll();
    }

    @Override
    public User getUserById(@PathVariable int id) {
        Optional<User> userbyId = userDAO.findById(id);
        return userbyId.orElse(null);
    }

    @Override
    public User updateUser(@PathVariable int id,
                           @RequestParam int age,
                           @RequestParam String password,
                           @RequestParam String mail) {
        User user = userDAO.getOne(id);
        user.setAge(age);
        user.setPassword(password);
        user.setMail(mail);
        return userDAO.save(user);
    }

    @Override
    public void deleteUser(@PathVariable int id) {
        User one = userDAO.getOne(id);
        userDAO.delete(one);
    }
}
