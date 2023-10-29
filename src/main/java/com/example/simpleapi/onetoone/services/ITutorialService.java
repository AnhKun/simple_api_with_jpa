package com.example.simpleapi.onetoone.services;

import com.example.simpleapi.onetoone.dtos.TutorialDto;

import java.util.List;

public interface ITutorialService {

    List<TutorialDto> getAllTutorials();

    TutorialDto getTutorialById(long id);

    void addTutorial(TutorialDto tutorialDto);

    void updateTutorial(long id, TutorialDto tutorialDto) throws Exception;

    void deleteTutorial(long id);

    List<TutorialDto> findByPublished();
}
