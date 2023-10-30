package com.example.simpleapi.onetoone.services.impl;

import com.example.simpleapi.onetoone.converter.Mapper;
import com.example.simpleapi.onetoone.dtos.CommentDto;
import com.example.simpleapi.onetoone.entities.Comment;
import com.example.simpleapi.onetoone.entities.Tutorial;
import com.example.simpleapi.onetoone.repositories.ICommentRepository;
import com.example.simpleapi.onetoone.repositories.ITutorialRepository;
import com.example.simpleapi.onetoone.services.ICommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements ICommentService {
    private final ICommentRepository commentRepository;
    private final ITutorialRepository tutorialRepository;
    private final Mapper mapper;

    @Override
    public void createComment(long tutorial_id, CommentDto commentDto) {
        Tutorial tutorial = tutorialRepository.findById(tutorial_id)
                .orElseThrow(() -> new IllegalArgumentException("cannot find tutorial_id"));
        Comment comment = new Comment();
        comment.setContent(commentDto.getContent());
        comment.setTutorial(tutorial);
        commentRepository.save(comment);
    }

    @Override
    public CommentDto getCommentById(long id) {
        var comment = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("cannot find comment id"));
        return mapper.toModel(comment, CommentDto.class);
    }

    @Override
    public List<CommentDto> getCommentByTutorialId(long tutorial_id) {
        List<Comment> commentList = commentRepository.findCommentByTutorialId(tutorial_id);
        return mapper.toList(commentList, CommentDto.class);
    }

    @Override
    public void updateComment(long id, CommentDto commentDto) {
        var comment = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("cannot find comment id"));
        comment.setContent(commentDto.getContent());
        commentRepository.save(comment);
    }

    @Override
    public void deleteCommentById(long id) {
        commentRepository.deleteById(id);

    }

    @Override
    public void deleteCommentsByTutorialId(long tutorial_id) {
        commentRepository.deleteCommentByTutorialId(tutorial_id);
    }
}
