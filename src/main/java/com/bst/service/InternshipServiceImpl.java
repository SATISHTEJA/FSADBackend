package com.bst.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bst.model.Employer;
import com.bst.model.Internship;
import com.bst.repo.EmployerRepo;
import com.bst.repo.InternshipRepo;

@Service
public class InternshipServiceImpl implements InternshipService {

    @Autowired
    private InternshipRepo internshipRepository;

    @Autowired
    private EmployerRepo employerRepo;

    public Internship createInternship(Internship internship, Long employerId) {
        Employer employer = employerRepo.findById(employerId)
                .orElseThrow(() -> new RuntimeException("Employer not found"));

        internship.setEmployer(employer);

        return internshipRepository.save(internship);
    }

    @Override
    public List<Internship> getAllInternships() {
        return internshipRepository.findAll();
    }

    @Override
    public Internship getInternshipById(Long id) {
        return internshipRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Internship not found"));
    }

    @Override
    public void deleteInternship(Long id) {
        internshipRepository.deleteById(id);
    }

    @Override
    public List<Internship> getByEmployerId(Long employerId) {
        return internshipRepository.findByEmployerId(employerId);
    }
}