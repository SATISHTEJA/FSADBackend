package com.bst.controller;

import com.bst.model.Employer;
import com.bst.service.EmployerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employers")
@CrossOrigin(origins = "*")
public class EmployerController {

    @Autowired
    private EmployerService employerService;

    @PostMapping("/register")
    public Employer register(@RequestBody Employer employer) {
        return employerService.register(employer);
    }

    @GetMapping
    public List<Employer> getAllEmployers() {
        return employerService.getAllEmployers();
    }
}