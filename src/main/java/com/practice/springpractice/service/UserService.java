package com.practice.springpractice.service;

import com.practice.springpractice.model.User;
import com.practice.springpractice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService{
    private final UserRepository userRepository;

    public User saveUser(User userToSave) {
       return userRepository.save(userToSave);
    }

    public boolean logIn(User userToLog) {
        return userRepository.findByUsername(userToLog.getUsername())
                .getPassword().equals(userToLog.getPassword());
    }
}
