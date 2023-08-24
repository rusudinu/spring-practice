package com.practice.springpractice.service;

import com.practice.springpractice.model.User;
import com.practice.springpractice.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User saveUser(User userToSave) {
        return userRepository.save(userToSave);
    }

    @Transactional
    public boolean logIn(User userToLog) {
        User userFromDb = userRepository.findByUsername(userToLog.getUsername());
        boolean boolLogIn = userFromDb
                .getPassword().equals(userToLog.getPassword());
        if (boolLogIn) {
            userRepository.incrementSuccessAttempts(userFromDb.getId());
        } else {
            userRepository.incrementFailedAttempts(userFromDb.getId());
        }
        return boolLogIn;
    }
}
