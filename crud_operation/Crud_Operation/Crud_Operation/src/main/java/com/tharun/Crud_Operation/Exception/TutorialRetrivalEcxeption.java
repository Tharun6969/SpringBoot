package com.tharun.Crud_Operation.Exception;

public class TutorialRetrivalEcxeption extends  RuntimeException{
    public TutorialRetrivalEcxeption(String message){
        super(message);
    }
    public TutorialRetrivalEcxeption(String message ,Throwable cause){
        super(message, cause);
    }
}
