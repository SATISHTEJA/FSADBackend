package com.bst.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bst.model.Internship;
import com.bst.model.Student;
import com.bst.model.Task;
import com.bst.repo.InternshipRepo;
import com.bst.repo.StudentRepo;
import com.bst.repo.TaskRepo;

@Service
public class TaskServiceImpl implements TaskService {

	 @Autowired
	    private TaskRepo taskRepo;

	    @Autowired
	    private StudentRepo studentRepo;

	    @Autowired
	    private InternshipRepo internshipRepo;

	    @Override
	    public Task assignTask(Long studentId, Long internshipId, String title, String description) {

	        Student student = studentRepo.findById(studentId)
	                .orElseThrow(() -> new RuntimeException("Student not found"));

	        Internship internship = internshipRepo.findById(internshipId)
	                .orElseThrow(() -> new RuntimeException("Internship not found"));

	        Task task = new Task();
	        task.setTitle(title);
	        task.setDescription(description);
	        task.setStatus("PENDING");
	        task.setStudent(student);
	        task.setInternship(internship);

	        return taskRepo.save(task);
	    }

	    @Override
	    public List<Task> getTasksByStudent(Long studentId) {
	        return taskRepo.findByStudentId(studentId);
	    }
	    
	    @Override
	    public List<Task> getTasksByStudentAndInternship(Long studentId, Long internshipId) {
	        return taskRepo.findByStudentIdAndInternshipId(studentId, internshipId);
	    }
}