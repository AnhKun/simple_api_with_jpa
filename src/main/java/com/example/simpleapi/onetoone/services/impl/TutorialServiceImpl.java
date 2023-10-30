package com.example.simpleapi.onetoone.services.impl;

import com.example.simpleapi.onetoone.converter.Mapper;
import com.example.simpleapi.onetoone.dtos.TutorialDto;
import com.example.simpleapi.onetoone.entities.Tutorial;
import com.example.simpleapi.onetoone.repositories.ITutorialRepository;
import com.example.simpleapi.onetoone.services.ITutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorialServiceImpl implements ITutorialService {
    @Autowired
    public ITutorialRepository tutorialRepository;
    @Autowired
    public Mapper mapper;

    @Override
    public List<TutorialDto> getAllTutorials() {
        List<Tutorial> tutorials = tutorialRepository.findAll();
        List<TutorialDto> tutorialDtos = mapper.toList(tutorials, TutorialDto.class);
        return tutorialDtos;
    }

    @Override
    public TutorialDto getTutorialById(long id) {
        Optional<Tutorial> tutorial = tutorialRepository.findById(id);
        if (tutorial.isPresent()) {
            return mapper.toModel(tutorial, TutorialDto.class);
        } else {
            return null;
        }
    }

    @Override
    public void addTutorial(TutorialDto tutorialDto) {
        Tutorial tutorial = mapper.toModel(tutorialDto, Tutorial.class);
        tutorialRepository.save(tutorial);
    }

    @Override
    public void updateTutorial(long id, TutorialDto tutorialDto) throws Exception {
        Tutorial tutorial = tutorialRepository.findById(id).orElseThrow(() -> new Exception("NOT FOUND"));
        tutorial.setTitle(tutorialDto.getTitle());
        tutorial.setDescription(tutorialDto.getDescription());
        tutorial.setPublished(tutorialDto.isPublished());
        tutorialRepository.save(tutorial);
    }

    @Override
    public void deleteTutorial(long id) {
        tutorialRepository.deleteById(id);
    }

    @Override
    public List<TutorialDto> findByPublished() {
        List<Tutorial> tutorialList = tutorialRepository.findByPublished(true);
        List<TutorialDto> tutorialDtoList = mapper.toList(tutorialList, TutorialDto.class);
        return tutorialDtoList;
    }


}
