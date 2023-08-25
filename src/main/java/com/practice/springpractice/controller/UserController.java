

package com.practice.springpractice.controller;

import com.practice.springpractice.model.User;
import com.practice.springpractice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        ResponseCookie cookie = ResponseCookie.from("username", user.getUsername()).secure(false).maxAge(Duration.ofDays(7)).build();
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString()).body(userService.saveUser(user));
    }

    @PostMapping("login-no-username")
    public boolean logNoUsername(@RequestBody User user, @CookieValue(name = "username", defaultValue = "default") String username) {
        user.setUsername(username);
        return userService.logIn(user);
    }

    @PostMapping("login")
    public boolean logUser(@RequestBody User user) {
        return userService.logIn(user);
    }
}

