package com.bst.service;

import com.bst.model.Evaluation;
import com.bst.model.Student;
import com.bst.repo.EvaluationRepo;
import com.bst.repo.ApplicationRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluationServiceImpl implements EvaluationService {

    @Autowired
    private EvaluationRepo evaluationRepo;

    @Autowired
    private ApplicationRepo applicationRepo; // ✅ ADD THIS

    @Override
    public Evaluation save(Evaluation evaluation) {
        return evaluationRepo.save(evaluation);
    }

    @Override
    public List<Evaluation> getAll() {
        return evaluationRepo.findAll();
    }

    @Override
    public List<Evaluation> getByStudent(Long studentId) {
        return evaluationRepo.findByStudentId(studentId);
    }

    @Override
    public List<Evaluation> getByTask(Long taskId) {
        return evaluationRepo.findByTaskId(taskId);
    }

    @Override
    public boolean exists(Long studentId, Long taskId) {
        return evaluationRepo
            .findByStudentIdAndTaskId(studentId, taskId)
            .isPresent();
    }

    @Override
    public void delete(Long id) {
        evaluationRepo.deleteById(id);
    }

}