package com.example.termtests.dto;

import com.example.termtests.exceptions.BedRequestException;
import com.example.termtests.record.QuestionRequest;

import java.util.Objects;

public class Question extends QuestionRequest {
    private final String question;
    private final String answer;



    public Question(String question, String answer) {
        if (question==null || question.isBlank()) {
            throw new BedRequestException("incorrect questions");
        }
        if (answer==null ||answer.isBlank()) {
            throw new BedRequestException("incorrect questions");
        }
        this.question = question;
        this.answer = answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(this.question, question.question) && Objects.equals(answer, question.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, answer);
    }
    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}