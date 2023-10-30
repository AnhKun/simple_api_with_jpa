package com.example.simpleapi.onetoone.controllers;

import com.example.simpleapi.onetoone.dtos.CommentDto;
import com.example.simpleapi.onetoone.services.ICommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class CommentController {

    private final  ICommentService commentService;

    @GetMapping("/comment/{id}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable long id) {
        var commentDto = commentService.getCommentById(id);
        if (commentDto != null) {
            return new ResponseEntity<>(commentDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/tutorials/{tutorialId}/comments")
    public ResponseEntity<Void> createDetail(@PathVariable long tutorialId, @RequestBody CommentDto commentDto) throws Exception {
        commentService.createComment(tutorialId, commentDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/tutorials/{tutorialId}/comments")
    public ResponseEntity<List<CommentDto>> getAllCommentsByTutorialId(@PathVariable long tutorialId){
        var commentList = commentService.getAllCommentByTutorialId(tutorialId);
        return new ResponseEntity<>(commentList, HttpStatus.OK);
    }


}
