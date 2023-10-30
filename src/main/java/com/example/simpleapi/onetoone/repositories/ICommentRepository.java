package com.example.simpleapi.onetoone.repositories;

import com.example.simpleapi.onetoone.dtos.CommentDto;
import com.example.simpleapi.onetoone.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICommentRepository extends JpaRepository<Comment, Long> {
    //@Query(value = "select * from comment c where c.tutorial_id = :tutorialId", nativeQuery = true)
    List<Comment> findAllByTutorialId(long tutorialId);
}
