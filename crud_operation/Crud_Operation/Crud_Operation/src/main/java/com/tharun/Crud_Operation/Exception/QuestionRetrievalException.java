package com.tharun.Crud_Operation.Exception;

public class QuestionRetrievalException extends RuntimeException {
    public QuestionRetrievalException(String message){
        super(message);
    }
    public QuestionRetrievalException(String message,Throwable cause){
        super(message, cause);
    }
}
