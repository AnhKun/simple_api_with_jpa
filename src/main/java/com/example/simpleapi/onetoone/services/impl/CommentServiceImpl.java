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
    private final ICommentRepository iCommentRepository;
    private final Mapper mapper;
    private final ITutorialRepository iTutorialRepository;

    @Override
    public void createComment(long tutorial_id, CommentDto commentDto) {
        var tutorial = iTutorialRepository.findById(tutorial_id)
                .orElseThrow(() -> new IllegalArgumentException("cannot find tutorial_id"));
        var comment = new Comment();
        comment.setContent(commentDto.getContent());
        comment.setTutorial(tutorial);
        iCommentRepository.save(comment);
    }

    @Override
    public CommentDto getCommentById(long id) {
        var comment = iCommentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("cannot find comment id"));
        return mapper.toModel(comment, CommentDto.class);

    }

    @Override
    public List<CommentDto> getAllCommentByTutorialId(long tutorialId) {
        List<Comment> commentList = iCommentRepository.findAllByTutorialId(tutorialId);
        return mapper.toList(commentList, CommentDto.class);

    }
}
