package com.practice.springpractice.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("api/v1/response-entity")
public class ResponseEntityDemoController {
    @GetMapping("/manual")
    void manual(HttpServletResponse response) throws IOException {
        response.setHeader("Custom-Header", "foo");
        response.setStatus(200);
        response.getWriter().println("Hello World!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getData(@PathVariable String id) {
        if (id.equals("unknown")) {
            return new ResponseEntity<>("Data with id: " + id + " not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Hello from getData with id: " + id, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createData(@RequestBody String data) {
        if (data.equals("bad data")) {
            return new ResponseEntity<>("Failed to create data", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Data created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateData(@PathVariable String id, @RequestBody String data) {
        if (id.equals("unknown")) {
            return new ResponseEntity<>("Failed to update, data with id: " + id + " not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Data with id: " + id + " updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteData(@PathVariable String id) {
        HashMap<String, String> responseMessage = new HashMap<>();
        if (id.equals("unknown")) {
            responseMessage.put("message", "Data with id: " + id + " not found, hence could not be deleted");
            return new ResponseEntity<>(responseMessage, HttpStatus.NOT_FOUND);
        }

        responseMessage.put("message", "Data with id: " + id + " deleted successfully");
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }
}
