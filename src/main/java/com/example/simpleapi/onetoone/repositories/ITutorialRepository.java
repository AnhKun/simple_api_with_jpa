package com.example.simpleapi.onetoone.repositories;

import com.example.simpleapi.onetoone.entities.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITutorialRepository extends JpaRepository<Tutorial, Long> {
    public List<Tutorial> findByPublished(boolean published);
}
