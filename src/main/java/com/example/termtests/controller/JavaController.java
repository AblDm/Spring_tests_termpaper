package com.example.termtests.controller;

import com.example.termtests.dto.Question;
import com.example.termtests.service.JavaQuestionService;
import com.example.termtests.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
@RestController
@RequestMapping("/exam/java")
public class JavaController {
    private final QuestionService service;

    public JavaController(QuestionService service) {
        this.service = service;
    }



    @GetMapping(path = "/add")
    public Collection<Question> addQuestion(@RequestParam("question") String question,
                                            @RequestParam("answer") String answer) {
        this.service.add(question, answer);
        return this.service.getAll();
    }

    @GetMapping("/get")
    public Collection<Question> getQuestions() {
        return service.getAll();
    }


    @GetMapping(path = "/remove")
    public Question removeQuestion(@RequestParam("question") String question,
                                   @RequestParam("answer") String answer) {
        Question target = new Question(question, answer);
        return service.remove(target);
    }

}