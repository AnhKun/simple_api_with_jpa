package com.example.simpleapi.onetoone.services;

import com.example.simpleapi.onetoone.dtos.CommentDto;

import java.util.List;

public interface ICommentService {
    void createComment(long tutorial_id, CommentDto commentDto);

    CommentDto getCommentById(long id);

    List<CommentDto> getCommentByTutorialId(long tutorial_id);

    void updateComment(long id, CommentDto commentDto);

    void deleteCommentById(long id);

    void deleteCommentsByTutorialId(long tutorial_id);
}
