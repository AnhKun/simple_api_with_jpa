package com.example.simpleapi.onetoone.services;

import com.example.simpleapi.onetoone.dtos.CommentDto;

import java.util.List;

public interface ICommentService {

    void createComment(long tutorialId, CommentDto commentDto);
    CommentDto getCommentById(long id);

    List<CommentDto> getAllCommentByTutorialId(long tutorialId);

}
