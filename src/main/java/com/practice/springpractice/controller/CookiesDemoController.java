package com.practice.springpractice.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;

@RestController
@RequestMapping("api/v1/cookies")
public class CookiesDemoController {
    @GetMapping(value = "/set-cookie/{value}")
    public ResponseEntity<String> setCookie(@PathVariable String value) {
        // create a cookie
        ResponseCookie cookie = ResponseCookie.from("TestCookie", value)
                .httpOnly(true)     // true means that the cookie cannot be accessed by client-side script
                .secure(false)      // true means that the cookie will only be sent over secure connections like HTTPS
                .path("/")          // path of the cookie
                .maxAge(Duration.ofDays(7)) // expiration time. here 7 days
                .build();

        // send cookie in response
        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body("Cookie has been set");
    }

    @GetMapping("")
    public String readCookie(@CookieValue(name = "TestCookie", defaultValue = "default") String userId) {
        return userId;
    }
}
