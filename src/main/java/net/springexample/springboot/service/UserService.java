package net.springexample.springboot.service;

import net.springexample.springboot.model.User;

import java.util.List;

public interface UserService {

    User save(User user);

    void update(User user);

    List<User> findAll();

    void delete(Long id);

    User findById(Long id);
}
