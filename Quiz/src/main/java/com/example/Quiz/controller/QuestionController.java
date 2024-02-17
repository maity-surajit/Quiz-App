package com.example.Quiz.controller;

import com.example.Quiz.model.Question;
import com.example.Quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Question")
public class QuestionController {

    @Autowired
    QuestionService service;

    @GetMapping("all_questions")
    public ResponseEntity<List<Question>> getAllQuestion() {
        return service.getAllQuestion();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable("category") String category) {
        return service.getQuestionByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<Question>addQuestion(@RequestBody Question question) {
        return service.addQuestion(question);

    }

    @DeleteMapping("remove/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") int id) {
        return service.deleteById(id);
    }

    @PutMapping("update/{res}")
    public ResponseEntity<Question> updateById(@PathVariable("res") int res, @RequestBody Question question) {
        return service.updateQuestion(res, question);
    }
}
