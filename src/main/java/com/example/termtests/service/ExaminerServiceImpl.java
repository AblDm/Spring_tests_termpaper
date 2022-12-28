package com.example.termtests.service;

import com.example.termtests.dto.Question;
import com.example.termtests.exceptions.BedRequestException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> result = new HashSet<>();
        if (amount <= 0 || questionService.getAll().size() < amount) {
            throw new BedRequestException("Такого");
        }

        while (result.size() < amount) {
            result.add(questionService.getRandomQuestion());
        }
        return result;
    }
}