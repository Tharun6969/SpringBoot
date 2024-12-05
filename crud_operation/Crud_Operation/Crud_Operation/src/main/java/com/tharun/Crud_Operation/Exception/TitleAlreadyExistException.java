package com.tharun.Crud_Operation.Exception;

public class TitleAlreadyExistException extends RuntimeException{
    public TitleAlreadyExistException(String message){
        super(message);
    }
    public TitleAlreadyExistException(String message,Throwable cause){
        super(message, cause);
    }
}
