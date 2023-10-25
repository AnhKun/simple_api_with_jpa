package com.example.simpleapi.onetoone.repositories;

import com.example.simpleapi.onetoone.entities.TutorialDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITutorialDetailRepository extends JpaRepository<TutorialDetail, Long> {
}
