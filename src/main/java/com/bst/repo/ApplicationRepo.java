package com.bst.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bst.model.Application;
import com.bst.model.Student;

public interface ApplicationRepo extends JpaRepository<Application,Long>{

 List<Application> findByStudentId(Long studentId);

 List<Application> findByInternshipId(Long internshipId);
 
 Optional<Application> findByStudentIdAndInternshipId(Long studentId, Long internshipId);
 
 List<Application> findByInternshipEmployerId(Long employerId);
}