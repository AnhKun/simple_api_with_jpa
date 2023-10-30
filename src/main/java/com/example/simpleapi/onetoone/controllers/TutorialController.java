package com.example.simpleapi.onetoone.controllers;

import com.example.simpleapi.onetoone.dtos.TutorialDto;
import com.example.simpleapi.onetoone.services.ITutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class TutorialController {
    @Autowired
    public ITutorialService tutorialService;


    @GetMapping("/tutorials")
    public ResponseEntity<List<TutorialDto>> getAllTutorials() {
        List<TutorialDto> tutorialDtoList = tutorialService.getAllTutorials();
        if (!tutorialDtoList.isEmpty()) {
            return new ResponseEntity<>(tutorialDtoList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/tutorial/{id}")
    public ResponseEntity<TutorialDto> getTutorialById(@PathVariable long id) {
        TutorialDto tutorialDto = tutorialService.getTutorialById(id);
        if (tutorialDto != null) {
            return new ResponseEntity<>(tutorialDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/tutorials")
    public ResponseEntity<Void> addTutorial(@RequestBody TutorialDto tutorialDto) {
        tutorialService.addTutorial(tutorialDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/tutorials/{id}")
    public ResponseEntity<Void> updateTutorial(@PathVariable long id, @RequestBody TutorialDto tutorialDto) throws Exception {
        tutorialService.updateTutorial(id, tutorialDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/tutorials/published")
    public ResponseEntity<List<TutorialDto>> findByPublished() {
        List<TutorialDto> tutorialDtoList = tutorialService.findByPublished();
        if (!tutorialDtoList.isEmpty()) {
            return new ResponseEntity<>(tutorialDtoList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/tutorial/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        tutorialService.deleteTutorial(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
