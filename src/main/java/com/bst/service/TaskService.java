package com.bst.service;

import java.util.List;
import com.bst.model.Task;

public interface TaskService {

	Task assignTask(Long studentId, Long internshipId, String title, String description);

    List<Task> getTasksByStudent(Long studentId);

    List<Task> getTasksByStudentAndInternship(Long studentId, Long internshipId);
}