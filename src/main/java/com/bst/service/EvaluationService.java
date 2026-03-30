package com.bst.service;

import com.bst.model.Evaluation;
import com.bst.model.Student;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

public interface EvaluationService {

    Evaluation save(Evaluation evaluation);

    List<Evaluation> getAll();

    List<Evaluation> getByStudent(Long studentId);

    List<Evaluation> getByTask(Long taskId);
    
    boolean exists(Long studentId, Long taskId);
    
    

    public void delete(Long id);

}