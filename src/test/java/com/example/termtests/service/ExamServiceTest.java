package com.example.termtests.service;

import com.example.termtests.dto.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.example.termtests.QuestionsFabric.MINUS_ONE;
import static com.example.termtests.QuestionsFabric.ONE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExamServiceTest {
    @Mock
    private QuestionService questionService;

    private ExaminerService examinerService;

    @BeforeEach
    void init() {
        examinerService = new ExaminerServiceImpl(questionService);
        Set<Question> tmp = new HashSet<>(List.of(
                new Question("question1", "answer1"),
                new Question("question2", "answer2"),
                new Question("question3", "answer3")
        ));
        when(questionService.getAll()).thenReturn(tmp);
        when(questionService.getRandomQuestion()).thenReturn(new Question("question1", "answer1"));
    }

    @Test
    void shouldReturnCollectionWithOneQuestion() {
        assertEquals(examinerService.getQuestions(ONE),
                new HashSet<>(Set.of(new Question("question1", "answer1"))));

    }

    @Test
    @MockitoSettings(strictness = Strictness.LENIENT)
    void shouldThrowBadRequestExceptionWhenParams() {
        Throwable thrown = catchThrowable(() -> examinerService.getQuestions(MINUS_ONE));
        assertThat(thrown).isInstanceOf(RuntimeException.class);
        assertThat(thrown.getMessage()).isNotBlank();

        thrown = catchThrowable(() -> examinerService.getQuestions(Integer.MAX_VALUE));
        assertThat(thrown).isInstanceOf(RuntimeException.class);
        assertThat(thrown.getMessage()).isNotBlank();
    }
}
