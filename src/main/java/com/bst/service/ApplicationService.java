package com.bst.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.bst.model.Application;

public interface ApplicationService {

	Application apply(
		    String fullName,
		    String email,
		    String role,
		    String university,
		    Double gpa,
		    Long userId,
		    Long internshipId,
		    MultipartFile file
		) throws IOException;

    List<Application> getAllApplications();
    
    List<Application> getApplicationsByStudent(Long studentId);

    List<Application> getApplicationsByEmployer(Long employerId);
    
    List<Application> getApplicationsByInternship(Long internshipId);

    Application updateStatus(Long applicationId, String status);

    void deleteApplication(Long id);
}