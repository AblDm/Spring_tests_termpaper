package com.example.termtests.service;

import com.example.termtests.dto.Question;
import com.example.termtests.exceptions.QuestionAlreadyExistsException;
import com.example.termtests.exceptions.QuestionNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {


    public final Set<Question> questions = new HashSet<>();
    private final Random random = new Random();

    @Override
    public Question add(Question question) {

        if (questions.contains(question)) {
            throw new QuestionAlreadyExistsException("Вопрос уже есть в списке");
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question add(String question, String answer) {

        return add(new Question(question, answer));
    }

    @Override
    public Question remove(Question question) {
        if (!questions.contains(question)) {
            throw new QuestionNotFoundException("Вопрос не найден в списке");
        }
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> tmp = new ArrayList<>(getAll());
        int size = tmp.size();

        if (tmp.isEmpty()) {
            throw new QuestionNotFoundException("BAD_REQUEST.");
        }
        int index = random.nextInt(size);
        return tmp.get(index);
    }


}
