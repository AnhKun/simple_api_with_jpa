package com.example.simpleapi.onetoone.controllers;

import com.example.simpleapi.onetoone.dtos.CommentDto;
import com.example.simpleapi.onetoone.services.ICommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CommentController {
    private final ICommentService commentService;

    @PostMapping("/tutorials/{tutorial_id}/comments")
    public ResponseEntity<Void> createComment(@PathVariable long tutorial_id, @RequestBody CommentDto commentDto) {
        commentService.createComment(tutorial_id, commentDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/comments/{id}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable long id) {
        var commentDto = commentService.getCommentById(id);
        return new ResponseEntity<>(commentDto, HttpStatus.OK);
    }

    @GetMapping("/tutorials/{tutorial_id}/comments")
    public ResponseEntity<List<CommentDto>> getCommentByTutorialId(@PathVariable long tutorial_id) {
        List<CommentDto> commentDtoList = commentService.getCommentByTutorialId(tutorial_id);
        return new ResponseEntity<>(commentDtoList, HttpStatus.OK);
    }

    @PutMapping("/comments/{id}")
    public ResponseEntity<Void> updateComment(@PathVariable long id, @RequestBody CommentDto commentDto) {
        commentService.updateComment(id, commentDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/comments/{id}")
    public ResponseEntity<Void> deleteCommentById(@PathVariable long id) {
        commentService.deleteCommentById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/tutorials/{tutorial_id}/comments")
    public ResponseEntity<Void> deleteCommentByTutorialId(@PathVariable long tutorial_id) {
        commentService.deleteCommentsByTutorialId(tutorial_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
