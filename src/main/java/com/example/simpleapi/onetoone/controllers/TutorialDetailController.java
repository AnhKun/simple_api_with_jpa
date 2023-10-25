package com.example.simpleapi.onetoone.controllers;

import com.example.simpleapi.onetoone.dtos.TutorialDetailDto;
import com.example.simpleapi.onetoone.services.ITutorialDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
public class TutorialDetailController {
    @Autowired
    public ITutorialDetailService detailService;

    @GetMapping("/details/{id}")
    public ResponseEntity<TutorialDetailDto> getDetailById(@PathVariable long id) throws Exception {
        TutorialDetailDto tutorialDetailDto = detailService.getDetailById(id);
        if (tutorialDetailDto != null) {
            return new ResponseEntity<>(tutorialDetailDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/tutorials/{tutorialId}/details")
    public ResponseEntity<Void> createDetail(@PathVariable long tutorialId, @RequestBody TutorialDetailDto tutorialDetailDto) throws Exception {
        detailService.createDetail(tutorialId, tutorialDetailDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/details/{id}")
    public ResponseEntity<Void> updateDetail(@PathVariable long id, @RequestBody TutorialDetailDto tutorialDetailDto){
        detailService.updateDetail(id, tutorialDetailDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
