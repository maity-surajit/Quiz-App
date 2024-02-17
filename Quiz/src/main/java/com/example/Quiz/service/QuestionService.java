package com.example.Quiz.service;

import com.example.Quiz.dao.QuestionDao;
import com.example.Quiz.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionRepo;

    public ResponseEntity<List<Question>> getAllQuestion() {
        try{
            return new ResponseEntity<>(questionRepo.findAll(), HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
        try{
            return new ResponseEntity<>(questionRepo.findByCategory(category), HttpStatus.OK);
        }catch(Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Question> addQuestion(Question question) {

        try{
            questionRepo.save(question);
            return new ResponseEntity<>(question, HttpStatus.CREATED);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(question, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<?> deleteById(int id) {
        questionRepo.deleteById(id);
        try{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch(Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Question> updateQuestion(int res, Question question) {
        Question target = questionRepo.findById(res).get();
        target.setQuestionTitle(question.getQuestionTitle());
        target.setOption1(question.getOption1());
        target.setOption2(question.getOption2());
        target.setOption3(question.getOption3());
        target.setOption4(question.getOption4());
        target.setRightAnswer(question.getRightAnswer());
        target.setDifficultyLevel(question.getDifficultyLevel());
        target.setCategory(question.getCategory());

        Question updatedQuestion = questionRepo.save(target);
        try{
            return new ResponseEntity<>(updatedQuestion, HttpStatus.OK);
        } catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(question, HttpStatus.BAD_REQUEST);
    }
}
