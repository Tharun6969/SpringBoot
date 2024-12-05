package com.tharun.Crud_Operation.Controller;

import com.tharun.Crud_Operation.Model.Crud_Model;
import com.tharun.Crud_Operation.Service.Crud_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tharun")
public class Crud_Controller {
    @Autowired
    private Crud_Service ser;

    @GetMapping("/tutorial")
    public ResponseEntity<?> getTutorial(@RequestParam(required = false) String title){
        return ser.getTutorial(title);
    }

    @GetMapping("/tutorial/{id}")
    public ResponseEntity<Crud_Model> getTutorialById(@RequestParam long id){
        return ser.getTutorialById(id);

    }
    @PostMapping("tutorial")
    public ResponseEntity<String> createTutorial(@RequestBody Crud_Model tutorial){
        return ser.createTutorial(tutorial);
    }
    @PutMapping("/tutorial/{id}")
    public ResponseEntity<String> updateTutorial(@PathVariable long id, @RequestBody Crud_Model tutorial){
        return ser.updateTutorial(id,tutorial);
    }
    @DeleteMapping("/tutorial")
    public ResponseEntity<String> deleteTutorial(@RequestParam(required = false )Long id){
        return ser.deleteTutorial(id);
    }
    @GetMapping("/tutorial/Published")
    public ResponseEntity<List<Crud_Model>> findPublished(){
        return ser.findPublished();


    }




}
