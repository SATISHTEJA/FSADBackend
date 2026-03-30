package com.bst.controller;

import com.bst.model.Task;
import com.bst.repo.TaskRepo;
import com.bst.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin("*")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskRepo taskRepo;


    @PostMapping
    public Task assignTask(@RequestParam Long studentId,
                           @RequestParam Long internshipId,
                           @RequestParam String title,
                           @RequestParam String description) {

        return taskService.assignTask(studentId, internshipId, title, description);
    }

    // ✅ GET TASKS (FIXED → student + internship)
    @GetMapping("/student/{studentId}/internship/{internshipId}")
    public List<Task> getTasks(@PathVariable Long studentId,
                              @PathVariable Long internshipId) {
        return taskService.getTasksByStudentAndInternship(studentId, internshipId);
    }
    
    @GetMapping("/student/{studentId}")
    public List<Task> getTasksByStudent(@PathVariable Long studentId) {
        return taskService.getTasksByStudent(studentId);
    }

    // ✅ SUBMIT TASK
    @PutMapping("/submit/{taskId}")
    public ResponseEntity<?> submitTask(
            @PathVariable Long taskId,
            @RequestBody Map<String, String> body
    ) {
        Task task = taskRepo.findById(taskId).orElse(null);

        if (task == null) {
            return ResponseEntity.status(404).body("Task not found");
        }

        task.setStatus("COMPLETED");
        task.setSubmissionDescription(body.get("description"));
        task.setSubmissionFileName(body.get("fileName"));
        task.setSubmissionFileData(body.get("fileData"));

        taskRepo.save(task);

        return ResponseEntity.ok("Task submitted successfully");
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<?> deleteTask(@PathVariable Long taskId) {
        if (!taskRepo.existsById(taskId)) {
            return ResponseEntity.status(404).body("Task not found");
        }

        taskRepo.deleteById(taskId);
        return ResponseEntity.ok("Task deleted successfully");
    }
}