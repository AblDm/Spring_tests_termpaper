package com.example.termtests.service;

import com.example.termtests.dto.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
