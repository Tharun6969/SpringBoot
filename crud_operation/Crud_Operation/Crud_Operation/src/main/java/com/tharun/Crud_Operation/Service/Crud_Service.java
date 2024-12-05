package com.tharun.Crud_Operation.Service;

import com.tharun.Crud_Operation.Exception.QuestionRetrievalException;
import com.tharun.Crud_Operation.Exception.TitleAlreadyExistException;
import com.tharun.Crud_Operation.Exception.TutorialRetrivalEcxeption;
import com.tharun.Crud_Operation.Model.Crud_Model;
import com.tharun.Crud_Operation.Repository.Crud_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Crud_Service {
    @Autowired
    private Crud_repo rep;
    public ResponseEntity<?> getTutorial(String title ){
        try{

            if(title==null){
                List<Crud_Model> tutorial=rep.findAll();
                if(tutorial.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }
                return new ResponseEntity<>(tutorial, HttpStatus.OK);
            }
            else{
                Optional<Crud_Model> tut=rep.findByTitle(title);
                if(tut.isEmpty()){
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(tut,HttpStatus.OK);

            }
        }
        catch (DataAccessException e){
            throw new TutorialRetrivalEcxeption("Failed to retrieve tutorial",e);
        }


    }

    public ResponseEntity<Crud_Model> getTutorialById(long id) {

        try{
            Optional<Crud_Model> tutorialById =rep.findById(id);
            if(tutorialById.isEmpty()){
                throw new QuestionRetrievalException("Question not found");
            }
            return new ResponseEntity<>(tutorialById.get(),HttpStatus.OK);
        }
        catch (DataAccessException e){
            throw new QuestionRetrievalException("cannot retrieve from database",e);
        }
    }

    public ResponseEntity<String> createTutorial(Crud_Model tutorial) {
        try{
            Optional<Crud_Model> existingT =rep.findByTitle(tutorial.getTitle());
            if(existingT.isEmpty()){
                rep.save(new Crud_Model(tutorial.getTitle(),tutorial.getDescription(),false));
                return new ResponseEntity<>("tutorial Saved Successfully",HttpStatus.CREATED);
            }
            else{
                throw  new TitleAlreadyExistException("Tutorial Title Already Exist");
            }
        }
        catch(DataAccessException e){
            throw  new TitleAlreadyExistException("Failed to create tutorial",e);
        }
    }
    public ResponseEntity<String> updateTutorial(long id,Crud_Model tutorial){
        try{
            Optional<Crud_Model> turo=rep.findById(id);
            if(turo.isPresent()){
                Crud_Model tut_obj=turo.get();
                tut_obj.setTitle(tutorial.getTitle());
                tut_obj.setDescription(tutorial.getDescription());
                tut_obj.setPublished(tutorial.isPublished());
                rep.save(tut_obj);
                return new ResponseEntity<>("turotial Updated  successfully",HttpStatus.OK);

            }
            else {
                throw new TutorialRetrivalEcxeption("Tutorial with id does not exist");
            }

        }
        catch (DataAccessException e){
            throw  new TutorialRetrivalEcxeption("database cannot update it",e);
        }


    }


    public ResponseEntity<String> deleteTutorial(Long id) {
        try{
            if(id ==null){
                rep.deleteAll();
                return new ResponseEntity<>("Deleted all Tutorial ",HttpStatus.OK);
            }
            else{
                rep.deleteById(id);
                return new ResponseEntity<>("Deleted id "+id+" Tutorial Sucessfully",HttpStatus.OK);
            }
        }
        catch (DataAccessException e){

            return new ResponseEntity<>("database error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Crud_Model>> findPublished() {
        try{
            List<Crud_Model> tutorial=rep.findByPublished(true);
            return new ResponseEntity<>(tutorial,HttpStatus.OK);
        }
        catch (DataAccessException e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }




    }
}
