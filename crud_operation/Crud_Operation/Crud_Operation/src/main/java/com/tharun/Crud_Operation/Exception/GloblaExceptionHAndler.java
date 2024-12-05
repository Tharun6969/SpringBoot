package com.tharun.Crud_Operation.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GloblaExceptionHAndler {
    @ExceptionHandler(TutorialRetrivalEcxeption.class)
    public ResponseEntity<String> hanldeTutorialRetrivalEcxeption(TutorialRetrivalEcxeption e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(QuestionRetrievalException.class)
    public ResponseEntity<String> handleQuestionRetrievalException(QuestionRetrievalException e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(TitleAlreadyExistException.class)
    public ResponseEntity<String> handleTitleAlreadyExistException(TitleAlreadyExistException e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);

    }











}
