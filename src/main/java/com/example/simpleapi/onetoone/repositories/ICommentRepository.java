package com.example.simpleapi.onetoone.repositories;

import com.example.simpleapi.onetoone.entities.Comment;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICommentRepository extends JpaRepository<Comment, Long> {
    @Query(value = "select * from comment c where c.tutorial_id = :id", nativeQuery = true)
    List<Comment> findCommentByTutorialId(long id);

    //@Query(value = "delete from comment c where c.tutorial_id = :tutorial_id", nativeQuery = true)
    @Transactional
    void deleteCommentByTutorialId(long tutorial_id);
}
