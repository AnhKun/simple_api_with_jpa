package com.example.simpleapi.onetoone.services;

import com.example.simpleapi.onetoone.dtos.TutorialDto;

import java.util.List;

public interface ITutorialService {

    public List<TutorialDto> getAllTutorials();

    public TutorialDto getTutorialById(long id);

    public void addTutorial(TutorialDto tutorialDto);

    public void updateTutorial(long id, TutorialDto tutorialDto) throws Exception;

    public void deleteTutorial(long id);

    public List<TutorialDto> findByPublished();
}
